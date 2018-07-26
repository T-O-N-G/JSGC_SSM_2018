package controller.com.jsgc.common;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.com.jsgc.common.BaseDataService;

import javax.annotation.Resource;

@Controller
public class BaseDateController {
    @Resource
    private BaseDataService baseDataService;


    @RequestMapping("/getBaseDate")
    @ResponseBody
    public String getBaseDate(String baseDataType){
        return baseDataService.getBaseDate(baseDataType);
    }

}
