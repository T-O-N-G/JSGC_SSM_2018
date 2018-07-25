package service.com.jsgc.business;

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

import javax.annotation.Resource;

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
        return documentMapper.deleteByPrimaryKey(documentID);
    }
}
