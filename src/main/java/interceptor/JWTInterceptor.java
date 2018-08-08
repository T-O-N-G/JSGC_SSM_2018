package interceptor;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    public JwtUtil jwtUtil;

    @Autowired
    public JedisPool jedisPool;

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) {
        // TODO Auto-generated method stub
//        JwtUtil util = new JwtUtil();
        String jwt = request.getHeader("Authorization");

        try {
            if (jwt == null || jwt.equals("")) {
//                System.out.println("用户未登录，验证失败");
                response.setStatus(401);

            } else {
                Jedis jedis = jedisPool.getResource();

                Claims c;
                c = jwtUtil.parseJWT(jwt);
                String key = "Token:" + String.valueOf(c.get("userID"));
                if (jedis.get(key).equals(jwt)) {
//                    System.out.println("用户id" + c.get("userID") + "已是登录状态");
                    request.setAttribute("userID", c.get("userID"));
                    request.setAttribute("level", c.get("level"));
                }else {
                    response.setStatus(401);
                }
                jedis.close();

                return true;
            }

//            System.out.println("token解析错误，验证失败");
//            response.getWriter().write("未登录，请重新登录后操作");;
            response.setStatus(401);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response.setStatus(401);

        }
        return false;
    }

}


