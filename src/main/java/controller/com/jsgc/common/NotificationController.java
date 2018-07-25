package controller.com.jsgc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;
import service.com.jsgc.common.NotificationService;
import util.com.jsgc.notification.Notification;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class NotificationController {
    @Resource
    private NotificationService notificationService;

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/getNotification")
    @ResponseBody
    public String getNotification(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return notificationService.getUserNotification((String) request.getAttribute("userID"));

    }
//
//    @RequestMapping("/addNotification")
//    @ResponseBody
//    public String addNotification(HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//        notificationService.addNotification((String) request.getAttribute("userID"), "测试通知","测试通知标题");
//        notificationService.addPublicNotification("测试公告","测试通知标题");
//        return "OK";
//
//    }

}
