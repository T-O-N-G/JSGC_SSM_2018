package controller.com.jsgc.business;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.alibaba.fastjson.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Project;
import service.com.jsgc.business.ContractService;
import service.com.jsgc.business.ProjectService;
import util.FileUtil;
import util.com.jsgc.searchCondition.ContractSearchConditions;
import util.com.jsgc.searchCondition.ProjectSearchConditions;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Controller
public class BatchDownLoadController {
    @Resource
    ContractService contractService;
    @Resource
    ProjectService projectService;
    @RequestMapping("/batchDownloadContracts")
    @ResponseBody
    public ResponseEntity<byte[]>  batchDownloadContracts(HttpServletRequest request) throws ParseException {
        String param=request.getParameter("param");
        System.out.println(param);
        ContractSearchConditions cs = JSON.parseObject(param , new TypeReference<ContractSearchConditions>(){});
        System.out.println(cs);
        System.out.println(cs.getOrder());
        System.out.println("cs1111");
        cs.parseDateRange();
        cs.parseOrder();
        System.out.println(cs);
        List<Contract> contractList=contractService.selectByConditions(cs);
        System.out.println("条件搜索获取的列表如下：");
        for(Contract i :contractList){
            System.out.println(i);
        }
        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("种类","学生"),
                Contract.class,contractList );
        String cacheFileName= "d://"+UUID.randomUUID()+"cache.xls";

        File file=new File(cacheFileName);//本地缓存
        FileOutputStream out=null;
        HttpHeaders httpHeaders = new HttpHeaders();
        try {
            out=new FileOutputStream(cacheFileName);
            workbook.write(out);
            String fileName = new String("contract.xls".getBytes("UTF-8"), "iso-8859-1");
            httpHeaders.setContentDispositionFormData("attachment", fileName);
            httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);
        }
        catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(out!=null)
                out.close();
                FileUtils.forceDelete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ResponseEntity<byte[]> b=null;
        return b;
    }
//    @RequestMapping("/batchDownloadProjects")
//    @ResponseBody
//    public ResponseEntity<byte[]>  batchDownloadProjects(HttpServletRequest request) throws ParseException {
//        String param=request.getParameter("param");
//        System.out.println(param);
//        ProjectSearchConditions ps = JSON.parseObject(param , new TypeReference<ProjectSearchConditions>(){});
//        ps.parseOrder();
//        System.out.println(ps);
//       // List<Project> projects=projectService.searchByConditions()
//        return "true"
//    }

}
