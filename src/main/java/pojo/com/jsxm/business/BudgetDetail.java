package pojo.com.jsxm.business;

public class BudgetDetail {
    private Integer budgetid;

    private String budgetserial;

    private Integer projectbudgetsum;

    private Integer projectcontractssum;

    private Integer projectcontractspayed;

    private Integer projectcontractsnotpayed;

    private Integer projectbudgetleft;

    private Integer projectid;

    public Integer getBudgetid() {
        return budgetid;
    }

    public void setBudgetid(Integer budgetid) {
        this.budgetid = budgetid;
    }

    public String getBudgetserial() {
        return budgetserial;
    }

    public void setBudgetserial(String budgetserial) {
        this.budgetserial = budgetserial == null ? null : budgetserial.trim();
    }

    public Integer getProjectbudgetsum() {
        return projectbudgetsum;
    }

    public void setProjectbudgetsum(Integer projectbudgetsum) {
        this.projectbudgetsum = projectbudgetsum;
    }

    public Integer getProjectcontractssum() {
        return projectcontractssum;
    }

    public void setProjectcontractssum(Integer projectcontractssum) {
        this.projectcontractssum = projectcontractssum;
    }

    public Integer getProjectcontractspayed() {
        return projectcontractspayed;
    }

    public void setProjectcontractspayed(Integer projectcontractspayed) {
        this.projectcontractspayed = projectcontractspayed;
    }

    public Integer getProjectcontractsnotpayed() {
        return projectcontractsnotpayed;
    }

    public void setProjectcontractsnotpayed(Integer projectcontractsnotpayed) {
        this.projectcontractsnotpayed = projectcontractsnotpayed;
    }

    public Integer getProjectbudgetleft() {
        return projectbudgetleft;
    }

    public void setProjectbudgetleft(Integer projectbudgetleft) {
        this.projectbudgetleft = projectbudgetleft;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }
}