package pojo.com.jsgc.admin;

public class Accountant {
    private String accountantId;

    private String accountantName;

    private Integer accountantType;

    private Integer versionId;

    public String getAccountantId() {
        return accountantId;
    }

    public void setAccountantId(String accountantId) {
        this.accountantId = accountantId;
    }

    public String getAccountantName() {
        return accountantName;
    }

    public void setAccountantName(String accountantName) {
        this.accountantName = accountantName;
    }

    public Integer getAccountantType() {
        return accountantType;
    }

    public void setAccountantType(Integer accountantType) {
        this.accountantType = accountantType;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
}