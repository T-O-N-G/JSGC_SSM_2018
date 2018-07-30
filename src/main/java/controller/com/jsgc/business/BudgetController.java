package controller.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.com.jsgc.business.BudgetService;
import util.com.jsgc.searchCondition.BudgetSearchConditions;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(produces = {"application/json; charset=UTF-8"})
public class BudgetController {

    @Resource
    private BudgetService budgetService;

    @RequestMapping("/getBudgetList")
    @ResponseBody
    public String searchByConditons(@RequestBody String params) throws UnsupportedEncodingException {
            System.out.println(params);
        BudgetSearchConditions ps = JSON.parseObject(params , new TypeReference<BudgetSearchConditions>() {});
        System.out.println(ps);
        ps.parseOrder();
        System.out.println(ps);
        return budgetService.searchByConditions(ps);
    }

    @RequestMapping("/getBudgetDetail")
    @ResponseBody
    public String getBudgetDetail(int budgetId){
        return budgetService.getBudgetDetail(budgetId);
    }
}
