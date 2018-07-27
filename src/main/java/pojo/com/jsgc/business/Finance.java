package pojo.com.jsgc.business;

import pojo.com.jsgc.admin.*;

import java.util.Date;

public class Finance {
    private Integer financeId;

    private String financeSerials;

    private Date financeDate;

    private String financeName;

    private Integer financeMoney;

    private Integer financeStatus;

    private Integer financeDelete;

    private String financeBorrowerId;

    private String financeLenderId;

    private String financeBuyOrgId;

    private String financeBuyMethodId;

    private String financeTypeId;

    private String payMethodId;

    private Integer projectId;

    private String projectSerial;

    private Integer contractId;

    private String contractSerial;

    private Project project;
    private Contract contract;

   // private Accountant accountant;
    private PayMethod payMethod;
    private BuyMethod buyMethod;
    private BuyOrgForm buyOrgForm;
    private BuyType buyType;

    private Accountant lender;
    private Accountant borrower;

    public Accountant getLender() {
        return lender;
    }

    public void setLender(Accountant lender) {
        this.lender = lender;
    }

    public Accountant getBorrower() {
        return borrower;
    }

    public void setBorrower(Accountant borrower) {
        this.borrower = borrower;
    }

    public String getProjectSerial() {
        return projectSerial;
    }

    public void setProjectSerial(String projectSerial) {
        this.projectSerial = projectSerial;
    }

    public String getContractSerial() {
        return contractSerial;
    }

    public void setContractSerial(String contractSerial) {
        this.contractSerial = contractSerial;
    }

    public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    public String getFinanceSerials() {
        return financeSerials;
    }

    public void setFinanceSerials(String financeSerials) {
        this.financeSerials = financeSerials;
    }

    public Date getFinanceDate() {
        return financeDate;
    }

    public void setFinanceDate(Date financeDate) {
        this.financeDate = financeDate;
    }

    public String getFinanceName() {
        return financeName;
    }

    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }

    public Integer getFinanceMoney() {
        return financeMoney;
    }

    public void setFinanceMoney(Integer financeMoney) {
        this.financeMoney = financeMoney;
    }

    public Integer getFinanceStatus() {
        return financeStatus;
    }

    public void setFinanceStatus(Integer financeStatus) {
        this.financeStatus = financeStatus;
    }

    public Integer getFinanceDelete() {
        return financeDelete;
    }

    public void setFinanceDelete(Integer financeDelete) {
        this.financeDelete = financeDelete;
    }

    public String getFinanceBorrowerId() {
        return financeBorrowerId;
    }

    public void setFinanceBorrowerId(String financeBorrowerId) {
        this.financeBorrowerId = financeBorrowerId;
    }

    public String getFinanceLenderId() {
        return financeLenderId;
    }

    public void setFinanceLenderId(String financeLenderId) {
        this.financeLenderId = financeLenderId;
    }

    public String getFinanceBuyOrgId() {
        return financeBuyOrgId;
    }

    public void setFinanceBuyOrgId(String financeBuyOrgId) {
        this.financeBuyOrgId = financeBuyOrgId;
    }

    public String getFinanceBuyMethodId() {
        return financeBuyMethodId;
    }

    public void setFinanceBuyMethodId(String financeBuyMethodId) {
        this.financeBuyMethodId = financeBuyMethodId;
    }

    public String getFinanceTypeId() {
        return financeTypeId;
    }

    public void setFinanceTypeId(String financeTypeId) {
        this.financeTypeId = financeTypeId;
    }

    public String getPayMethodId() {
        return payMethodId;
    }

    public void setPayMethodId(String payMethodId) {
        this.payMethodId = payMethodId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }



    public PayMethod getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(PayMethod payMethod) {
        this.payMethod = payMethod;
    }

    public BuyMethod getBuyMethod() {
        return buyMethod;
    }

    public void setBuyMethod(BuyMethod buyMethod) {
        this.buyMethod = buyMethod;
    }

    public BuyOrgForm getBuyOrgForm() {
        return buyOrgForm;
    }

    public void setBuyOrgForm(BuyOrgForm buyOrgForm) {
        this.buyOrgForm = buyOrgForm;
    }

    public BuyType getBuyType() {
        return buyType;
    }

    public void setBuyType(BuyType buyType) {
        this.buyType = buyType;
    }
}