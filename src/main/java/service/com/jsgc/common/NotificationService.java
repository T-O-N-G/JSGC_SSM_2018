package service.com.jsgc.common;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ZParams;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class NotificationService {

    @Autowired
    public JedisPool jedisPool;

    public String getUserNotification(Integer userID) throws Exception {
        Jedis jedis = jedisPool.getResource();
        ZParams zParams = new ZParams();
        zParams.aggregate(ZParams.Aggregate.MAX);
        jedis.zunionstore("tmp:Notify:" + String.valueOf(userID), zParams, "Notify:User:"+String.valueOf(userID), "Notify:All");
        Set<String> result = jedis.zrevrange("tmp:Notify:" + String.valueOf(userID), 0,5);
        jedis.del("tmp:Notify:" + String.valueOf(userID));
        jedis.close();
        String notificationResult = JSON.toJSONString(result);
        System.out.println(notificationResult);
        return notificationResult;
//        response.sendRedirect("login.html");
    }


}
