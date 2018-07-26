package service.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.com.jsgc.business.AssetMapper;
import mapper.com.jsgc.business.ContractMapper;
import mapper.com.jsgc.business.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.Asset;
import pojo.com.jsgc.business.Contract;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.com.jsgc.searchCondition.AssetSearchConditions;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class AssetService {
    @Resource
    private AssetMapper assetMapper;

//    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jedis.xml");
//
//    public JedisPool jedisPool = (JedisPool) ac.getBean("jedisPool");//注入JedisPool
@Autowired
private JedisPool jedisPool;//注入JedisPool

    public String getAssetDetail(int assetID) {
        Jedis jedis = jedisPool.getResource();
        String key = "Asset:ID:"+assetID;
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

    public String searchByConditions(AssetSearchConditions ps) {
        System.out.println(ps.getStart()+" "+ps.getLimit());

        Page page= PageHelper.startPage(ps.getPage(),ps.getLimit(),true);
        List<Asset> projects=assetMapper.selectAll(ps);

        System.out.println(page.getTotal());
        System.out.println("分页数据:");
        PageInfo<Asset> pageInfo=new PageInfo<>(projects);
        System.out.println(pageInfo.getList());
        System.out.println(projects);

        HashMap map=new HashMap();
        map.put("total",page.getTotal());
        map.put("data",projects);

        return JSON.toJSONString(map);
    }
}
