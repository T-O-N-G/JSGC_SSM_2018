package service.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.com.jsgc.business.BudgetDetailMapper;
import mapper.com.jsgc.business.ContractMapper;
import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.BudgetDetail;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Project;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.UpdateCache;
import util.com.jsgc.searchCondition.ContractSearchConditions;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;


@Service
public class ContractService {
    Calendar calendar=new GregorianCalendar();
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
    public String getContractDetail(int contractID) {
        Jedis jedis = jedisPool.getResource();
        String key = "Contract:ID:"+contractID;
        System.out.println(key);
        String result = jedis.get(key);
        //回收ShardedJedis实例
        jedis.close();
        return result;
    }

    public int updateContractDetail(Contract contract,int userId) {

        calendar.setTime(contract.getContractSignedTime());
        calendar.add(calendar.DATE,1);
        contract.setContractSignedTime(calendar.getTime());
        //return contractMapper.updateByPrimaryKeySelective(contract);
//        int projectID = projectMapper.getProjectIDBySerial(contract.getProjectSerial());
//        contract.setProjectId(projectID);
//        return contractMapper.updateByPrimaryKeySelective(contract);
        try {
            if(contractMapper.ifSerialExistUpdt(contract)!=0)
                return 99;
            int oldProjectId=contractMapper.getProjectIDByPK(contract.getContractId());
            //下面这句会抛出异常
            int projectId = projectMapper.getProjectIDBySerial(contract.getProjectSerial());
            contract.setProjectId(projectId);
            Project project = projectMapper.selectByPrimaryKey(projectId);
            if(project.getProjectChargerId()!=userId) return 100;
            BudgetDetail b=budgetDetailMapper.selectByProjectID(projectId);
            if((b.getProjectBudgetLeft()<contract.getContractMoney())&&(oldProjectId!=projectId)) {return -222;}
            contract.setProject(project);
            int successNum= contractMapper.updateByPrimaryKeySelective(contract);

            UpdateCache.updateCache("updateContract");

            return successNum;
        }catch (org.apache.ibatis.binding.BindingException e){
            System.out.println("项目编号不存在");
            return 100;
        }
    }

    public int insertContract(Contract contract,int userId){
//        int projectID = projectMapper.getProjectIDBySerial(contract.getProjectSerial());
//        contract.setProjectId(projectID);
//        return contractMapper.insertSelective(contract);
        calendar.setTime(contract.getContractSignedTime());
        calendar.add(calendar.DATE,1);
        contract.setContractSignedTime(calendar.getTime());
        System.out.println(contract.getBuildContentId());
        try {
            if(contractMapper.ifSerialExistAdd(contract.getContractSerial())!=0)
                return 99;//主键编号重复
            //下面这句会抛出异常
            int projectId = projectMapper.getProjectIDBySerial(contract.getProjectSerial());
            contract.setProjectId(projectId);
            Project project = projectMapper.selectByPrimaryKey(projectId);
            if(project.getProjectChargerId()!=userId) return 100;
            contract.setProject(project);
            int successNum= contractMapper.insertSelective(contract);
            UpdateCache.updateCache("updateContract");

            return successNum;
        }catch (org.apache.ibatis.binding.BindingException e){
            System.out.println("项目编号不存在");
            return 100;
        }

    }

    public int deleteContract(int contractID){
        int result = contractMapper.deleteFakeByPrimaryKey(contractID);
        UpdateCache.updateCache("updateContract");

        return result;
    }

    public List<String> getSerialList(){
        return contractMapper.getSerialList();
    }
    public  void batchInsert(List<Contract> contracts){
        contractMapper.batchInsert(contracts);
        UpdateCache.updateCache("updateContract");

    }

    public List<Contract> selectByConditions(ContractSearchConditions cs){
        return contractMapper.selectByConditions(cs);
    }

    public String searchByConditions(ContractSearchConditions ps) {
        System.out.println(ps.getStart()+" "+ps.getLimit());

        Page page= PageHelper.startPage(ps.getPage(),ps.getLimit(),true);
        List<Contract> projects=contractMapper.selectAll(ps);

        System.out.println(page.getTotal());
        System.out.println("分页数据:");
        PageInfo<Contract> pageInfo=new PageInfo<>(projects);
        System.out.println(pageInfo.getList());
        System.out.println(projects);

        HashMap map=new HashMap();
        map.put("total",page.getTotal());
        map.put("data",projects);

        return JSON.toJSONString(map);
    }
    public String getContractUseMoney(Integer projectID ) {
        List<Contract> getContractUseMoney= contractMapper.selectByProjectID(projectID);
        HashMap map=new HashMap();
        map.put("total",getContractUseMoney.size());
        map.put("data",getContractUseMoney);

        return JSON.toJSONString(map);
    }
    public int ifSerialExistAdd(String contractSerial){return  contractMapper.ifSerialExistAdd(contractSerial); };

    public int ifSerialExistUpdt(Contract contract){return contractMapper.ifSerialExistUpdt(contract);}
    public int getContractIDBySerial(String contractSerial){return contractMapper.getContractIDBySerial(contractSerial);}
    public Contract selectByPrimaryKey(Integer contractId){return contractMapper.selectByPrimaryKey(contractId);};
}
