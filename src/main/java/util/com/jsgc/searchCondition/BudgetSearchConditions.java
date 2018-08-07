package util.com.jsgc.searchCondition;

import java.text.ParseException;

public class BudgetSearchConditions {

    String order;//解析一下
    String realOrder;
    String descOrNot;
    private int start;
    private int page;
    private int limit;
    private String projectSerial;
    private String projectName;
    private String projectStartTime;
    private String projectTimeMin;
    private String projectTimeMax;
    public void parseDateRange() throws ParseException {
        if(this.projectStartTime!=null&&!this.projectStartTime.equals("")){
            this.projectTimeMin= this.projectStartTime.substring(0,10);
            this.projectTimeMax=this.projectStartTime.substring(13,23);
        }
    }
    //  lzq,可访问范围
    private String userLevel;
    private String userID;

    public void parseUserID(){
        if(!userLevel.equals("2")) this.userID=null;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getProjectTimeMin() {
        return projectTimeMin;
    }

    public void setProjectTimeMin(String projectTimeMin) {
        this.projectTimeMin = projectTimeMin;
    }

    public String getProjectTimeMax() {
        return projectTimeMax;
    }

    public void setProjectTimeMax(String projectTimeMax) {
        this.projectTimeMax = projectTimeMax;
    }

    public String getProjectStartTime() {
        return projectStartTime;
    }

    public void setProjectStartTime(String projectStartTime) {
        this.projectStartTime = projectStartTime;
    }

    private String allContractPayed;

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

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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

    public String getAllContractPayed() {
        return allContractPayed;
    }

    public void setAllContractPayed(String allContractPayed) {
        this.allContractPayed = allContractPayed;
    }

    public void parseOrder(){
        if(this.order!=null&&!this.order.equals("[]")){
            String[]ss=this.order.split(",");
            String []former= ss[0].split(":");
            String []later=ss[1].split(":");
            int column=Integer.parseInt(former[1]);
            this.descOrNot=later[1].substring(1,later[1].length()-3);
            switch (column){
                case 4:
                    this.realOrder="assetAmount";
                    break;
                case 5:
                    this.realOrder="assetMoney";
                    break;
            }
        }
    }
}
