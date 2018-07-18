package pojo.com.jsgc.admin;

public class PayMethod {
    private Integer payMethodId;

    private String payMethodInfo;

    private Integer versionId;

    public Integer getPayMethodId() {
        return payMethodId;
    }

    public void setPayMethodId(Integer payMethodId) {
        this.payMethodId = payMethodId;
    }

    public String getPayMethodInfo() {
        return payMethodInfo;
    }

    public void setPayMethodInfo(String payMethodInfo) {
        this.payMethodInfo = payMethodInfo == null ? null : payMethodInfo.trim();
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
}