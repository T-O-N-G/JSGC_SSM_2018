package pojo.com.jsgc.business;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import java.util.Date;
@ExcelTarget("contractEntity")
public class Contract {
    private Integer contractId;
    @Excel(name="合同编号")
    private String contractSerial;
    @Excel(name="合同名称")
    private String contractName;

    private String contractOwner;
    @Excel(name ="合同多方")
    private String contractPartner;
    @Excel(name="签订日期" ,databaseFormat = "yyyy-MM-dd", format = "yyyy/M/d")
    private Date contractSignedTime;
    private Integer contractMoney;
    @Excel(name="合同内容")
    private String contractContent;
    @Excel(name="备注")
    private String contractComment;

    private Integer contractDelete;
    @Excel(name = "建设内容编号")
    private String buildContentId;
    private String buildInfo;
    private Integer projectId;
    @Excel(name="项目编号")
    private String projectSerial;
    //lzq,所属项目
    private Project project;
    //lzq,建设内容

    private int allFinancesPaid;
    private int allFinancesNotPaid;

    public int getAllFinancesPaid() {
        return allFinancesPaid;
    }

    public void setAllFinancesPaid(int allFinancesPaid) {
        this.allFinancesPaid = allFinancesPaid;
    }

    public int getAllFinancesNotPaid() {
        return allFinancesNotPaid;
    }

    public void setAllFinancesNotPaid(int allFinancesNotPaid) {
        this.allFinancesNotPaid = allFinancesNotPaid;
    }

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
                ", buildContentId='" + buildContentId + '\'' +
                ", buildInfo='" + buildInfo + '\'' +
                ", projectId=" + projectId +
                ", projectSerial='" + projectSerial + '\'' +
                ", project=" + project +
                '}';
    }

    public String getBuildContentId() {
        return buildContentId;
    }

    public void setBuildContentId(String buildContentId) {
        this.buildContentId = buildContentId;
    }

    public String getBuildInfo() {
        return buildInfo;
    }

    public void setBuildInfo(String buildInfo) {
        this.buildInfo = buildInfo;
    }


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
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