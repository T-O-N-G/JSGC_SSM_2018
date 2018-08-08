package controller.com.jsgc.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.com.jsgc.admin.BaseDataService;

import javax.annotation.Resource;

@Controller
@RequestMapping(produces = {"application/json; charset=UTF-8"})

public class BaseDataController {
    @Resource
    private BaseDataService baseDataService;

    @RequestMapping("/getVersionList")
    @ResponseBody
    public String getVersionList() {
        return baseDataService.getVersionList();
    }

    @RequestMapping("/getBaseDataByVersion")
    @ResponseBody
    public String getBaseDataByVersion(String versionId) {
        return baseDataService.getBaseDataByVersion(versionId);
    }


    @RequestMapping("/getBaseDate")
    @ResponseBody
    public String getBaseDate(@RequestBody String param) {
        JSONObject jsonObject = JSON.parseObject(param);
        return baseDataService.getBaseDate(jsonObject.getString("baseDataType"));
    }

    @RequestMapping("/updateNewVersion")
    @ResponseBody
    public String updateNewVersion(@RequestBody String param) {

        return baseDataService.updateNewVersion(param);

    }
}
