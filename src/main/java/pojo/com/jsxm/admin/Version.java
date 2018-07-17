package pojo.com.jsxm.admin;

import java.util.Date;

public class Version {
    private Integer verisionid;

    private Date versiondate;

    private String versionbuildnum;

    public Integer getVerisionid() {
        return verisionid;
    }

    public void setVerisionid(Integer verisionid) {
        this.verisionid = verisionid;
    }

    public Date getVersiondate() {
        return versiondate;
    }

    public void setVersiondate(Date versiondate) {
        this.versiondate = versiondate;
    }

    public String getVersionbuildnum() {
        return versionbuildnum;
    }

    public void setVersionbuildnum(String versionbuildnum) {
        this.versionbuildnum = versionbuildnum == null ? null : versionbuildnum.trim();
    }
}