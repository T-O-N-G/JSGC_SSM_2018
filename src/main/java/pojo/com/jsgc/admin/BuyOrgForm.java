package pojo.com.jsgc.admin;

public class BuyOrgForm {
    private Integer buyOrgFormId;

    private String buyOrgFormInfo;

    private Integer versionId;

    public Integer getBuyOrgFormId() {
        return buyOrgFormId;
    }

    public void setBuyOrgFormId(Integer buyOrgFormId) {
        this.buyOrgFormId = buyOrgFormId;
    }

    public String getBuyOrgFormInfo() {
        return buyOrgFormInfo;
    }

    public void setBuyOrgFormInfo(String buyOrgFormInfo) {
        this.buyOrgFormInfo = buyOrgFormInfo == null ? null : buyOrgFormInfo.trim();
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
}