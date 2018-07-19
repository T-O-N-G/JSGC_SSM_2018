package controller.com.jsgc.business;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Finance;
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
    public int updateFinance(Finance finance){
        return  financeService.updateFinanceDetail(finance);
    }
}
