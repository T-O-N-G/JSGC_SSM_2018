package util.com.jsgc.VerifyHandler;

import cn.afterturn.easypoi.excel.entity.result.ExcelVerifyHandlerResult;
import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import cn.afterturn.easypoi.handler.inter.IExcelVerifyHandler;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Hyperlink;
import pojo.com.jsgc.business.Contract;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class contractsVerify implements IExcelVerifyHandler<Contract>{
    private Set<String> serialsInExcel=new HashSet<>();
    {
        serialsInExcel.add("合同编号1");
        serialsInExcel.add("合同编号2");
    }
    @Override
    public ExcelVerifyHandlerResult verifyHandler(Contract c) {
        ExcelVerifyHandlerResult evhr=new ExcelVerifyHandlerResult();
        if(serialsInExcel.contains(c.getProjectSerial())){
            evhr.setMsg("重复");
            evhr.setSuccess(false);
        }else {
            evhr.setSuccess(true);

        }
        return evhr;

    }
}
