package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

public class EmailSender {

    public static String SendEmail(String address, String title, String content) {
        String url = "https://prod-21.southeastasia.logic.azure.com:443/workflows/a7a8e146cd9c43b3be1eea4eaef6faba/triggers/manual/paths/invoke?api-version=2016-06-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=cljfi_ilQbfVC8iJPhceSZSuBTpngoHFEN2_o5XLWSg";
        HashMap<String, String> payloads = new HashMap<String, String>();
        payloads.put("mailTo", address);
        payloads.put("mailSubject", title);
        payloads.put("mailBody", content);
        String param = JSON.toJSONString(payloads);
        byte[] result = null;
        String charset = "UTF-8";
        try {
            result = PostJson.post(url, param, charset);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";

        }
        System.out.println(result);
//        payload = {
//                'mailTo': 'tongao713@icloud.com',
//                'mailSubject': '注意！发现陌生人',
//                'mailBody': url3
//    }
        return "success";
    }
}

