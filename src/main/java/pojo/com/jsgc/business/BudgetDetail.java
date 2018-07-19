package pojo.com.jsgc.business;

public class BudgetDetail {
    private Integer budgetId;

    private String budgetSerial;

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

    public String getBudgetSerial() {
        return budgetSerial;
    }

    public void setBudgetSerial(String budgetSerial) {
        this.budgetSerial = budgetSerial;
    }

    public Integer getProjectBudgetSum() {
        return projectBudgetSum;
    }

    public void setProjectBudgetSum(Integer projectBudgetSum) {
        this.projectBudgetSum = projectBudgetSum;
    }

    public Integer getProjectContractsSum() {
        return projectContractsSum;
    }

    public void setProjectContractsSum(Integer projectContractsSum) {
        this.projectContractsSum = projectContractsSum;
    }

    public Integer getProjectContractsPayed() {
        return projectContractsPayed;
    }

    public void setProjectContractsPayed(Integer projectContractsPayed) {
        this.projectContractsPayed = projectContractsPayed;
    }

    public Integer getProjectContractsNotPayed() {
        return projectContractsNotPayed;
    }

    public void setProjectContractsNotPayed(Integer projectContractsNotPayed) {
        this.projectContractsNotPayed = projectContractsNotPayed;
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