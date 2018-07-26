package service.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.com.jsgc.business.ContractMapper;
import mapper.com.jsgc.business.FinanceMapper;
import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Finance;
import pojo.com.jsgc.business.Project;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.com.jsgc.searchCondition.FinanceSearchConditions;
import util.com.jsgc.searchCondition.ProjectSearchConditions;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class FinanceService {
    @Resource
    private FinanceMapper financeMapper;
    @Resource
    private ContractMapper contractMapper;
    @Resource
    private ProjectMapper projectMapper;

//    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jedis.xml");
//
//    public JedisPool jedisPool = (JedisPool) ac.getBean("jedisPool");//注入JedisPool

    @Autowired
    public JedisPool jedisPool;//注入JedisPool

    public String searchByConditions(FinanceSearchConditions fs ){
//        projectMapper.searchByConditions();
        System.out.println(fs.getLimit());

        Page page= PageHelper.startPage(fs.getPage(),fs.getLimit(),true);
        List<Finance> finances=financeMapper.selectAll();

        System.out.println(page.getTotal());
        System.out.println("分页数据:");
        PageInfo<Finance> pageInfo=new PageInfo<>(finances);
        System.out.println(pageInfo.getList());
        System.out.println(finances);

        HashMap map=new HashMap();
        map.put("total",page.getTotal());
        map.put("data",finances);

        return JSON.toJSONString(map);

    }


    public String getFinanceDetail(int financeID) {
        Jedis jedis = jedisPool.getResource();
        String key = "Finance:ID:"+financeID;
        System.out.println(key);
        String result = jedis.get(key);
        //回收ShardedJedis实例
        jedis.close();
        return result;
    }

    public int updateFinanceDetail(Finance finance) {
        int projectID = projectMapper.getProjectIDBySerial(finance.getProjectSerial());
        finance.setProjectId(projectID);
        int contractID = contractMapper.getContractIDBySerial(finance.getContractSerial());
        finance.setContractId(contractID);
        return financeMapper.updateByPrimaryKeySelective(finance);
    }

    public int insertFinance(Finance finance){
        int projectID = projectMapper.getProjectIDBySerial(finance.getProjectSerial());
        finance.setProjectId(projectID);
        int contractID = contractMapper.getContractIDBySerial(finance.getContractSerial());
        finance.setContractId(contractID);
        return financeMapper.insertSelective(finance);
    }

    public int deleteFinance(int financeID){
        return financeMapper.deleteFakeByPrimaryKey(financeID);
    }
}
