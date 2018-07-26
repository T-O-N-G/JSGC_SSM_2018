package service.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.com.jsgc.business.AssetMapper;
import mapper.com.jsgc.business.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.business.Asset;
import pojo.com.jsgc.business.Document;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.com.jsgc.searchCondition.DocumentSearchConditions;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class DocumentService {
    @Resource
    private DocumentMapper documentMapper;

//    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jedis.xml");
//
//    public JedisPool jedisPool = (JedisPool) ac.getBean("jedisPool");//注入JedisPool
@Autowired
public JedisPool jedisPool;//注入JedisPool



    public String getDocumentDetail(int documentID) {
        Jedis jedis = jedisPool.getResource();
        String key = "Document:ID:"+documentID;
        System.out.println(key);
        String result = jedis.get(key);
        //回收ShardedJedis实例
        jedis.close();
        return result;
    }

    public int updateDocumentDetail(Document document) {
        return documentMapper.updateByPrimaryKeySelective(document);
    }

    public int insertDocument(Document document) {
        return documentMapper.insertSelective(document);
    }

    public int deleteDocument(int documentID) {
        return documentMapper.deleteFakeByPrimaryKey(documentID);
    }

    public String searchByConditions(DocumentSearchConditions ps) {
        Page page= PageHelper.startPage(ps.getPage(),ps.getLimit(),true);
        List<Document> projects=documentMapper.selectAll(ps);

        System.out.println(page.getTotal());
        System.out.println("分页数据:");
        PageInfo<Document> pageInfo=new PageInfo<>(projects);
        System.out.println(pageInfo.getList());
        System.out.println(projects);

        HashMap map=new HashMap();
        map.put("total",page.getTotal());
        map.put("data",projects);

        return JSON.toJSONString(map);
    }
}
