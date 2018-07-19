package pojo.com.jsgc.admin;

public class BuyType {
    private Integer buyTypeId;

    private String buyTypeInfo;

    private Integer versionId;

    public Integer getBuyTypeId() {
        return buyTypeId;
    }

    public void setBuyTypeId(Integer buyTypeId) {
        this.buyTypeId = buyTypeId;
    }

    public String getBuyTypeInfo() {
        return buyTypeInfo;
    }

    public void setBuyTypeInfo(String buyTypeInfo) {
        this.buyTypeInfo = buyTypeInfo == null ? null : buyTypeInfo.trim();
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
}