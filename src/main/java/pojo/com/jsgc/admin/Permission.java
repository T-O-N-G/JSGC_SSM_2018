package pojo.com.jsgc.admin;

public class Permission {
    private Integer permissionid;

    private String url;

    private Integer level;

    private String permissioncomment;

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPermissioncomment() {
        return permissioncomment;
    }

    public void setPermissioncomment(String permissioncomment) {
        this.permissioncomment = permissioncomment == null ? null : permissioncomment.trim();
    }
}