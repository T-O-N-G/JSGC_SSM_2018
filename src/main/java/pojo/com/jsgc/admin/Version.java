package pojo.com.jsgc.admin;

import java.util.Date;

public class Version {
    private Integer verisionId;

    private Date versionDate;

    private String versionBuildNum;

    public Integer getVerisionId() {
        return verisionId;
    }

    public void setVerisionId(Integer verisionId) {
        this.verisionId = verisionId;
    }

    public Date getVersionDate() {
        return versionDate;
    }

    public void setVersionDate(Date versionDate) {
        this.versionDate = versionDate;
    }

    public String getVersionBuildNum() {
        return versionBuildNum;
    }

    public void setVersionBuildNum(String versionBuildNum) {
        this.versionBuildNum = versionBuildNum;
    }
}