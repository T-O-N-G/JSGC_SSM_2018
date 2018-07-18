package service.com.jsgc.login;

import com.alibaba.fastjson.JSON;
import mapper.com.jsgc.admin.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.com.jsgc.Login.Login;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.JwtUtil;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Resource
    private UserMapper userMapper;

    @Autowired
    public JedisPool jedisPool;
    @Autowired
    public JwtUtil jwtUtil;

//    public FastJson
//        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-jedis.xml");
//
//        public JedisPool jedisPool = (JedisPool) ac.getBean("jedisPool");//注入JedisPool


    public String loginAuth(Login login) throws Exception {
        //校验
        int resultAuth = 0;
        if (resultAuth ==0){
            login.setUsername("wang");
            login.setUserID(2);
            login.setLevel(1);
            //生成 Token
            Map<String, String> payloads = new HashMap<>();
            payloads.put("userID", String.valueOf(login.getUserID()));
            payloads.put("level", String.valueOf(login.getLevel()));
            String payload = JSON.toJSONString(payloads);
            login.setToken(jwtUtil.createJWT("jwt", payload, 6000000));
//        System.out.println(login.getToken());

            //Token 放入 Redis
            Jedis jedis = jedisPool.getResource();
            String key = "Token:" + String.valueOf(login.getUserID());
            jedis.set(key, login.getToken());
            jedis.close();
            return "success";
        }else {
            return "error";
        }
    }


}