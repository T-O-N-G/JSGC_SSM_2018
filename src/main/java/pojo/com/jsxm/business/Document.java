package pojo.com.jsxm.business;

import java.util.Date;

public class Document {
    private Integer documentid;

    private String documentserial;

    private String documentname;

    private Date documentuploadtime;

    private String documentowner;

    private String documentcomment;

    private String documenturl;

    private Integer documenttype;

    private Integer documentdelete;

    private Integer projectid;

    private Integer contractid;

    public Integer getDocumentid() {
        return documentid;
    }

    public void setDocumentid(Integer documentid) {
        this.documentid = documentid;
    }

    public String getDocumentserial() {
        return documentserial;
    }

    public void setDocumentserial(String documentserial) {
        this.documentserial = documentserial == null ? null : documentserial.trim();
    }

    public String getDocumentname() {
        return documentname;
    }

    public void setDocumentname(String documentname) {
        this.documentname = documentname == null ? null : documentname.trim();
    }

    public Date getDocumentuploadtime() {
        return documentuploadtime;
    }

    public void setDocumentuploadtime(Date documentuploadtime) {
        this.documentuploadtime = documentuploadtime;
    }

    public String getDocumentowner() {
        return documentowner;
    }

    public void setDocumentowner(String documentowner) {
        this.documentowner = documentowner == null ? null : documentowner.trim();
    }

    public String getDocumentcomment() {
        return documentcomment;
    }

    public void setDocumentcomment(String documentcomment) {
        this.documentcomment = documentcomment == null ? null : documentcomment.trim();
    }

    public String getDocumenturl() {
        return documenturl;
    }

    public void setDocumenturl(String documenturl) {
        this.documenturl = documenturl == null ? null : documenturl.trim();
    }

    public Integer getDocumenttype() {
        return documenttype;
    }

    public void setDocumenttype(Integer documenttype) {
        this.documenttype = documenttype;
    }

    public Integer getDocumentdelete() {
        return documentdelete;
    }

    public void setDocumentdelete(Integer documentdelete) {
        this.documentdelete = documentdelete;
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