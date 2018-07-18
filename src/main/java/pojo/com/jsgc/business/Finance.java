package pojo.com.jsgc.business;

import java.util.Date;

public class Finance {
    private Integer financeId;

    private String financeSerials;

    private Date financeDate;

    private String financeName;

    private Integer financeMoney;

    private Integer financeStatus;

    private Integer financeDelete;

    private Integer financeBorrowerId;

    private Integer financeLenderId;

    private Integer financeBuyOrgId;

    private Integer financeBuyMethodId;

    private Integer financeTypeId;

    private Integer payMethodId;

    private Integer projectId;

    private Integer contractId;

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
        this.financeSerials = financeSerials == null ? null : financeSerials.trim();
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
        this.financeName = financeName == null ? null : financeName.trim();
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

    public Integer getFinanceBorrowerId() {
        return financeBorrowerId;
    }

    public void setFinanceBorrowerId(Integer financeBorrowerId) {
        this.financeBorrowerId = financeBorrowerId;
    }

    public Integer getFinanceLenderId() {
        return financeLenderId;
    }

    public void setFinanceLenderId(Integer financeLenderId) {
        this.financeLenderId = financeLenderId;
    }

    public Integer getFinanceBuyOrgId() {
        return financeBuyOrgId;
    }

    public void setFinanceBuyOrgId(Integer financeBuyOrgId) {
        this.financeBuyOrgId = financeBuyOrgId;
    }

    public Integer getFinanceBuyMethodId() {
        return financeBuyMethodId;
    }

    public void setFinanceBuyMethodId(Integer financeBuyMethodId) {
        this.financeBuyMethodId = financeBuyMethodId;
    }

    public Integer getFinanceTypeId() {
        return financeTypeId;
    }

    public void setFinanceTypeId(Integer financeTypeId) {
        this.financeTypeId = financeTypeId;
    }

    public Integer getPayMethodId() {
        return payMethodId;
    }

    public void setPayMethodId(Integer payMethodId) {
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
}