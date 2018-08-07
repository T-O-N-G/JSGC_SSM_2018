package controller.com.jsgc.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Document;
import pojo.com.jsgc.business.Finance;
import service.com.jsgc.business.ContractService;
import service.com.jsgc.business.DocumentService;
import service.com.jsgc.business.FinanceService;
import service.com.jsgc.business.ProjectService;
import util.HdfsUtil;
import util.com.jsgc.searchCondition.DocumentSearchConditions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping("/bussiness/document/")
@RequestMapping(produces = {"application/json; charset=UTF-8"})
public class DocumentController {
    @Resource
    private DocumentService documentService;
    @Resource
    private ProjectService projectService;
    @Resource
    private ContractService contractService;
    @RequestMapping("/getDocList")
    @ResponseBody
    public String searchByConditons(HttpServletRequest request,@RequestBody String params) throws UnsupportedEncodingException {
        String userLevel=(String)request.getAttribute("level");
        String userID= (String) request.getAttribute("userID");
        System.out.println("userlevel:"+userLevel+" &&& userID:"+userID);
        System.out.println(params);
        DocumentSearchConditions ps = JSON.parseObject(params , new TypeReference<DocumentSearchConditions>() {});
        ps.setUserID(userID);ps.setUserLevel(userLevel);
        ps.parseUserID();
        ps.parseOrder();
        System.out.println(ps);
        return documentService.searchByConditions(ps);
    }


    @RequestMapping("getDocumentDetail")
    @ResponseBody
    public String getDocumentDetail(int documentId){
        return documentService.getDocumentDetail(documentId);
    }

    @RequestMapping("updateDocumentDetail")
    @ResponseBody
    public int updateDocumentDetail(@RequestBody String params){
        Document document = JSON.parseObject(params , new TypeReference<Document>() {});
        return  documentService.updateDocumentDetail(document);
    }

    @RequestMapping("uploadDocument")
    @ResponseBody
    public String addDocument(HttpServletRequest request,@RequestParam("documentFileAdd") MultipartFile myfile) throws ParseException, IOException {

        Document document=new Document();
        String documentSerial=request.getParameter("documentSerialAdd");document.setDocumentSerial(documentSerial);
        if(documentService.ifSerialExistAdd(documentSerial)!=0) return "错误：文档编号重复";
        String projectSerial=request.getParameter("projectSerialAdd");document.setProjectSerial(projectSerial);
        if(projectService.ifSerialExistAdd(projectSerial)==0)  return "错误：项目编号不存在";
        document.setProjectId(projectService.getProjectIDBySerial(projectSerial));
        String contractSerial=request.getParameter("contractSerialAdd");document.setContractSerial(contractSerial);
        if(!contractSerial.equals("")){
            if(contractService.ifSerialExistAdd(contractSerial)==0)
            return "错误：合同编号不存在";
            document.setContractId(contractService.getContractIDBySerial(contractSerial));
        }
        String documentName=request.getParameter("documentNameAdd") ;document.setDocumentName(documentName);
        String documentOwner=request.getParameter("documentOwnerAdd");document.setDocumentOwner(documentOwner);
        String documentComment=request.getParameter("documentCommentAdd");document.setDocumentComment(documentComment);
        String documentUploadTime=request.getParameter("documentUploadTimeAdd");
        DateFormat df=new SimpleDateFormat("yyyy-mm-dd");Date date=df.parse(documentUploadTime);
        document.setDocumentUploadTime(date);
        document.setDocumentName(myfile.getOriginalFilename());
        String dfsUrl;
        if(contractSerial.equals("")){
           dfsUrl= HdfsUtil.uploadFromUser(request,myfile,new Path("/jsgc/"+projectSerial+"/"));
        }else {
           dfsUrl= HdfsUtil.uploadFromUser(request,myfile,new Path("/jsgc/"+projectSerial+"/"+contractSerial+"/"));
        }
        document.setDocumentUrl(dfsUrl);
        System.out.println(document);
        documentService.insertDocument(document);
        return "成功！";
    }

    @RequestMapping("deleteDocument")
    @ResponseBody
    public int deleteDocument(int documentID){
//        Integer documentID = JSON.parseObject(params,new TypeReference<Integer>() {});
        return documentService.deleteDocument(documentID);
    }
    @RequestMapping("FullTextSearch")
    @ResponseBody
    public List<HdfsUtil.DisplayAndRealPath> FullTextSearch(String queryContent){
        List<HdfsUtil.DisplayAndRealPath> outcome=HdfsUtil.searchIndex(queryContent);
        return outcome;
    }
}

