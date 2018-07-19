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