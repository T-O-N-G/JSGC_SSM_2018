package pojo.com.jsgc.business;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

import javax.validation.constraints.Min;
import java.util.Date;
@ExcelTarget("contractEntity")
public class Contract {
    private Integer contractId;
    @Excel(name="合同编号")
    private String contractSerial;
    @Excel(name="合同名称")
    private String contractName;
    @Excel(name="责任人")
    private String contractOwner;
    @Excel(name ="合同多方")
    private String contractPartner;
    @Excel(name="签订日期" ,databaseFormat = "yyyy-MM-dd", format = "yyyy/M/D")
    private Date contractSignedTime;

    @Excel(name="合同金额")
    @Min(value = 0,message = "合同金额不能小于0")
    private Integer contractMoney;
    @Excel(name="合同内容")
    private String contractContent;
    @Excel(name="备注")
    private String contractComment;

    private Integer contractDelete;

    private Integer projectId;
    @Excel(name="项目编号")
    private String projectSerial;

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", contractSerial='" + contractSerial + '\'' +
                ", contractName='" + contractName + '\'' +
                ", contractOwner='" + contractOwner + '\'' +
                ", contractPartner='" + contractPartner + '\'' +
                ", contractSignedTime=" + contractSignedTime +
                ", contractMoney=" + contractMoney +
                ", contractContent='" + contractContent + '\'' +
                ", contractComment='" + contractComment + '\'' +
                ", contractDelete=" + contractDelete +
                ", projectId=" + projectId +
                ", projectSerial='" + projectSerial + '\'' +
                '}';
    }

    public String getProjectSerial() {
        return projectSerial;
    }

    public void setProjectSerial(String projectSerial) {
        this.projectSerial = projectSerial;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractSerial() {
        return contractSerial;
    }

    public void setContractSerial(String contractSerial) {
        this.contractSerial = contractSerial;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractOwner() {
        return contractOwner;
    }

    public void setContractOwner(String contractOwner) {
        this.contractOwner = contractOwner;
    }

    public String getContractPartner() {
        return contractPartner;
    }

    public void setContractPartner(String contractPartner) {
        this.contractPartner = contractPartner;
    }

    public Date getContractSignedTime() {
        return contractSignedTime;
    }

    public void setContractSignedTime(Date contractSignedTime) {
        this.contractSignedTime = contractSignedTime;
    }

    public Integer getContractMoney() {
        return contractMoney;
    }

    public void setContractMoney(Integer contractMoney) {
        this.contractMoney = contractMoney;
    }

    public String getContractContent() {
        return contractContent;
    }

    public void setContractContent(String contractContent) {
        this.contractContent = contractContent;
    }

    public String getContractComment() {
        return contractComment;
    }

    public void setContractComment(String contractComment) {
        this.contractComment = contractComment;
    }

    public Integer getContractDelete() {
        return contractDelete;
    }

    public void setContractDelete(Integer contractDelete) {
        this.contractDelete = contractDelete;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}