package pojo.com.jsgc.business;

public class BudgetDetail {
    private Integer budgetId;

    private String budgetserial;

    private Integer projectBudgetSum;

    private Integer projectContractsSum;

    private Integer projectContractsPayed;

    private Integer projectContractsNotPayed;

    private Integer projectBudgetLeft;

    private Integer projectId;

    public Integer getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Integer budgetId) {
        this.budgetId = budgetId;
    }

    public String getBudgetserial() {
        return budgetserial;
    }

    public void setBudgetserial(String budgetserial) {
        this.budgetserial = budgetserial == null ? null : budgetserial.trim();
    }

    public Integer getProjectBudgetSum() {
        return projectBudgetSum;
    }

    public void setProjectBudgetSum(Integer projectBudgetSum) {
        this.projectBudgetSum = projectBudgetSum;
    }

    public Integer getProjectcontractssum() {
        return projectContractsSum;
    }

    public void setProjectcontractssum(Integer projectcontractssum) {
        this.projectContractsSum = projectcontractssum;
    }

    public Integer getProjectContractsPayed() {
        return projectContractsPayed;
    }

    public void setProjectContractsPayed(Integer projectContractsPayed) {
        this.projectContractsPayed = projectContractsPayed;
    }

    public Integer getProjectcontractsnotpayed() {
        return projectContractsNotPayed;
    }

    public void setProjectcontractsnotpayed(Integer projectcontractsnotpayed) {
        this.projectContractsNotPayed = projectcontractsnotpayed;
    }

    public Integer getProjectBudgetLeft() {
        return projectBudgetLeft;
    }

    public void setProjectBudgetLeft(Integer projectBudgetLeft) {
        this.projectBudgetLeft = projectBudgetLeft;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
}