package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisClient {

    private Jedis redisClient = createClient();

    protected static Jedis createClient() {
        try {
            JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.55.121",6379,8000,"foobar");
            return pool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("初始化连接池错误");
    }

    public String getByKey(String key){
        return (redisClient.get(key).toString());
    }

    public void setByKey(String key, String value){
        redisClient.set(key, value);
//        redisClient.getSet();
    }


}