package service.com.jsgc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class BaseDataService {

    @Autowired
    public JedisPool jedisPool;

    public String getBaseDate(String baseDataType){
        String key = baseDataType+":list";
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get(key);
        jedis.close();
        return value;
    }
}