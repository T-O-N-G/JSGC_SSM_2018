package pojo.com.jsgc.business;

import java.util.Date;

public class Asset {
    private Integer assetid;

    private String assetserial;

    private String assetname;

    private String assetspec;

    private String assetmodel;

    private Integer assetamount;

    private Integer assetmoney;

    private Date assetdate;

    private String assetowner;

    private String assetcomment;

    private Integer assetdelete;

    private Integer assetstatus;

    private Integer projectid;

    private Integer assetdepid;

    public Integer getAssetid() {
        return assetid;
    }

    public void setAssetid(Integer assetid) {
        this.assetid = assetid;
    }

    public String getAssetserial() {
        return assetserial;
    }

    public void setAssetserial(String assetserial) {
        this.assetserial = assetserial == null ? null : assetserial.trim();
    }

    public String getAssetname() {
        return assetname;
    }

    public void setAssetname(String assetname) {
        this.assetname = assetname == null ? null : assetname.trim();
    }

    public String getAssetspec() {
        return assetspec;
    }

    public void setAssetspec(String assetspec) {
        this.assetspec = assetspec == null ? null : assetspec.trim();
    }

    public String getAssetmodel() {
        return assetmodel;
    }

    public void setAssetmodel(String assetmodel) {
        this.assetmodel = assetmodel == null ? null : assetmodel.trim();
    }

    public Integer getAssetamount() {
        return assetamount;
    }

    public void setAssetamount(Integer assetamount) {
        this.assetamount = assetamount;
    }

    public Integer getAssetmoney() {
        return assetmoney;
    }

    public void setAssetmoney(Integer assetmoney) {
        this.assetmoney = assetmoney;
    }

    public Date getAssetdate() {
        return assetdate;
    }

    public void setAssetdate(Date assetdate) {
        this.assetdate = assetdate;
    }

    public String getAssetowner() {
        return assetowner;
    }

    public void setAssetowner(String assetowner) {
        this.assetowner = assetowner == null ? null : assetowner.trim();
    }

    public String getAssetcomment() {
        return assetcomment;
    }

    public void setAssetcomment(String assetcomment) {
        this.assetcomment = assetcomment == null ? null : assetcomment.trim();
    }

    public Integer getAssetdelete() {
        return assetdelete;
    }

    public void setAssetdelete(Integer assetdelete) {
        this.assetdelete = assetdelete;
    }

    public Integer getAssetstatus() {
        return assetstatus;
    }

    public void setAssetstatus(Integer assetstatus) {
        this.assetstatus = assetstatus;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getAssetdepid() {
        return assetdepid;
    }

    public void setAssetdepid(Integer assetdepid) {
        this.assetdepid = assetdepid;
    }
}