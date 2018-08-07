package util.com.jsgc.searchCondition;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContractSearchConditions {
    String order;//解析一下
    String realOrder;
    String descOrNot;
    String contractSerial;
    String contractName;//模糊匹配
    String contractSignedTime;//解析一下
    String contractTimeMin;
    String contractTimeMax;
    String projectSerial;
    String projectName;
    String buildContentId;
    private int start;
    private int page;
    private int limit;
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

    @Override
    public String toString() {
        return "ContractSearchConditions{" +
                "order='" + order + '\'' +
                ", realOrder='" + realOrder + '\'' +
                ", descOrNot='" + descOrNot + '\'' +
                ", contractSerial='" + contractSerial + '\'' +
                ", contractName='" + contractName + '\'' +
                ", contractSignedTime='" + contractSignedTime + '\'' +
                ", contractTimeMin='" + contractTimeMin + '\'' +
                ", contractTimeMax='" + contractTimeMax + '\'' +
                ", projectSerial='" + projectSerial + '\'' +
                ", projectName='" + projectName + '\'' +
                ", buildContentId='" + buildContentId + '\'' +
                ", start=" + start +
                ", page=" + page +
                ", limit=" + limit +
                ", userLevel='" + userLevel + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }

    public String getBuildContentId() {
        return buildContentId;
    }

    public void setBuildContentId(String buildContentId) {
        this.buildContentId = buildContentId;
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

    public String getContractSerial() {
        return contractSerial;
    }

    public void setContractSerial(String contractSerial) {
        this.contractSerial = contractSerial;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractSignedTime() {
        return contractSignedTime;
    }

    public void setContractSignedTime(String contractSignedTime) {
        this.contractSignedTime = contractSignedTime;
    }

    public String getContractTimeMin() {
        return contractTimeMin;
    }

    public void setContractTimeMin(String contractTimeMin) {
        this.contractTimeMin = contractTimeMin;
    }

    public String getContractTimeMax() {
        return contractTimeMax;
    }

    public void setContractTimeMax(String contractTimeMax) {
        this.contractTimeMax = contractTimeMax;
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
    public ContractSearchConditions(){

    }


    public void parseDateRange() throws ParseException {
        if(this.contractSignedTime!=null&&!this.contractSignedTime.equals("")){
            this.contractTimeMin= this.contractSignedTime.substring(0,10);
            this.contractTimeMax=this.contractSignedTime.substring(13,23);
        }
    }

    public void parseOrder(){
        if(this.order!=null&&!this.order.equals("[]")){
            String[]ss=this.order.split(",");
            String []former= ss[0].split(":");
            String []later=ss[1].split(":");
            int column=Integer.parseInt(former[1]);
            this.descOrNot=later[1].substring(1,later[1].length()-3);
            switch (column){
                case 0:
                    this.realOrder="contractSerial";
                    break;
                case 1:
                    this.realOrder="contractName";
                    break;
                case 2:
                    this.realOrder="contractPartner";
                    break;
                case 3:
                    this.realOrder="contractSignedTime";
                    break;
                case 4:
                    this.realOrder="contractMoney";
                    break;
                case 5:
                    this.realOrder="projectName";
                    break;
                default:
                    throw new RuntimeException("列号非法");
            }
        }
    }
}
