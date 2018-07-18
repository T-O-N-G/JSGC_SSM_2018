package pojo.com.jsgc.business;

import java.util.Date;
import java.util.List;

public class Project {
    private Integer projectId;

    private String projectSerial;

    private String projectName;

    private Integer projectBudgetSum;

    private Date projectStartTime;

    private Date projectEndTime;

    private Integer projectStatus;

    private String projectComment;

    private Integer projectDelete;

    private Integer budgetId;

    private Integer projectChargerId;
    private Integer projectDepartmentId;

    private List<Contract> contractList;

    private BudgetDetail budgetDetail;


    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectSerial() {
        return projectSerial;
    }

    public void setProjectSerial(String projectSerial) {
        this.projectSerial = projectSerial == null ? null : projectSerial.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Integer getProjectBudgetSum() {
        return projectBudgetSum;
    }

    public void setProjectBudgetSum(Integer projectBudgetSum) {
        this.projectBudgetSum = projectBudgetSum;
    }

    public Date getProjectStartTime() {
        return projectStartTime;
    }

    public void setProjectStartTime(Date projectStartTime) {
        this.projectStartTime = projectStartTime;
    }

    public Date getProjectEndTime() {
        return projectEndTime;
    }

    public void setProjectEndTime(Date projectEndTime) {
        this.projectEndTime = projectEndTime;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectComment() {
        return projectComment;
    }

    public void setProjectComment(String projectComment) {
        this.projectComment = projectComment == null ? null : projectComment.trim();
    }

    public Integer getProjectDelete() {
        return projectDelete;
    }

    public void setProjectDelete(Integer projectDelete) {
        this.projectDelete = projectDelete;
    }

    public Integer getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Integer budgetId) {
        this.budgetId = budgetId;
    }

    public Integer getProjectChargerId() {
        return projectChargerId;
    }

    public void setProjectChargerId(Integer projectChargerId) {
        this.projectChargerId = projectChargerId;
    }

    public Integer getProjectDepartmentId() {
        return projectDepartmentId;
    }

    public void setProjectDepartmentId(Integer projectDepartmentId) {
        this.projectDepartmentId = projectDepartmentId;
    }
}