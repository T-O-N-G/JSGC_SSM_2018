package pojo.com.jsxm.admin;

public class BudgetReply {
    private Integer budgetreplyid;

    private String budgetreplyinfo;

    private Integer versionid;

    public Integer getBudgetreplyid() {
        return budgetreplyid;
    }

    public void setBudgetreplyid(Integer budgetreplyid) {
        this.budgetreplyid = budgetreplyid;
    }

    public String getBudgetreplyinfo() {
        return budgetreplyinfo;
    }

    public void setBudgetreplyinfo(String budgetreplyinfo) {
        this.budgetreplyinfo = budgetreplyinfo == null ? null : budgetreplyinfo.trim();
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }
}