package controller.com.jsgc.business;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.com.jsgc.business.ContractService;
import service.com.jsgc.business.ProjectService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class BatchDownLoadController {
    @Resource
    ContractService contractService;
    @Resource
    ProjectService projectService;
    @RequestMapping("/batchDownloadContracts")
    public ResponseEntity<byte[]> batchDownloadContracts(HttpServletRequest request){

        String path = "D:\\P\\"+filename;
        File file = new File(path);
        HttpHeaders httpHeaders = new HttpHeaders();
        String fileName = new String(filename.getBytes("UTF-8"), "iso-8859-1");
        httpHeaders.setContentDispositionFormData("attachment", fileName);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);
    }
}
