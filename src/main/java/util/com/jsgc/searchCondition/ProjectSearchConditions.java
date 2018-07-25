package util.com.jsgc.searchCondition;

public class ProjectSearchConditions {
    String order;//解析一下
    String realOrder;
    String descOrNot;
    private String projectSerial;
    private String projectName;//模糊匹配
    private String projectDepartment;//传的是部门id
    private String projectOwner;
    private int projectBudgetDown;
    private int projectBudgetUp;

    private int start;

    private int limit;

    @Override
    public String toString() {
        return "ProjectSearchConditions{" +
                "realOrder='" + realOrder + '\'' +
                ", descOrNot='" + descOrNot + '\'' +
                ", projectSerial='" + projectSerial + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectDepartment='" + projectDepartment + '\'' +
                ", projectOwner='" + projectOwner + '\'' +
                ", projectBudgetDown=" + projectBudgetDown +
                ", projectBudgetUp=" + projectBudgetUp +
                ", start=" + start +
                ", limit=" + limit +
                '}';
    }

    public void parseOrder(){
        if(this.order!=null){
            String[]ss=this.order.split(",");
            String []former= ss[0].split(":");
            String []later=ss[1].split(":");
            int column=Integer.parseInt(former[1]);
            this.descOrNot=later[1].substring(1,later[1].length()-3);
            switch (column){
                case 0:
                    this.realOrder="projectSerial";
                    break;
                case 1:
                    this.realOrder="projectName";
                    break;
                case 2:
                    this.realOrder="projectStartTime";
                    break;
                case 3:
                    this.realOrder="departmentName";
                    break;
                case 4:
                    this.realOrder="username";
                    break;
                case 5:
                    this.realOrder="projectBudgetSum";
                    break;
                default:
                    throw new RuntimeException("列号非法");
            }
        }
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getRealOrder() {
        return realOrder;
    }

    public void setRealOrder(String realOrder) {
        this.realOrder = realOrder;
    }

    public String getDescOrNot() {
        return descOrNot;
    }

    public void setDescOrNot(String descOrNot) {
        this.descOrNot = descOrNot;
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

    public String getProjectDepartment() {
        return projectDepartment;
    }

    public void setProjectDepartment(String projectDepartment) {
        this.projectDepartment = projectDepartment;
    }

    public String getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(String projectOwner) {
        this.projectOwner = projectOwner;
    }

    public int getProjectBudgetDown() {
        return projectBudgetDown;
    }

    public void setProjectBudgetDown(int projectBudgetDown) {
        this.projectBudgetDown = projectBudgetDown;
    }

    public int getProjectBudgetUp() {
        return projectBudgetUp;
    }

    public void setProjectBudgetUp(int projectBudgetUp) {
        this.projectBudgetUp = projectBudgetUp;
    }
}
