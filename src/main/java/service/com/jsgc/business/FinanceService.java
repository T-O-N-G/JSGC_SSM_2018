package service.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.com.jsgc.business.BudgetDetailMapper;
import mapper.com.jsgc.business.ContractMapper;
import mapper.com.jsgc.business.FinanceMapper;
import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.BudgetDetail;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Finance;
import pojo.com.jsgc.business.Project;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.UpdateCache;
import util.com.jsgc.searchCondition.FinanceSearchConditions;
import util.com.jsgc.searchCondition.ProjectSearchConditions;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

@Service
public class FinanceService {
    Calendar calendar = new GregorianCalendar();
    @Resource
    private FinanceMapper financeMapper;
    @Resource
    private ContractMapper contractMapper;
    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private BudgetDetailMapper budgetDetailMapper;

//    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jedis.xml");
//
//    public JedisPool jedisPool = (JedisPool) ac.getBean("jedisPool");//注入JedisPool

    @Autowired
    public JedisPool jedisPool;//注入JedisPool

    public List<Finance> batchChosenDownLoad(FinanceSearchConditions fs) {
        return financeMapper.selectByConditions(fs);
    }

    public String searchByConditions(FinanceSearchConditions fs) {

//        projectMapper.searchByConditions();
        //    System.out.println(fs.getStart()+" "+ps.getLimit());

        Page page = PageHelper.startPage(fs.getPage(), fs.getLimit(), true);
        List<Finance> finances = financeMapper.selectByConditions(fs);

        System.out.println(page.getTotal());
        System.out.println("分页数据:");
        PageInfo<Finance> pageInfo = new PageInfo<>(finances);
        System.out.println(pageInfo.getList());
        System.out.println(finances);

        HashMap map = new HashMap();
        map.put("total", page.getTotal());
        map.put("data", finances);
        return JSON.toJSONString(map);

    }


    public String getFinanceDetail(int financeID) {
        Jedis jedis = jedisPool.getResource();
        String key = "Finance:ID:" + financeID;
        System.out.println(key);
        String result = jedis.get(key);
        //回收ShardedJedis实例
        jedis.close();
        System.out.println(result);
        return result;
    }

    public int updateFinanceDetail(Finance finance, int userId) {
        calendar.setTime(finance.getFinanceDate());
        calendar.add(calendar.DATE, 1);
        finance.setFinanceDate(calendar.getTime());
        try {
            if (financeMapper.ifSerialExistUpdt(finance) != 0)
                return 99;
            int oldProjectId = (int) financeMapper.getProjectIDbyPK(finance.getFinanceId()).get("projectID");
            int oldFinanceMoney = (int) financeMapper.getProjectIDbyPK(finance.getFinanceId()).get("financeMoney");
            //下面这句会抛出异常**
            int contractId = contractMapper.getContractIDBySerial(finance.getContractSerial());
            finance.setContractId(contractId);
            Contract contract = contractMapper.selectByPrimaryKey(contractId);
            int projectId = contract.getProjectId();
            Project project = projectMapper.selectByPrimaryKey(projectId);
            if (project.getProjectChargerId() != userId) return 100;
            BudgetDetail b = budgetDetailMapper.selectByProjectID(projectId);
            //更改所属项目判断钱够不够
            if ((b.getProjectBudgetLeft() < finance.getFinanceMoney()) && (oldProjectId != projectId)) {
                return -222;
            }
            //不更改所属项目判断钱够不够
            if ((b.getProjectBudgetLeft() < (finance.getFinanceMoney() - oldFinanceMoney)) && (oldProjectId == projectId)) {
                return -222;
            }
            String projectSerial = project.getProjectSerial();
            finance.setProjectId(projectId);
            finance.setProjectSerial(projectSerial);
            finance.setProject(project);
            int successNum = financeMapper.updateByPrimaryKeySelective(finance);
            UpdateCache.updateCache("updateFinance");

            return successNum;
        } catch (org.apache.ibatis.binding.BindingException e) {
            System.out.println("合同编号不存在");
            return 100;
        }
    }

    public String insertFinance(Finance finance, int userId) {

        calendar.setTime(finance.getFinanceDate());
        calendar.add(calendar.DATE, 1);
        finance.setFinanceDate(calendar.getTime());
        try {

            if (financeMapper.ifSerialExistAdd(finance.getFinanceSerials()) != 0)
                return "99";

            //下面这句会抛出异常

            int contractId = contractMapper.getContractIDBySerial(finance.getContractSerial());
            finance.setContractId(contractId);
            Contract contract = contractMapper.selectByPrimaryKey(contractId);
            int projectId = contract.getProjectId();
            Project project = projectMapper.selectByPrimaryKey(projectId);
            if (project.getProjectChargerId() != userId) return "100";
            BudgetDetail b = budgetDetailMapper.selectByProjectID(projectId);
            if (b.getProjectBudgetLeft() < finance.getFinanceMoney()) {
                return "-222" + b.getBudgetId().toString();
            }
            String projectSerial = project.getProjectSerial();
            finance.setProjectId(projectId);
            finance.setProjectSerial(projectSerial);
            finance.setProject(project);
            finance.setContract(contract);

            int successNum = financeMapper.insertSelective(finance);
            UpdateCache.updateCache("updateFinance");

            return Integer.toString(successNum);
        } catch (org.apache.ibatis.binding.BindingException e) {
            System.out.println("所辖合同编号不存在");
            return "100";
        }
    }

    public int deleteFinance(int financeID) {
        int result = financeMapper.deleteFakeByPrimaryKey(financeID);
        UpdateCache.updateCache("updateFinance");

        return result;
    }

    public void batchInsert(List<Finance> finances) {
        financeMapper.batchInsert(finances);
        UpdateCache.updateCache("updateFinance");
    }
}
