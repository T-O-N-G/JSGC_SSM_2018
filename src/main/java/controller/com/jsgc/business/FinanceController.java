package controller.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Finance;
import pojo.com.jsgc.business.Project;
import service.com.jsgc.business.ContractService;
import service.com.jsgc.business.FinanceService;
import util.com.jsgc.searchCondition.FinanceSearchConditions;
import util.com.jsgc.searchCondition.ProjectSearchConditions;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Controller
//@RequestMapping("/bussiness/finance/")
@RequestMapping(produces = {"application/json; charset=UTF-8"})

public class FinanceController {
    @Resource
    private FinanceService financeService;

    @RequestMapping("/getFinanceList")
    @ResponseBody
    public String searchByConditons(@RequestBody String params) throws UnsupportedEncodingException {
        System.out.println(params);
        FinanceSearchConditions fs = JSON.parseObject(params , new TypeReference<FinanceSearchConditions>() {});
        System.out.println(fs);
        fs.parseOrder();
        System.out.println(fs);
        return financeService.searchByConditions(fs);
    }

    @RequestMapping("getFinanceDetail")
    @ResponseBody
    public String getFinanceDetail(int financeID){
        return financeService.getFinanceDetail(financeID);
    }

    @RequestMapping("updateFinance")
    @ResponseBody
    public int updateFinance(@RequestBody String params){
        Finance finance = JSON.parseObject(params , new TypeReference<Finance>() {});
        return  financeService.updateFinanceDetail(finance);
    }

    @RequestMapping("addFinance")
    @ResponseBody
    public int addFinance(@RequestBody String params){
        Finance finance = JSON.parseObject(params , new TypeReference<Finance>() {});
        return  financeService.insertFinance(finance);
    }

    @RequestMapping("deleteFinance")
    @ResponseBody
    public int deleteFinance(int financeID){
//        Integer financeID = JSON.parseObject(params,new TypeReference<Integer>() {});
        return  financeService.deleteFinance(financeID);
    }
}
