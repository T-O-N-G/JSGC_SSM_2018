package pojo.com.jsgc.admin;

public class Accountant {
    private Integer accountantId;

    private String accountantSerial;

    private String accountantName;

    private Integer accountantType;

    private Integer versionId;

    public Integer getaccountantId() {
        return accountantId;
    }

    public void setaccountantId(Integer accountantId) {
        this.accountantId = accountantId;
    }

    public String getaccountantSerial() {
        return accountantSerial;
    }

    public void setaccountantSerial(String accountantSerial) {
        this.accountantSerial = accountantSerial == null ? null : accountantSerial.trim();
    }

    public String getaccountantName() {
        return accountantName;
    }

    public void setaccountantName(String accountantName) {
        this.accountantName = accountantName == null ? null : accountantName.trim();
    }

    public Integer getaccountantType() {
        return accountantType;
    }

    public void setaccountantType(Integer accountantType) {
        this.accountantType = accountantType;
    }

    public Integer getversionId() {
        return versionId;
    }

    public void setversionId(Integer versionId) {
        this.versionId = versionId;
    }
}