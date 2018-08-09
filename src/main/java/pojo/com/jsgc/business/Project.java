package pojo.com.jsgc.business;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import pojo.com.jsgc.admin.Department;
import pojo.com.jsgc.admin.User;

import java.util.Date;
@ExcelTarget("projectEntity")
public class Project {
    private Integer projectId;
    @Excel(name = "项目编号", width = 25)
    private String projectSerial;
    @Excel(name = "项目名称")
    private String projectName;
    @Excel(name = "项目预算")
    private Integer projectBudgetSum;
    @Excel(name="项目开始日期" ,databaseFormat = "yyyy-MM-dd", format = "yyyy/M/d")
    private Date projectStartTime;
    private Date projectEndTime;//
    private Integer projectStatus;//
    @Excel(name = "备注")
    private String projectComment;

    private Integer projectDelete;
    @Excel(name = "部门编号")
    private String projectDepartmentId;

    private Integer budgetId;//
    @Excel(name = "负责人编号")
    private Integer projectChargerId;

    private String username;
    //添加对象用于导出
    @ExcelEntity(id="departmentEntity")
    private Department projectDepartment;
    //添加对象用于导出
    @ExcelEntity(id="userEntity")
    private User projectCharger;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Department getProjectDepartment() {
        return projectDepartment;
    }

    public void setProjectDepartment(Department projectDepartment) {
        this.projectDepartment = projectDepartment;
    }

    public User getProjectCharger() {
        return projectCharger;
    }

    public void setProjectCharger(User projectCharger) {
        this.projectCharger = projectCharger;
    }

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
        this.projectSerial = projectSerial;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
        this.projectComment = projectComment;
    }

    public Integer getProjectDelete() {
        return projectDelete;
    }

    public void setProjectDelete(Integer projectDelete) {
        this.projectDelete = projectDelete;
    }

    public String getProjectDepartmentId() {
        return projectDepartmentId;
    }

    public void setProjectDepartmentId(String projectDepartmentId) {
        this.projectDepartmentId = projectDepartmentId;
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

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectSerial='" + projectSerial + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectBudgetSum=" + projectBudgetSum +
                ", projectStartTime=" + projectStartTime +
                ", projectEndTime=" + projectEndTime +
                ", projectStatus=" + projectStatus +
                ", projectComment='" + projectComment + '\'' +
                ", projectDelete=" + projectDelete +
                ", projectDepartmentId='" + projectDepartmentId + '\'' +
                ", budgetId=" + budgetId +
                ", projectChargerId=" + projectChargerId +
                ", projectDepartment=" + projectDepartment +
                ", projectCharger=" + projectCharger +
                '}';
    }
}