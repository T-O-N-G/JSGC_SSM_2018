package pojo.com.jsxm.business;

import java.util.Date;

public class Finance {
    private Integer financeid;

    private String financeserials;

    private Date financedate;

    private String financename;

    private Integer financemoney;

    private Integer financestatus;

    private Integer financedelete;

    private Integer financeborrowerid;

    private Integer financelenderid;

    private Integer financebuyorgid;

    private Integer financebuymethodid;

    private Integer financetypeid;

    private Integer paymethodid;

    private Integer projectid;

    private Integer contractid;

    public Integer getFinanceid() {
        return financeid;
    }

    public void setFinanceid(Integer financeid) {
        this.financeid = financeid;
    }

    public String getFinanceserials() {
        return financeserials;
    }

    public void setFinanceserials(String financeserials) {
        this.financeserials = financeserials == null ? null : financeserials.trim();
    }

    public Date getFinancedate() {
        return financedate;
    }

    public void setFinancedate(Date financedate) {
        this.financedate = financedate;
    }

    public String getFinancename() {
        return financename;
    }

    public void setFinancename(String financename) {
        this.financename = financename == null ? null : financename.trim();
    }

    public Integer getFinancemoney() {
        return financemoney;
    }

    public void setFinancemoney(Integer financemoney) {
        this.financemoney = financemoney;
    }

    public Integer getFinancestatus() {
        return financestatus;
    }

    public void setFinancestatus(Integer financestatus) {
        this.financestatus = financestatus;
    }

    public Integer getFinancedelete() {
        return financedelete;
    }

    public void setFinancedelete(Integer financedelete) {
        this.financedelete = financedelete;
    }

    public Integer getFinanceborrowerid() {
        return financeborrowerid;
    }

    public void setFinanceborrowerid(Integer financeborrowerid) {
        this.financeborrowerid = financeborrowerid;
    }

    public Integer getFinancelenderid() {
        return financelenderid;
    }

    public void setFinancelenderid(Integer financelenderid) {
        this.financelenderid = financelenderid;
    }

    public Integer getFinancebuyorgid() {
        return financebuyorgid;
    }

    public void setFinancebuyorgid(Integer financebuyorgid) {
        this.financebuyorgid = financebuyorgid;
    }

    public Integer getFinancebuymethodid() {
        return financebuymethodid;
    }

    public void setFinancebuymethodid(Integer financebuymethodid) {
        this.financebuymethodid = financebuymethodid;
    }

    public Integer getFinancetypeid() {
        return financetypeid;
    }

    public void setFinancetypeid(Integer financetypeid) {
        this.financetypeid = financetypeid;
    }

    public Integer getPaymethodid() {
        return paymethodid;
    }

    public void setPaymethodid(Integer paymethodid) {
        this.paymethodid = paymethodid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer contractid) {
        this.contractid = contractid;
    }
}