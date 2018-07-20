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

import javax.annotation.Resource;

@Controller
@RequestMapping("/bussiness/document/")
public class DocumentController {
    @Resource
    private DocumentService documentService;

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
        return documentService.deleteDocument(documentID);
    }
}

