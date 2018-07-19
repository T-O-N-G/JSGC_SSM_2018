package pojo.com.jsgc.business;

import java.util.Date;

public class Contract {
    private Integer contractId;

    private String contractSerial;

    private String contractName;

    private String contractOwner;

    private String contractPartner;

    private Date contractSignedTime;

    private Integer contractMoney;

    private String contractContent;

    private String contractComment;

    private Integer contractDelete;

    private Integer projectId;

    private String projectSerial;

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
        this.contractSerial = contractSerial == null ? null : contractSerial.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getContractOwner() {
        return contractOwner;
    }

    public void setContractOwner(String contractOwner) {
        this.contractOwner = contractOwner == null ? null : contractOwner.trim();
    }

    public String getContractPartner() {
        return contractPartner;
    }

    public void setContractPartner(String contractPartner) {
        this.contractPartner = contractPartner == null ? null : contractPartner.trim();
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
        this.contractContent = contractContent == null ? null : contractContent.trim();
    }

    public String getContractComment() {
        return contractComment;
    }

    public void setContractComment(String contractComment) {
        this.contractComment = contractComment == null ? null : contractComment.trim();
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