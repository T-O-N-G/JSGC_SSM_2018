package service.com.jsgc.login;

import com.alibaba.fastjson.JSON;
//import mapper.com.jsgc.admin.UserMapper;
import mapper.com.jsgc.admin.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import pojo.com.jsgc.Login.Login;
import pojo.com.jsgc.admin.User;
import pojo.com.jsgc.login.Login;
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
        //校验,从库里查
        int resultAuth = 1;
//        login.setUsername("tong");
//        login.setUserID(3);
        User user = userMapper.selectByEmail(login.getEmail());
        String realPassword = user.getPassword();
        String fakePassword = login.getPassword();
        if(fakePassword.equals(realPassword)){
            resultAuth = 0;
        }
        if (resultAuth == 0) {
            //生成 Token
            Map<String, String> payloads = new HashMap<>();
            payloads.put("userID", String.valueOf(user.getUserId()));
            payloads.put("level", String.valueOf(user.getPermissionLevel()));
//            String payload = JSON.toJSONString(payloads);
            login.setToken(jwtUtil.createJWT("jwt", "tong", 259200000, String.valueOf(user.getUserId()), String.valueOf(user.getPermissionLevel())));
            System.out.println(login.getToken());
//            login.setUsername(username);
//            login.setUserID(userID);
            //Token 放入 Redis
            Jedis jedis = jedisPool.getResource();
            String key = "Token:" + String.valueOf(user.getUserId());
            jedis.setex(key, 259200,login.getToken());
            jedis.close();
            login.setUsername(user.getUsername());
            login.setLevel(user.getPermissionLevel());
            login.setUserID(user.getUserId());
            return "success";
        } else {
            return "error";
        }
    }


}