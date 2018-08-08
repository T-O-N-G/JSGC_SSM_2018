package controller.com.jsgc.admin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.com.jsgc.admin.AnalyzeService;

import javax.annotation.Resource;

@Controller
//@RequestMapping("/bussiness/document/")
@RequestMapping(produces = {"application/json; charset=UTF-8"})
public class AnalyzeController {
    @Resource
    private AnalyzeService analyzeService;

    @RequestMapping("/getTopPersonList")
    @ResponseBody
    public String getTopPersonList() {
        return analyzeService.getTopPersonList();
    }

    @RequestMapping("/getDayDataList")
    @ResponseBody
    public String getDayDataList() {
        return analyzeService.getDayDataList();
    }

    @RequestMapping("/getExpSum")
    @ResponseBody
    public String getExpSum() {
        return analyzeService.getExpSum();
    }

    @RequestMapping("/getNetGraph")
    @ResponseBody
    public String getNetGraph() {
        return analyzeService.getNetGraph();
    }
}
