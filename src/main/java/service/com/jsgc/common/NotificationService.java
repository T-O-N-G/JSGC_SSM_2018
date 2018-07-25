package service.com.jsgc.common;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ZParams;
import util.DateUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class NotificationService {

    @Autowired
    public JedisPool jedisPool;

    public String getUserNotification(String userID) throws Exception {
        Jedis jedis = jedisPool.getResource();
        ZParams zParams = new ZParams();
        zParams.aggregate(ZParams.Aggregate.MAX);
        jedis.zunionstore("tmp:Notify:" + userID, zParams, "Notify:User:"+userID, "Notify:All");
        Set<String> result = jedis.zrevrange("tmp:Notify:" + userID, 0,5);
        jedis.del("tmp:Notify:" + userID);
        jedis.close();
        String notificationResult = "[";
        for (String item: result
             ) {
            notificationResult+=item;
            notificationResult+=",";
        }
        notificationResult = notificationResult.substring(0,notificationResult.length() - 1);
        notificationResult += "]";

        System.out.println(notificationResult);
        return notificationResult;
//        response.sendRedirect("login.html");
    }


    public int addNotification(String userID, String message, String title){
        Jedis jedis = jedisPool.getResource();
        String time = DateUtil.timeStamp();
        HashMap<String,String> item = new HashMap<String, String>();
        item.put("NoTitle", title);
        item.put("NoTime", DateUtil.timeStamp2Date(time, "yyyy-MM-dd"));
        item.put("NoContent", message);
        jedis.zadd("Notify:User:"+userID, Double.parseDouble(time), JSON.toJSONString(item));
        jedis.close();
        return 0;
    }

    public int addPublicNotification(String message, String title){
        Jedis jedis = jedisPool.getResource();
        String time = DateUtil.timeStamp();
        HashMap<String,String> item = new HashMap<String, String>();
        item.put("NoTitle", title);
        item.put("NoTime", DateUtil.timeStamp2Date(time, "yyyy-MM-dd"));
        item.put("NoContent", message);
        jedis.zadd("Notify:All", Double.parseDouble(time), JSON.toJSONString(item));
        jedis.close();
        return 0;
    }


}
