package service.com.jsgc.business;

import mapper.com.jsgc.business.AssetMapper;
import mapper.com.jsgc.business.ContractMapper;
import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.Asset;
import pojo.com.jsgc.business.Contract;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Service
public class AssetService {
    @Resource
    private AssetMapper assetMapper;

    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jedis.xml");

    public JedisPool jedisPool = (JedisPool) ac.getBean("jedisPool");//注入JedisPool



    public String getAssetDetail(int assetID) {
        Jedis jedis = jedisPool.getResource();
        String key = "Asset:"+assetID;
        System.out.println(key);
        String result = jedis.get(key);
        //回收ShardedJedis实例
        jedis.close();
        return result;
    }

    public int updateAssetDetail(Asset asset) {
        return assetMapper.updateByPrimaryKeySelective(asset);
    }

    public int insertAsset(Asset asset) {
        return assetMapper.insertSelective(asset);
    }

    public int deleteAsset(int assetID) {
        return assetMapper.deleteFakeByPrimaryKey(assetID);
    }
}
