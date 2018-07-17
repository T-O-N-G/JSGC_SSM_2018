package pojo.com.jsxm.admin;

public class Accountant {
    private Integer accountantid;

    private String accountantserial;

    private String accountantname;

    private Integer accountanttype;

    private Integer versionid;

    public Integer getAccountantid() {
        return accountantid;
    }

    public void setAccountantid(Integer accountantid) {
        this.accountantid = accountantid;
    }

    public String getAccountantserial() {
        return accountantserial;
    }

    public void setAccountantserial(String accountantserial) {
        this.accountantserial = accountantserial == null ? null : accountantserial.trim();
    }

    public String getAccountantname() {
        return accountantname;
    }

    public void setAccountantname(String accountantname) {
        this.accountantname = accountantname == null ? null : accountantname.trim();
    }

    public Integer getAccountanttype() {
        return accountanttype;
    }

    public void setAccountanttype(Integer accountanttype) {
        this.accountanttype = accountanttype;
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }
}