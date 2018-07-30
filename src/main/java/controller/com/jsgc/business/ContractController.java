package controller.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import pojo.com.jsgc.business.Contract;
import service.com.jsgc.business.ContractService;
//import util.com.jsgc.RequestPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Controller
//@RequestMapping("/bussiness/contract/")
@RequestMapping(produces = {"application/json; charset=UTF-8"})

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
    public int deleteContract(Integer contractID){
//        Integer contractID = JSON.parseObject(params,new TypeReference<Integer>() {});
        return  contractService.deleteContract(contractID);
    }



//    @RequestMapping("batchUploadContracts")
//    @ResponseBody
//    public String batchUploadContracts(HttpServletRequest request){
////        File fileUploadPath=new File("classPath:batchUploadContracts");
////        if(!fileUploadPath.exists()){
////            fileUploadPath.mkdir();
////        }
//        //获取工程路径
//        System.out.println("haleo");
//        String path=request.getSession().getServletContext().getRealPath("/upload/batchUploadContracts");
//
//        File dir=new File("D://batchUploadContracts/");
//        if(!dir.exists()){
//            dir.mkdirs();
//        }
//        long startTime = System.currentTimeMillis();
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//        if (multipartResolver.isMultipart(request)) {
//            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//            Iterator<String> ite = multipartHttpServletRequest.getFileNames();
//
//            while (ite.hasNext()) {
//                System.out.println("有没有");
//                MultipartFile file = multipartHttpServletRequest.getFile(ite.next());
//                System.out.println(file.getSize());
//                File localFile = new File(path + file.getOriginalFilename());
//
//                try {
//                    file.transferTo(localFile);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("上传文件共使用时间:" + (endTime - startTime));
//        return "success";
//
//    }

}
