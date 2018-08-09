package util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class GetRequestInfo {
    public static String getRequestInfo(HttpServletRequest httpServletRequest){
        String requestMsg = "</br></br><h1>Request 信息</h1>";
        //获取请求方式
        requestMsg += "</br>" + httpServletRequest.getMethod();
        //获取项目名称
        requestMsg += "</br>" + httpServletRequest.getContextPath();
        //获取完整请求路径
        requestMsg += "</br>" + httpServletRequest.getRequestURL();
        //获取除了域名外的请求数据
        requestMsg += "</br>" + httpServletRequest.getRequestURI();
        //获取请求参数
        requestMsg += "</br>" + httpServletRequest.getQueryString();
        requestMsg += "</br>" + "----------------------------------------------------------";
        //获取请求头
        String header = httpServletRequest.getHeader("user-Agent");
        requestMsg += "</br>" + header;
        header = header.toLowerCase();
        //根据请求头数据判断浏览器类型
        if (header.contains("chrome")) {
            requestMsg += "</br>" + "访问浏览器为谷歌浏览器";
        } else if (header.contains("msie")) {
            requestMsg += "</br>" + "访问浏览器为IE浏览器";
        } else if (header.contains("firefox")) {
            requestMsg += "</br>" + "访问浏览器为火狐浏览器";
        } else if (header.contains("Safari")) {
            requestMsg += "</br>" + "访问浏览器为Safari浏览器";
        } else {
            requestMsg += "</br>" + "访问浏览器为其它浏览器";
        }
        requestMsg += "</br>" + "----------------------------------------------------------";
        //获取所有的消息头名称
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        //获取获取的消息头名称，获取对应的值，并输出
        while (headerNames.hasMoreElements()) {
            String nextElement = headerNames.nextElement();
            requestMsg += "</br>" + nextElement + ":" + httpServletRequest.getHeader(nextElement);
        }
        requestMsg += "</br>" + "----------------------------------------------------------";
        //根据名称获取此重名的所有数据
        Enumeration<String> headers = httpServletRequest.getHeaders("accept");
        while (headers.hasMoreElements()) {
            String string = (String) headers.nextElement();
            requestMsg += "</br>" + string;
        }
//        System.out.println(requestMsg);
        return  requestMsg;

    }
}
