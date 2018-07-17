package pojo.com.jsxm.admin;

public class User {
    private Integer userid;

    private String username;

    private String password;

    private String email;

    private Integer phone;

    private Integer permissionlevel;

    private Integer userdelete;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getPermissionlevel() {
        return permissionlevel;
    }

    public void setPermissionlevel(Integer permissionlevel) {
        this.permissionlevel = permissionlevel;
    }

    public Integer getUserdelete() {
        return userdelete;
    }

    public void setUserdelete(Integer userdelete) {
        this.userdelete = userdelete;
    }
}