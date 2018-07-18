package pojo.com.jsgc.admin;

public class BuyOrgForm {
    private Integer buyOrgFormId;

    private String buyorgforminfo;

    private Integer versionid;

    public Integer getBuyOrgFormId() {
        return buyOrgFormId;
    }

    public void setBuyOrgFormId(Integer buyOrgFormId) {
        this.buyOrgFormId = buyOrgFormId;
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