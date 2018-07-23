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

import javax.annotation.Resource;

@Controller
@RequestMapping("/bussiness/finance/")
public class FinanceController {
    @Resource
    private FinanceService financeService;

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
