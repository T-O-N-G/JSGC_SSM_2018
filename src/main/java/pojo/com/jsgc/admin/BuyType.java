package pojo.com.jsgc.admin;

public class BuyType {
    private Integer buyTypeId;

    private String buytypeinfo;

    private Integer versionId;

    public Integer getBuyTypeId() {
        return buyTypeId;
    }

    public void setBuyTypeId(Integer buyTypeId) {
        this.buyTypeId = buyTypeId;
    }

    public String getBuytypeinfo() {
        return buytypeinfo;
    }

    public void setBuytypeinfo(String buytypeinfo) {
        this.buytypeinfo = buytypeinfo == null ? null : buytypeinfo.trim();
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
}