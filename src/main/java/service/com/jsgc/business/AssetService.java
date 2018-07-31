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
import pojo.com.jsgc.business.Project;
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

    @Resource
    private ProjectMapper projectMapper;

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
        try {
            if(assetMapper.ifSerialExistUpdt(asset)!=0)
                return 99;
            //下面这句会抛出异常
            int projectId = projectMapper.getProjectIDBySerial(asset.getProjectSerial());
            asset.setProjectId(projectId);
            int successNum= assetMapper.updateByPrimaryKeySelective(asset);
            return successNum;
        }catch (org.apache.ibatis.binding.BindingException e){
            System.out.println("项目编号不存在");
            return 100;
        }
    }

    public int insertAsset(Asset asset) {
        try {
            if(assetMapper.ifSerialExistAdd(asset.getAssetSerial())!=0)
                return 99;
            //下面这句会抛出异常
            int projectId = projectMapper.getProjectIDBySerial(asset.getProjectSerial());
            asset.setProjectId(projectId);
            int successNum= assetMapper.insertSelective(asset);
            return successNum;
        }catch (org.apache.ibatis.binding.BindingException e){
            System.out.println("项目编号不存在");
            return 100;
        }
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
