package pojo.com.jsgc.business;

import java.util.Date;
import java.util.List;

public class Project {
    private Integer projectid;

    private String projectserial;

    private String projectname;

    private Integer projectbudgetsum;

    private Date projectstarttime;

    private Date projectendtime;

    private Integer projectstatus;

    private String projectcomment;

    private Integer projectdelete;

    private Integer budgetid;

    private Integer projectchargerid;

    private List<Contract> contractList;

    private BudgetDetail budgetDetail;


    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getProjectserial() {
        return projectserial;
    }

    public void setProjectserial(String projectserial) {
        this.projectserial = projectserial == null ? null : projectserial.trim();
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname == null ? null : projectname.trim();
    }

    public Integer getProjectbudgetsum() {
        return projectbudgetsum;
    }

    public void setProjectbudgetsum(Integer projectbudgetsum) {
        this.projectbudgetsum = projectbudgetsum;
    }

    public Date getProjectstarttime() {
        return projectstarttime;
    }

    public void setProjectstarttime(Date projectstarttime) {
        this.projectstarttime = projectstarttime;
    }

    public Date getProjectendtime() {
        return projectendtime;
    }

    public void setProjectendtime(Date projectendtime) {
        this.projectendtime = projectendtime;
    }

    public Integer getProjectstatus() {
        return projectstatus;
    }

    public void setProjectstatus(Integer projectstatus) {
        this.projectstatus = projectstatus;
    }

    public String getProjectcomment() {
        return projectcomment;
    }

    public void setProjectcomment(String projectcomment) {
        this.projectcomment = projectcomment == null ? null : projectcomment.trim();
    }

    public Integer getProjectdelete() {
        return projectdelete;
    }

    public void setProjectdelete(Integer projectdelete) {
        this.projectdelete = projectdelete;
    }

    public Integer getBudgetid() {
        return budgetid;
    }

    public void setBudgetid(Integer budgetid) {
        this.budgetid = budgetid;
    }

    public Integer getProjectchargerid() {
        return projectchargerid;
    }

    public void setProjectchargerid(Integer projectchargerid) {
        this.projectchargerid = projectchargerid;
    }
}