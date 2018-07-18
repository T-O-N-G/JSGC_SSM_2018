package pojo.com.jsgc.admin;

public class BuildContent {
    private Integer buildcontentid;

    private Integer versionid;

    private String buildinfo;

    public Integer getBuildcontentid() {
        return buildcontentid;
    }

    public void setBuildcontentid(Integer buildcontentid) {
        this.buildcontentid = buildcontentid;
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }

    public String getBuildinfo() {
        return buildinfo;
    }

    public void setBuildinfo(String buildinfo) {
        this.buildinfo = buildinfo == null ? null : buildinfo.trim();
    }
}