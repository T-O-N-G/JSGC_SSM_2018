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
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
//@RequestMapping("/bussiness/finance/")
@RequestMapping(produces = {"application/json; charset=UTF-8"})

public class FinanceController {
    @Resource
    private FinanceService financeService;

    @RequestMapping("/getFinanceList")
    @ResponseBody
    public String searchByConditons(HttpServletRequest request, @RequestBody String params) throws UnsupportedEncodingException {
        String userLevel=(String)request.getAttribute("level");
        String userID= (String) request.getAttribute("userID");
        System.out.println("userlevel:"+userLevel+" &&& userID:"+userID);
        System.out.println(params);
        FinanceSearchConditions fs = JSON.parseObject(params , new TypeReference<FinanceSearchConditions>() {});
        fs.setUserLevel(userLevel);fs.setUserID(userID);
        fs.parseUserID();
        fs.parseOrder();
        System.out.println(fs);
        return financeService.searchByConditions(fs);
    }

    @RequestMapping("getFinanceDetail")
    @ResponseBody
    public String getFinanceDetail(HttpServletRequest request,int financeID){

        return financeService.getFinanceDetail(financeID);
    }

    @RequestMapping("updateFinance")
    @ResponseBody
    public int updateFinance(HttpServletRequest request,@RequestBody String params){
        String userID= (String) request.getAttribute("userID");
        Finance finance = JSON.parseObject(params , new TypeReference<Finance>() {});
        return  financeService.updateFinanceDetail(finance,Integer.parseInt(userID));
    }

    @RequestMapping("addFinance")
    @ResponseBody
    public String addFinance(HttpServletRequest request,@RequestBody String params){
        String userID= (String) request.getAttribute("userID");
        Finance finance = JSON.parseObject(params , new TypeReference<Finance>() {});
        return  financeService.insertFinance(finance,Integer.parseInt(userID));
    }

    @RequestMapping("deleteFinance")
    @ResponseBody
    public int deleteFinance(int financeID){
//        Integer financeID = JSON.parseObject(params,new TypeReference<Integer>() {});
        System.out.println(financeID);
        return  financeService.deleteFinance(financeID);
    }
}
