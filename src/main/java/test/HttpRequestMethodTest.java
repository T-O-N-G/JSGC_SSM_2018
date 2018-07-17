package test;

import org.junit.Test;
import util.HttpRequestMethod;

public class HttpRequestMethodTest {
    @Test
    public void send() {
        //发送 GET 请求
        String s= HttpRequestMethod.sendGet("http://localhost:6144/Home/RequestString", "key=123&v=456");
        System.out.println(s);

        //发送 POST 请求
        String sr=HttpRequestMethod.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
        System.out.println(sr);
    }
}


