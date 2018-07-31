package service.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.com.jsgc.business.ContractMapper;
import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.Contract;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
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
        calendar.setTime(contract.getContractSignedTime());
        calendar.add(calendar.DATE,1);
        contract.setContractSignedTime(calendar.getTime());
        return contractMapper.updateByPrimaryKeySelective(contract);
    }

    public int insertContract(Contract contract){
        calendar.setTime(contract.getContractSignedTime());
        calendar.add(calendar.DATE,1);
        contract.setContractSignedTime(calendar.getTime());
        System.out.println(contract.getBuildContentId());
        return contractMapper.insertSelective(contract);
    }

    public int deleteContract(int contractID){
        return contractMapper.deleteFakeByPrimaryKey(contractID);
    }

    public List<String> getSerialList(){
        return contractMapper.getSerialList();
    }
    public  void batchInsert(List<Contract> contracts){
        contractMapper.batchInsert(contracts);
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
}
