import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import pojo.com.jsgc.admin.Department;
import pojo.com.jsgc.admin.User;
import pojo.com.jsgc.business.Contract;
import pojo.com.jsgc.business.Project;
import util.com.jsgc.VerifyHandler.contractsVerify;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class testExcel {
    public static void main(String[] args) throws FileNotFoundException {
//        List<Category> categories=new ArrayList<Category>() ;
//        categories.add(new Category(1,"a"));
//        categories.add(new Category(2,"b"));
//        categories.add(new Category(3,"c"));
//        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("种类","学生"),
//                Category.class,categories );
//        FileOutputStream out=new FileOutputStream("e://category.xls");
//        try {
//            workbook.write(out);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        List<Project> projects=new ArrayList<Project>();
        Project a=new Project();
        a.setProjectSerial("1001");
        a.setProjectEndTime(new Date());
        a.setProjectName("hehe");
        a.setProjectStatus(0);
        User auser=new User(); auser.setUserName("呵呵");
       // a.setProjectCharger(auser);
        Project b=new Project();
        b.setProjectSerial("1002");
        b.setProjectEndTime(new Date());
        b.setProjectStatus(3);
        b.setProjectName("xixi");
        Department bDept=new Department();bDept.setDepartmentName("嘻嘻");
       // b.setProjectDepartment(bDept);
        projects.add(a);
        projects.add(b);
        Workbook workbook= ExcelExportUtil.exportExcel(new ExportParams("种类","学生"),
                Project.class,projects );
        FileOutputStream out=new FileOutputStream("e://Pro.xls");
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public  void testBatchInsert(){
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        long start = new Date().getTime();
        List<Project> list = ExcelImportUtil.importExcel(
                new File("e://Pro.xls"),
                Project.class, params);
        System.out.println(new Date().getTime() - start);
        System.out.println(list);
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));

    }
    @Test
    //无验证
    public  void testBatchInsertContracts(){

        ImportParams params = new ImportParams();
        params.setHeadRows(1);
        //params.setKeyIndex(1);
        //params.setNeedVerfiy(true);
        long start = new Date().getTime();
        List<Contract> list = ExcelImportUtil.importExcel(
                new File("E://contracts.xls"),
                Contract.class, params);
        for(Contract contract:list){
            String serial= contract.getContractSerial();
            String projectSerial=contract.getProjectSerial();
            //算法策略:先校验导入的Excel的主键Serial是否有重复，若有的话，直接取第一个。Excel丢弃行给出提示：重复的主键编号
            //再那这个Set<String>的Serial去比对数据库的主键Serial，若有冲突，删掉。比对外键Serial,若不存在，删掉。丢弃行分别给出提示
            //导入剩下的合法行，查询出外键id.调用Mapper导入。
            //校验Serial->
            //1.未在,先调用mapper获取projectid，再调用mapper插入。
            //2.已在，失败，Excel对应行尾标记失败原因。
        }
        System.out.println(new Date().getTime() - start);
        for(Contract i : list){
            System.out.println(i);
        }
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
    }
    @Test
    //带验证
    public  void testBatchInsertContractsWithValid(){
        try {
            ImportParams params = new ImportParams();
            params.setNeedVerfiy(true);
            params.setVerifyHandler(new contractsVerify());
            //params.setVerfiyGroup(new Class[]{ViliGroupOne.class});
            ExcelImportResult<Contract> result = ExcelImportUtil.importExcelMore(
                    new File("E://contracts.xls"),
                    Contract.class, params);
            FileOutputStream fos = new FileOutputStream("E://ExcelVerifyTest.basetest.xls");
            result.getWorkbook().write(fos);
            fos.close();
            for (int i = 0; i < result.getList().size(); i++) {
                System.out.println(ReflectionToStringBuilder.toString(result.getList().get(i)));
            }
            Assert.assertTrue(result.getList().size() == 1);
            Assert.assertTrue(result.isVerfiyFail());
        } catch (Exception e) {
            //LOGGER.error(e.getMessage(),e);
            e.printStackTrace();
        }
    }
    @Test
    public void testNullToString(){
        String a=null;
        System.out.println(a);
        System.out.println(a==null);
    }
}
