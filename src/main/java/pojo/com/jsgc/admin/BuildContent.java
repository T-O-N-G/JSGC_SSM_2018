package pojo.com.jsgc.admin;

public class BuildContent {
    private Integer buildContentId;

    private Integer versionId;

    private String buildInfo;

    public Integer getBuildContentId() {
        return buildContentId;
    }

    public void setBuildContentId(Integer buildContentId) {
        this.buildContentId = buildContentId;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

    public String getBuildInfo() {
        return buildInfo;
    }

    public void setBuildInfo(String buildInfo) {
        this.buildInfo = buildInfo == null ? null : buildInfo.trim();
    }
}