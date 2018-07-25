package controller.com.jsgc.login;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import pojo.com.jsgc.Login.Login;
import pojo.com.jsgc.login.Login;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import service.com.jsgc.login.LoginService;
//import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@Controller
//@RequestMapping("/business/project/")
public class LoginController {
    @Resource
    private LoginService loginService;
    @Autowired
    public JedisPool jedisPool;

    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestBody Map<String,String> map, HttpServletResponse response) throws Exception {
//        return loginService.loginAuth();
        Login loginInfo = new Login();
        loginInfo.setEmail(map.get("email"));
        loginInfo.setPassword(map.get("password"));

        loginService.loginAuth(loginInfo);
        System.out.println(loginInfo.getToken());
        Map<String,String> resultMap = new HashMap<String,String>();
        resultMap.put("Token", loginInfo.getToken());
        resultMap.put("username", loginInfo.getUsername());
        resultMap.put("userID", String.valueOf(loginInfo.getUserID()));

        //        response.setHeader("Token", loginInfo.getToken());
        response.setStatus(200);
//        Cookie cookie = new Cookie("Token",loginInfo.getToken());
//        response.addCookie(cookie);
        return JSON.toJSONString(resultMap);
//        response.sendRedirect("login.html");

    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userID = (String) request.getAttribute("userID");
        Jedis jedis = jedisPool.getResource();
        String key = "Token:" + userID;
        jedis.del(key);
        return "success" ;
//        return loginService.loginAuth();
//        Login loginInfo = new Login();
//        loginInfo.setEmail(map.get("email"));
//        loginInfo.setEmail(map.get("password"));
//
//        loginService.loginAuth(loginInfo);
//        System.out.println(loginInfo.getToken());
//        Map<String,String> resultMap = new HashMap<String,String>();
//        resultMap.put("Token", loginInfo.getToken());
////        response.setHeader("Token", loginInfo.getToken());
//        response.setStatus(200);
//        Cookie cookie = new Cookie("Token",loginInfo.getToken());
//        response.addCookie(cookie);
//        return JSON.toJSONString(resultMap);
////        response.sendRedirect("login.html");

    }


    @RequestMapping("/loginTest")
    @ResponseBody
    public void loginTest(@RequestBody Map<String,String> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        return loginService.loginAuth();
        System.out.println("UserID: "+request.getAttribute("userID"));
        System.out.println("level: "+request.getAttribute("level"));

        response.getWriter().write("sss");
//        response.sendRedirect("login.html");

    }

}
