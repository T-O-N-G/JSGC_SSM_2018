package pojo.com.jsxm.admin;

public class BudgetReply {
    private Integer budgetReplyId;

    private String budgetReplyInfo;

    private Integer versionId;

    public Integer getBudgetReplyId() {
        return budgetReplyId;
    }

    public void setBudgetReplyId(Integer budgetReplyId) {
        this.budgetReplyId = budgetReplyId;
    }

    public String getBudgetReplyInfo() {
        return budgetReplyInfo;
    }

    public void setBudgetReplyInfo(String budgetReplyInfo) {
        this.budgetReplyInfo = budgetReplyInfo == null ? null : budgetReplyInfo.trim();
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }
}