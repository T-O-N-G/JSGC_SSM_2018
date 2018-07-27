package controller.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Document;
import pojo.com.jsgc.business.Finance;
import service.com.jsgc.business.DocumentService;
import service.com.jsgc.business.FinanceService;
import util.com.jsgc.searchCondition.DocumentSearchConditions;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;

@Controller
//@RequestMapping("/bussiness/document/")
@RequestMapping(produces = {"application/json; charset=UTF-8"})
public class DocumentController {
    @Resource
    private DocumentService documentService;

    @RequestMapping("/getDocList")
    @ResponseBody
    public String searchByConditons(@RequestBody String params) throws UnsupportedEncodingException {
        System.out.println(params);
        DocumentSearchConditions ps = JSON.parseObject(params , new TypeReference<DocumentSearchConditions>() {});
        System.out.println(ps);
        ps.parseOrder();
        System.out.println(ps);
        return documentService.searchByConditions(ps);
    }


    @RequestMapping("getDocumentDetail")
    @ResponseBody
    public String getDocumentDetail(int documentID){
        return documentService.getDocumentDetail(documentID);
    }

    @RequestMapping("updateDocumentDetail")
    @ResponseBody
    public int updateDocumentDetail(@RequestBody String params){
        Document document = JSON.parseObject(params , new TypeReference<Document>() {});
        return  documentService.updateDocumentDetail(document);
    }

    @RequestMapping("addDocument")
    @ResponseBody
    public int addDocument(@RequestBody String params){
        Document document = JSON.parseObject(params , new TypeReference<Document>() {});
        return  documentService.insertDocument(document);
    }

    @RequestMapping("deleteDocument")
    @ResponseBody
    public int deleteDocument(int documentID){
//        Integer documentID = JSON.parseObject(params,new TypeReference<Integer>() {});
        return documentService.deleteDocument(documentID);
    }
}

