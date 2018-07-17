package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisTest {
    ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jedis.xml");

    public JedisPool jedisPool = (JedisPool) ac.getBean("jedisPool");//注入JedisPool

    @Test
    public void demo_set(){
        //获取ShardedJedis对象
        Jedis jedis = jedisPool.getResource();
        //存入键值对
        jedis.set("key2","hello jedis one");
        //回收ShardedJedis实例
        jedis.close();

    }

    @Test
    public void demo_get(){
        Jedis jedis = jedisPool.getResource();
        //根据键值获得数据
        String result = jedis.get("key2");
        jedis.close();

//        return result;
    }
}
