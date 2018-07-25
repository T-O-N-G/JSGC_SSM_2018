package service.com.jsgc.business;

import mapper.com.jsgc.business.ContractMapper;
import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.Contract;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;


@Service
public class ContractService {
    @Resource
    private ContractMapper contractMapper;
    @Resource
    private ProjectMapper projectMapper;

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

    public int updateContractDetail(Contract contract) {
        int projectID = projectMapper.getProjectIDBySerial(contract.getProjectSerial());
        contract.setProjectId(projectID);
        return contractMapper.updateByPrimaryKeySelective(contract);
    }

    public int insertContract(Contract contract){
        int projectID = projectMapper.getProjectIDBySerial(contract.getProjectSerial());
        contract.setProjectId(projectID);
        return contractMapper.insertSelective(contract);
    }

    public int deleteContract(int contractID){
        return contractMapper.deleteFakeByPrimaryKey(contractID);
    }


}
