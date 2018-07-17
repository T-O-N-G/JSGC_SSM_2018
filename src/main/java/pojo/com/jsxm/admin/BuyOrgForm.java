package pojo.com.jsxm.admin;

public class BuyOrgForm {
    private Integer buyorgformid;

    private String buyorgforminfo;

    private Integer versionid;

    public Integer getBuyorgformid() {
        return buyorgformid;
    }

    public void setBuyorgformid(Integer buyorgformid) {
        this.buyorgformid = buyorgformid;
    }

    public String getBuyorgforminfo() {
        return buyorgforminfo;
    }

    public void setBuyorgforminfo(String buyorgforminfo) {
        this.buyorgforminfo = buyorgforminfo == null ? null : buyorgforminfo.trim();
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }
}