package controller.com.jsgc.business;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Contract;
import service.com.jsgc.business.ContractService;
import util.com.jsgc.RequestPage;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/bussiness/contract/")
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
    public int updateContractDetail(Contract contract){
        return   contractService.updateContractDetail(contract);
    }

}
