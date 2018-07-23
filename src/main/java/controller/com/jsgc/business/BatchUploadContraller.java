package controller.com.jsgc.business;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import pojo.com.jsgc.business.Contract;
import service.com.jsgc.business.ContractService;
import service.com.jsgc.business.ProjectService;
import util.FileUtil;
import util.com.jsgc.VerifyHandler.contractsVerify;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class BatchUploadContraller {
    @Resource
    ContractService contractService;
    @Resource
    ProjectService projectService;
    @RequestMapping("/batchUploadContracts")
    @ResponseBody
    public Map<String, Object> batchUploadContracts(HttpServletRequest request,@RequestParam("file") MultipartFile myfile) throws IOException {
        // 原始名称
        String oldFileName = myfile.getOriginalFilename(); // 获取上传文件的原名
        System.out.println(oldFileName);
        String path=request.getSession().getServletContext().getRealPath("/upload/batchUploadContracts");
        File dir=new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
        // 上传文件
        if (myfile != null && oldFileName != null && oldFileName.length() > 0) {
            // 新的文件
            String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
            File newFile = new File(dir + "\\" + newFileName);
            // 将内存中的数据写入磁盘
            myfile.transferTo(newFile);
            //读取文件,交给mybatis处理
            ImportParams params = new ImportParams();
            params.setHeadRows(1);
            List<Contract> results = ExcelImportUtil.importExcel(newFile, Contract.class, params);
            //标记行号
            HashMap<Integer,Contract> row_Contract=new HashMap<>();
            int i=2;
            for(Contract c:results){
                row_Contract.put(i,c);
                i++;
            }
            //数据编号重复处理
            Set<String>serials=new HashSet<String>();//存放去重的编号列
            List<Integer> rowNumsRepeatInner=new ArrayList<Integer>();//存放内部冗余编号的行号
            for(Map.Entry<Integer,Contract> entry:row_Contract.entrySet()){
                Contract temp=entry.getValue();
                String tempSerial=temp.getContractSerial();
                if(!serials.contains(tempSerial)&&tempSerial!=null&&tempSerial!=""){
                    serials.add(temp.getContractSerial());
                }else{
                    rowNumsRepeatInner.add(entry.getKey());
                    row_Contract.remove(entry.getKey());
                }
            }
            System.out.println("rowNumsRepeatInner:");
            System.out.println(rowNumsRepeatInner);
            //与数据库编号重复处理
            List<String> serialsInDB=contractService.getSerialList();
            List<Integer> rowNumsRepeatDB=new ArrayList<>();//存放与数据库编号冗余的行号
            for(Map.Entry<Integer,Contract> entry:row_Contract.entrySet()){
                Contract temp=entry.getValue();
                String tempSerial=temp.getContractSerial();
                if (serialsInDB.contains(tempSerial)){
                    rowNumsRepeatDB.add(entry.getKey());
                    row_Contract.remove(entry.getKey());
                }
            }
            System.out.println("rowNumsRepeatDB:");
            System.out.println(rowNumsRepeatDB);

            //外键不存在处理
            List<String> projectSerialsInDB=projectService.getSerials();
            List<Integer> rowNumsOutJoinNotExist=new ArrayList<>();//存放外键不存在的行号
            for(Map.Entry<Integer,Contract> entry:row_Contract.entrySet()){
                Contract temp=entry.getValue();
                String tempProjectSerial =temp.getProjectSerial();
                if(!projectSerialsInDB.contains(tempProjectSerial)){
                    rowNumsOutJoinNotExist.add(entry.getKey());
                    row_Contract.remove(entry.getKey());
                }
            }
            System.out.println("rowNumsOutJoinNotExist:");
            System.out.println(rowNumsOutJoinNotExist);
            System.out.println("row_Contract:");
            System.out.println(row_Contract);







            // 将新图片名称返回到前端
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "成功啦");
            map.put("url", newFileName);
            return map;
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "文件不合法");
            return map;
        }
    }




}
