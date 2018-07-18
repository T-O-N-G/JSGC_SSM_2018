package pojo.com.jsxm.admin;

public class Accountant {
    private Integer accountantId;

    private String accountantSerial;

    private String accountantName;

    private Integer accountantType;

    private Integer versionId;

    public Integer getAccountantId() {
        return accountantId;
    }

    public void setAccountantId(Integer accountantId) {
        this.accountantId = accountantId;
    }

    public String getAccountantSerial() {
        return accountantSerial;
    }

    public void setAccountantSerial(String accountantSerial) {
        this.accountantSerial = accountantSerial == null ? null : accountantSerial.trim();
    }

    public String getAccountantName() {
        return accountantName;
    }

    public void setAccountantName(String accountantName) {
        this.accountantName = accountantName == null ? null : accountantName.trim();
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

    public void setVersionid(Integer versionId) {
        this.versionId = versionId;
    }
}