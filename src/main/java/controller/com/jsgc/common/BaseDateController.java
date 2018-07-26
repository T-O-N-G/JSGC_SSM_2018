package controller.com.jsgc.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.com.jsgc.common.BaseDataService;

import javax.annotation.Resource;

@Controller
@RequestMapping(produces = {"application/json; charset=UTF-8"})
public class BaseDateController {
    @Resource
    private BaseDataService baseDataService;


    @RequestMapping("/getBaseDate")
    @ResponseBody
    public String getBaseDate(@RequestBody String param){
        JSONObject jsonObject = JSON.parseObject(param);
        return baseDataService.getBaseDate(jsonObject.getString("baseDataType"));
    }

}
