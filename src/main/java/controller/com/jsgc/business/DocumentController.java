package controller.com.jsgc.business;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public int updateDocumentDetail(Document document){
        return  documentService.updateDocumentDetail(document);
    }
}

