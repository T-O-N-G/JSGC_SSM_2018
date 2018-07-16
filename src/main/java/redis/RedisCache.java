package redis;


import java.io.Serializable;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//import org.apache.commons.lang3.SerializationUtils;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

import redis.SerializeUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;

public class RedisCache implements Cache {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCache.class);
    private static final long serialVersionUID = -8198240627840132613L;

    /**
     * The {@code ReadWriteLock}.
     */
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    /**
     * Jedis客户端
     */
    @Autowired
    private Jedis redisClient = createClient();
    private String id;

    public RedisCache() {
    }

    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("必须传入ID");
        }
        System.out.println("............MybatisRedisCache:id=" + id);
        LOGGER.debug("MybatisRedisCache:id=" + id);
        this.id = id;
    }

    @Override
    public void clear() {
        redisClient.flushDB();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Object getObject(Object key) {
        byte[] ob = redisClient.get(SerializeUtil.serialize(key.toString()));
        if (ob == null) {
            return null;
        }
        Object value = SerializeUtil.unSerialize(ob);
        LOGGER.debug("获取的键值对>>>>>>>>>>>>>>>>>>>>>>>>getObject:" + key + "=" + value);
        return value;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    @Override
    public int getSize() {
        return Integer.valueOf(redisClient.dbSize().toString());
    }

    @Override
    public void putObject(Object key, Object value) {
        LOGGER.debug("存入的键值对>>>>>>>>>>>>>>>>>>>>>>>>putObject:" + key + "=" + value);
        redisClient.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
    }

    @Override
    public Object removeObject(Object key) {
        return redisClient.expire(SerializeUtil.serialize(key.toString()), 0);
    }

    protected static Jedis createClient() {
        try {
            JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.55.121",6379,8000,"foobar");
            return pool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("初始化连接池错误");
    }

}