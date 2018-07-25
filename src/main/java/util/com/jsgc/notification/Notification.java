package util.com.jsgc.notification;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.DateUtil;

import java.util.HashMap;

public class Notification {
    @Autowired
    private JedisPool jedisPool;

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
