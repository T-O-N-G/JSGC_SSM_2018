package pojo.com.jsgc.admin;

public class Verify {
    String applyReason;
    int verifyID;
    int projectID;
    int applyMoney;
    int status;
    String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public int getVerifyID() {
        return verifyID;
    }

    public void setVerifyID(int verifyID) {
        this.verifyID = verifyID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public int getApplyMoney() {
        return applyMoney;
    }

    public void setApplyMoney(int applyMoney) {
        this.applyMoney = applyMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
