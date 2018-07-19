package controller.com.jsgc.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.Login.Login;
import service.com.jsgc.login.LoginService;
//import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@Controller
//@RequestMapping("/business/project/")
public class LoginController {
    @Resource
    private LoginService loginService;


    @RequestMapping("/login")
    @ResponseBody
    public void login(@RequestBody Map<String,String> map, HttpServletResponse response) throws Exception {
//        return loginService.loginAuth();
        Login loginInfo = new Login();
        loginInfo.setEmail(map.get("email"));
        loginInfo.setEmail(map.get("password"));

        loginService.loginAuth(loginInfo);
        System.out.println(loginInfo.getToken());

        response.setHeader("Token", loginInfo.getToken());
//        response.sendRedirect("login.html");

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
