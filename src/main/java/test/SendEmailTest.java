package test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.EmailSender;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

public class SendEmailTest {

    @Test
    public void testSendEmail(){
        String address = "tongao713@icloud.com";
        String title = "测试邮件";
        String content = "<center><h1>嘿</h1></center><p>这是SSM发出的一封邮件</p><h2>这是一封带格式的邮件</h2>";
        EmailSender.SendEmail(address,title,content);
    }
}
