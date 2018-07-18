package pojo.com.jsgc.admin;

public class Permission {
    private Integer permissionId;

    private String url;

    private Integer level;

    private String permissionComment;

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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

    public String getPermissionComment() {
        return permissionComment;
    }

    public void setPermissionComment(String permissionComment) {
        this.permissionComment = permissionComment == null ? null : permissionComment.trim();
    }
}