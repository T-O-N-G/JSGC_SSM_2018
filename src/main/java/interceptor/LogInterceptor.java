package interceptor;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.EmailSender;
import util.GetRequestInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class LogInterceptor implements HandlerInterceptor {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Jedis jedis = jedisPool.getResource();
        String url = httpServletRequest.getRequestURI();
//        String requestMsg = GetRequestInfo.getRequestInfo(httpServletRequest);
        String userID = (String) httpServletRequest.getAttribute("userID");
        long time = new Date().getTime();
        String date = (new SimpleDateFormat("yyyy-MM-dd")).format(time);
        HashMap<String, String> logInfo = new HashMap<>();
        logInfo.put("userID", userID);
        logInfo.put("url", url);
        logInfo.put("time", String.valueOf(time));
        jedis.zadd("LogInfo", time, JSON.toJSONString(logInfo));
        Double score = jedis.zscore("LogSum:" + date, userID);
        if (score == null) {
            score = 0.0;
        }
        jedis.zadd("LogSum:" + date, score + 1, userID);

        jedis.close();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // Exception 信息
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        e.printStackTrace(pw);
        pw.flush();
        sw.flush();
        String errorMsg = sw.toString();

        String requestMsg = GetRequestInfo.getRequestInfo(httpServletRequest);
        String exceptionMessage = "<h1>Exception 信息</h1>";
        exceptionMessage += errorMsg;
        exceptionMessage += requestMsg;
        long time = new Date().getTime();
        Jedis jedis = jedisPool.getResource();
        jedis.zadd("Exception", time, exceptionMessage);

        EmailSender.SendEmail("tongao713@icloud.com", "发生错误", exceptionMessage);
        jedis.close();
    }
}
