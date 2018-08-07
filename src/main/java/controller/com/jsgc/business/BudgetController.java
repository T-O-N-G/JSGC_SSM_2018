package controller.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.BudgetDetail;
import service.com.jsgc.business.BudgetService;
import util.com.jsgc.searchCondition.BudgetSearchConditions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

@Controller
@RequestMapping(produces = {"application/json; charset=UTF-8"})
public class BudgetController {

    @Resource
    private BudgetService budgetService;

    @RequestMapping("/getBudgetList")
    @ResponseBody
    public String searchByConditons(HttpServletRequest request,@RequestBody String params) throws UnsupportedEncodingException, ParseException {
        String userLevel=(String)request.getAttribute("level");
        String userID= (String) request.getAttribute("userID");
        System.out.println("userlevel:"+userLevel+" &&& userID:"+userID);
        System.out.println(params);
        BudgetSearchConditions ps = JSON.parseObject(params , new TypeReference<BudgetSearchConditions>() {});
        ps.setUserID(userID);ps.setUserLevel(userLevel);
        ps.parseUserID();
        ps.parseDateRange();
        ps.parseOrder();
        System.out.println(ps);
        return budgetService.searchByConditionsNew(ps);
    }

    @RequestMapping("/getBudgetDetail")
    @ResponseBody
    public BudgetDetail getBudgetDetail(int budgetID){
        return budgetService.getBudgetDetail(budgetID);
    }
}
