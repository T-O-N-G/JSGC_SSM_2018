package controller.com.jsgc.admin;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.admin.User;
import service.com.jsgc.admin.UserService;
import util.com.jsgc.searchCondition.UserSearchConditions;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(produces = {"application/json; charset=UTF-8"})
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/getUserList")
    @ResponseBody
    public String searchByConditons(@RequestBody String params) throws UnsupportedEncodingException {
        System.out.println(params);
        UserSearchConditions ps = JSON.parseObject(params , new TypeReference<UserSearchConditions>() {});
        System.out.println(ps);
        ps.parseOrder();
        System.out.println(ps);
        return userService.searchByConditions(ps);
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public int addUser(@RequestBody String params) throws UnsupportedEncodingException{
        User user = JSON.parseObject(params , new TypeReference<User>() {});
        return   userService.insertUser(user);
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public int deleteUser(int userID){

        return  userService.deleteUser(userID);
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public int updateUserDetail(@RequestBody String params){
        User user = JSON.parseObject(params , new TypeReference<User>() {});
        return   userService.updateUserDetail(user);
    }
    @RequestMapping("/updateUserInfo")
    @ResponseBody
    public int updateUser(@RequestBody String params){
        User user = JSON.parseObject(params , new TypeReference<User>() {});
        return   userService.updateUserDetail(user);
    }
    @RequestMapping("/initUserUpdate")
    @ResponseBody
    public String getUserDetail(@RequestBody String params){
        User user = JSON.parseObject(params , new TypeReference<User>() {});
        return   userService.getUserDetail(user.getUserId());
    }

}
