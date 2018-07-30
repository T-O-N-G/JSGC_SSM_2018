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
import pojo.com.jsgc.business.Project;
import service.com.jsgc.business.ContractService;
import service.com.jsgc.business.ProjectService;
import util.FileUtil;


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
        String userID= request.getParameter("userID");
        System.out.println("userID:"+userID);
        String oldFileName = myfile.getOriginalFilename(); // 获取上传文件的原名
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
            int total=results.size();
            //标记行号
            HashMap<Integer,Contract> row_Contract=new HashMap<>();
            int i=2;
            for(Contract c:results){
                row_Contract.put(i,c);
                i++;
            }
            //数据不合法处理
            List<Integer> row_ToRemove=new ArrayList<>();//要移除的行号
            Set<String>serials=new HashSet<String>();//存放内部编号
            List<Integer> rowNumsRepeatInner=new ArrayList<Integer>();//存放内部冗余编号的行号
            List<String> serialsInDB=contractService.getSerialList();//数据库编号
            List<Integer> rowNumsRepeatDB=new ArrayList<>();//存放与数据库编号冗余的行号
            List<String> projectSerialsInDB=projectService.getSerials();//数据库（外键）编号
            List<Integer> rowNumsOutJoinNotExist=new ArrayList<>();//存放外键不存在的行号
            for(Map.Entry<Integer,Contract> entry:row_Contract.entrySet()){
                Contract temp=entry.getValue();
                String tempSerial=temp.getContractSerial();
                if(!serials.contains(tempSerial)&&tempSerial!=null&&tempSerial!=""){//如果项目编号不为空且excel内部不重复
                    serials.add(temp.getContractSerial());
                    if(serialsInDB.contains(tempSerial)){
                        rowNumsRepeatDB.add(entry.getKey());
                        row_ToRemove.add(entry.getKey());
                    }else{//判断与数据库内编号是否重复,若不重复
                        String tempProjectSerial =temp.getProjectSerial();
                        if(!projectSerialsInDB.contains(tempProjectSerial)){
                            rowNumsOutJoinNotExist.add(entry.getKey());
                            row_ToRemove.add(entry.getKey());
                        }else{//判断外键是否存在，若存在.
                            //根据所属项目编号，查询projectId
                            int projectId=projectService.getProjectIDBySerial(tempProjectSerial);
                            temp.setProjectId(projectId);
                        }
                    }
                }else{
                    rowNumsRepeatInner.add(entry.getKey());
                    row_ToRemove.add(entry.getKey());
                }
            }
            //把<行号，实体>非法的行剔除
            for(int rowDelete:row_ToRemove){
                row_Contract.remove(rowDelete);
            }
            //取出entry的value加入List,mybatis批量导入
            List<Contract> readyToInsert=new ArrayList<>();
            for(Map.Entry<Integer,Contract> entry:row_Contract.entrySet()){
                readyToInsert.add(entry.getValue());
            }
            if(readyToInsert.size()>0){
                contractService.batchInsert(readyToInsert);
            }
            int left=readyToInsert.size();
            int defeatSize=total-left;

            // 将新图片名称返回到前端
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("successSize", left);
            map.put("defeatSize", defeatSize);
            map.put("rowNumsRepeatInner",rowNumsRepeatInner);
            map.put("rowNumsRepeatDB",rowNumsRepeatDB);
            map.put("rowNumsOutJoinNotExist",rowNumsOutJoinNotExist);
            return map;
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "文件不合法");
            return map;
        }
    }

//    @RequestMapping("/batchUploadProjects")
//    @ResponseBody
//    public Map<String, Object> batchUploadProjects(HttpServletRequest request,@RequestParam("file") MultipartFile myfile) throws IOException{
//        // 原始名称
//        String oldFileName = myfile.getOriginalFilename(); // 获取上传文件的原名
//        System.out.println(oldFileName);
//        //替换
//        String path=request.getSession().getServletContext().getRealPath("/upload/batchUploadProjects");
//        File dir=new File(path);
//        if(!dir.exists()){
//            dir.mkdirs();
//        }
//        // 上传文件
//        if (myfile != null && oldFileName != null && oldFileName.length() > 0) {
//            // 新的文件
//            String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
//            File newFile = new File(dir + "\\" + newFileName);
//            // 将内存中的数据写入磁盘
//            myfile.transferTo(newFile);
//            //读取文件,交给mybatis处理
//            ImportParams params = new ImportParams();
//            params.setHeadRows(1);
//            //替换
//            List<Project> results = ExcelImportUtil.importExcel(newFile, Project.class, params);
//            int total=results.size();
//            //标记行号
//            //替换
//            HashMap<Integer,Project> row_Project=new HashMap<>();
//
//            int i=2;
//            //替换
//            for(Project p:results){
//                row_Project.put(i,p);
//                i++;
//            }
//            //数据不合法处理
//            List<Integer> row_ToRemove=new ArrayList<>();//要移除的行号
//            Set<String>serials=new HashSet<String>();//存放内部编号
//            List<Integer> rowNumsRepeatInner=new ArrayList<Integer>();//存放内部冗余编号的行号
//            //替换
//            List<String> serialsInDB=projectService.getSerials();//数据库编号
//            List<Integer> rowNumsRepeatDB=new ArrayList<>();//存放与数据库编号冗余的行号
//            //替换
//            List<String> projectSerialsInDB=projectService.getSerials();//数据库（外键）编号
//            List<String> projectDepartmentSerialsInDB=
//            List<Integer> rowNumsOutJoinNotExist=new ArrayList<>();//存放外键不存在的行号
//            for(Map.Entry<Integer,Project> entry:row_Project.entrySet()){
//                Project temp=entry.getValue();
//                String tempSerial=temp.getProjectSerial();
//                if(!serials.contains(tempSerial)&&tempSerial!=null&&tempSerial!=""){//如果项目编号不为空且excel内部不重复
//                    serials.add(temp.getProjectSerial());
//                    if(serialsInDB.contains(tempSerial)){
//                        rowNumsRepeatDB.add(entry.getKey());
//                        row_ToRemove.add(entry.getKey());
//                    }else{//判断与数据库内编号是否重复,若不重复
//                        String tempProjectSerial =temp.getProjectSerial();
//                        if(!projectSerialsInDB.contains(tempProjectSerial)){
//                            rowNumsOutJoinNotExist.add(entry.getKey());
//                            row_ToRemove.add(entry.getKey());
//                        }else{//判断外键是否存在，若存在.
//                            //根据所属项目编号，查询projectId
//                            int projectId=projectService.getProjectIDBySerial(tempProjectSerial);
//                            temp.setProjectId(projectId);
//                        }
//                    }
//                }else{
//                    rowNumsRepeatInner.add(entry.getKey());
//                    row_ToRemove.add(entry.getKey());
//                }
//            }
//            //把<行号，实体>非法的行剔除
//            for(int rowDelete:row_ToRemove){
//                row_Contract.remove(rowDelete);
//            }
//            //取出entry的value加入List,mybatis批量导入
//            List<Contract> readyToInsert=new ArrayList<>();
//            for(Map.Entry<Integer,Contract> entry:row_Contract.entrySet()){
//                readyToInsert.add(entry.getValue());
//            }
//            if(readyToInsert.size()>0){
//                contractService.batchInsert(readyToInsert);
//            }
//            int left=readyToInsert.size();
//            int defeatSize=total-left;
//
//            // 将新图片名称返回到前端
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("successSize", left);
//            map.put("defeatSize", defeatSize);
//            map.put("rowNumsRepeatInner",rowNumsRepeatInner);
//            map.put("rowNumsRepeatDB",rowNumsRepeatDB);
//            map.put("rowNumsOutJoinNotExist",rowNumsOutJoinNotExist);
//            return map;
//        } else {
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("error", "文件不合法");
//            return map;
//        }
//    }


}
