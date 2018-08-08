package service.com.jsgc.admin;


import com.alibaba.fastjson.JSON;
import mapper.com.jsgc.admin.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.ZParams;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AnalyzeService {

    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private UserMapper userMapper;

    public String getTopPersonList() {
        Jedis jedis = jedisPool.getResource();
        ZParams zParams = new ZParams();
        zParams.aggregate(ZParams.Aggregate.SUM);
        String[] keys = new String[14];
        long time = new Date().getTime();
        String date = "";
        for (int i = 0; i < 14; i++) {
            date = (new SimpleDateFormat("yyyy-MM-dd")).format(time);
            keys[i] = ("LogSum:" + date);
            time -= 86400000;
        }
        System.out.println(jedis.zunionstore("LogTmp", zParams, keys));
        Set<Tuple> tuples = jedis.zrangeWithScores("LogTmp", 0, -1);
        ArrayList<String> users = new ArrayList<>();
        ArrayList<Double> scores = new ArrayList<>();
        for (Tuple tuple : tuples) {
            users.add(userMapper.getUnamebyUid(tuple.getElement()));
            scores.add(tuple.getScore());
//            System.out.println(userMapper.getUnamebyUid(tuple.getElement()) + ":" + tuple.getScore());
        }

        HashMap<String, Object> resultJson = new HashMap<>();

        resultJson.put("category", users);

        resultJson.put("data", scores);

        jedis.close();
        return JSON.toJSONString(resultJson);
    }


    public String getDayDataList() {
        Jedis jedis = jedisPool.getResource();
        String key = "";
        long time = new Date().getTime();
        String date = "";
        long sum = 0;
        ArrayList<String> dates = new ArrayList<>();
        ArrayList<Long> scores = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            date = (new SimpleDateFormat("yyyy-MM-dd")).format(time);
            key = "LogSum:" + date;
            time -= 86400000;
            Set<Tuple> tuples = jedis.zrangeWithScores("LogSum:" + date, 0, -1);
            sum = 0;
            for (Tuple tuple : tuples) {
                sum += tuple.getScore();
            }
            scores.add(sum);
            dates.add(date);
        }

        HashMap<String, Object> resultJson = new HashMap<>();
        resultJson.put("category", dates);
        resultJson.put("data", scores);
        jedis.close();
        return JSON.toJSONString(resultJson);
    }


    public String getExpSum() {
        Jedis jedis = jedisPool.getResource();
        String key = "";
        long time = new Date().getTime();
        String date = "";
        long sum = 0;
        ArrayList<Long> scores = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            date = (new SimpleDateFormat("yyyy-MM-dd")).format(time);
            key = "LogSum:" + date;
            time -= 86400000;
            Set<Tuple> tuples = jedis.zrangeWithScores("LogSum:" + date, 0, -1);
            for (Tuple tuple : tuples) {
                sum += tuple.getScore();
            }
        }

        HashMap<String, Long> resultJson = new HashMap<>();
        long exSum = jedis.scard("Exception");
        resultJson.put("sum",sum);
        resultJson.put("exSum",exSum);
        jedis.close();
        return JSON.toJSONString(resultJson);
    }

    public String getNetGraph() {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get("NetGraph");
        jedis.close();
        return  result;
    }
}
