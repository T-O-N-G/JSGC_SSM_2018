package controller.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Contract;
import service.com.jsgc.business.ContractService;
import util.com.jsgc.RequestPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
//@RequestMapping("/bussiness/contract/")
public class ContractController {
    @Resource
    private ContractService contractService;

    @RequestMapping("getContractDetail")
    @ResponseBody
    public String getContractDetail(int contractID){
        return contractService.getContractDetail(contractID);
    }

    @RequestMapping("updateContractDetail")
    @ResponseBody
    public int updateContractDetail(@RequestBody String params){
        Contract contract = JSON.parseObject(params , new TypeReference<Contract>() {});
        return   contractService.updateContractDetail(contract);
    }

    @RequestMapping("addContract")
    @ResponseBody
    public int addContract(@RequestBody String params){
        Contract contract = JSON.parseObject(params , new TypeReference<Contract>() {});
        return   contractService.insertContract(contract);
    }

    @RequestMapping("deleteContract")
    @ResponseBody
    public int deleteContract(int contractID){
        return  contractService.deleteContract(contractID);
    }
}
