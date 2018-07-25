package util.com.jsgc.notification;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class Notification {
    @Autowired
    private JedisPool jedisPool;

    public int addNotification(Integer userID, String message){
        Jedis jedis = jedisPool.getResource();
        long times=1000*System.currentTimeMillis();
        jedis.zadd("Notify:User:"+String.valueOf(userID), times, message);
        jedis.close();
        return 0;
    }

    public int addPublicNotification(String message){
        Jedis jedis = jedisPool.getResource();
        long times=1000*System.currentTimeMillis();
        jedis.zadd("Notify:All", times, message);
        jedis.close();
        return 0;
    }
}
