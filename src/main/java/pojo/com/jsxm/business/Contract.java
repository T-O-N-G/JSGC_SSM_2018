package pojo.com.jsxm.business;

import java.util.Date;

public class Contract {
    private Integer contractid;

    private String contractserial;

    private String contractname;

    private String contractowner;

    private String contractpartner;

    private Date contractsignedtime;

    private Integer contractmoney;

    private String contractcontent;

    private String contractcomment;

    private Integer contractdelete;

    private Integer projectid;

    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer contractid) {
        this.contractid = contractid;
    }

    public String getContractserial() {
        return contractserial;
    }

    public void setContractserial(String contractserial) {
        this.contractserial = contractserial == null ? null : contractserial.trim();
    }

    public String getContractname() {
        return contractname;
    }

    public void setContractname(String contractname) {
        this.contractname = contractname == null ? null : contractname.trim();
    }

    public String getContractowner() {
        return contractowner;
    }

    public void setContractowner(String contractowner) {
        this.contractowner = contractowner == null ? null : contractowner.trim();
    }

    public String getContractpartner() {
        return contractpartner;
    }

    public void setContractpartner(String contractpartner) {
        this.contractpartner = contractpartner == null ? null : contractpartner.trim();
    }

    public Date getContractsignedtime() {
        return contractsignedtime;
    }

    public void setContractsignedtime(Date contractsignedtime) {
        this.contractsignedtime = contractsignedtime;
    }

    public Integer getContractmoney() {
        return contractmoney;
    }

    public void setContractmoney(Integer contractmoney) {
        this.contractmoney = contractmoney;
    }

    public String getContractcontent() {
        return contractcontent;
    }

    public void setContractcontent(String contractcontent) {
        this.contractcontent = contractcontent == null ? null : contractcontent.trim();
    }

    public String getContractcomment() {
        return contractcomment;
    }

    public void setContractcomment(String contractcomment) {
        this.contractcomment = contractcomment == null ? null : contractcomment.trim();
    }

    public Integer getContractdelete() {
        return contractdelete;
    }

    public void setContractdelete(Integer contractdelete) {
        this.contractdelete = contractdelete;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }
}