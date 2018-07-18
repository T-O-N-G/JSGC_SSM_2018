package pojo.com.jsgc.admin;

public class BuyMethod {
    private Integer buyMethodId;

    private String buyMethodInfo;

    private Integer versionId;

    public Integer getBuyMethodId() {
        return buyMethodId;
    }

    public void setBuyMethodId(Integer buyMethodId) {
        this.buyMethodId = buyMethodId;
    }

    public String getBuyMethodInfo() {
        return buyMethodInfo;
    }

    public void setBuyMethodInfo(String buyMethodInfo) {
        this.buyMethodInfo = buyMethodInfo == null ? null : buyMethodInfo.trim();
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
}