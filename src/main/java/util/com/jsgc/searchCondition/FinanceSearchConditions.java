package util.com.jsgc.searchCondition;

import java.util.Date;

public class FinanceSearchConditions {
    String order;//解析一下
    String realOrder;
    String descOrNot;
    private String financeSerials;
    private String projectSerial;
    private String projectName;//模糊匹配
    private String contractSerial;
    private String contractName;//模糊匹配
    private String financeDate;
    private int financePaid;
    private int financeMoneyMin;
    private int financeMoneyMax;
    private String financeBorrowerID;//传的是部门id
    private String financeLenderID;//传的是部门id
    private String payMethodID;//传的是部门id
    private String financeBuyMethodID;//传的是部门id
    private String fianceOrgID;//传的是部门id
    private String financeTypeID;//传的是部门id
    //lzq
    private int financeStatus;
    public int getFinanceStatus() {
        return financeStatus;
    }
    public void setFinanceStatus(int financeStatus) {
        this.financeStatus = financeStatus;
    }

    //lzq
    //private int start;
    private int page;
    private int limit;

    @Override
    public String toString() {
        return "ProjectSearchConditions{" +
                "order='" + order + '\'' +
                ", realOrder='" + realOrder + '\'' +
                ", descOrNot='" + descOrNot + '\'' +
                ", financeSerials='" + financeSerials + '\'' +
                ", projectSerial='" + projectSerial + '\'' +
                ", projectName='" + projectName + '\'' +
                ", contractSerial='" + contractSerial + '\'' +
                ", contractName='" + contractName + '\'' +
                ", financeDate='" + financeDate + '\'' +
                ", financeStatus='" + financePaid + '\'' +
                ", financeMoneyMin=" + financeMoneyMin +
                ", financeMoneyMax=" + financeMoneyMax +
                ", financeBorrowerID=" + financeBorrowerID +
                ", financeLenderID=" + financeLenderID +
                ", payMethodID=" + payMethodID +
                ", financeBuyMethodID=" + financeBuyMethodID +
                ", fianceOrgID=" + fianceOrgID +
                ", financeTypeID=" + financeTypeID +
                ", limit=" + limit +
                '}';
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
                    this.realOrder="financeSerial";
                    break;
                case 1:
                    this.realOrder="financeDate";
                    break;
                case 2:
                    this.realOrder="projectName";
                    break;
                case 3:
                    this.realOrder="contractName";
                    break;
                case 4:
                    this.realOrder="financeMoney";
                    break;
                case 5:
                    this.realOrder="financeStatus";
                    break;
                case 6:
                    this.realOrder="financeName";
                    break;
                case 7:
                    this.realOrder="financeBorrowerID";
                    break;
                case 8:
                    this.realOrder="financeLenderID";
                    break;
                case 9:
                    this.realOrder="payMethodID";
                    break;
                case 10:
                    this.realOrder="financeBuyMethodID";
                    break;
                case 11:
                    this.realOrder="financeBuyOrgID";
                    break;
                case 12:
                    this.realOrder="financeTypeID";
                    break;
                default:
                    throw new RuntimeException("列号非法");
            }
        }
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

    public String getFinanceSerials() {
        return financeSerials;
    }

    public void setFinanceSerials(String financeSerials) {
        this.financeSerials = financeSerials;
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

    public String getFinanceDate() {
        return financeDate;
    }

    public void setFinanceDate(String financeDate) {
        this.financeDate = financeDate;
    }

    public int getFinancePaid() {
        return financePaid;
    }

    public void setFinancePaid(int financePaid) {
        this.financePaid = financePaid;
    }

    public int getFinanceMoneyMin() {
        return financeMoneyMin;
    }

    public void setFinanceMoneyMin(int financeMoneyMin) {
        this.financeMoneyMin = financeMoneyMin;
    }

    public int getFinanceMoneyMax() {
        return financeMoneyMax;
    }

    public void setFinanceMoneyMax(int financeMoneyMax) {
        this.financeMoneyMax = financeMoneyMax;
    }

    public String getFinanceBorrowerID() {
        return financeBorrowerID;
    }

    public void setFinanceBorrowerID(String financeBorrowerID) {
        this.financeBorrowerID = financeBorrowerID;
    }

    public String getFinanceLenderID() {
        return financeLenderID;
    }

    public void setFinanceLenderID(String financeLenderID) {
        this.financeLenderID = financeLenderID;
    }

    public String getPayMethodID() {
        return payMethodID;
    }

    public void setPayMethodID(String payMethodID) {
        this.payMethodID = payMethodID;
    }

    public String getFinanceBuyMethodID() {
        return financeBuyMethodID;
    }

    public void setFinanceBuyMethodID(String financeBuyMethodID) {
        this.financeBuyMethodID = financeBuyMethodID;
    }

    public String getFianceOrgID() {
        return fianceOrgID;
    }

    public void setFianceOrgID(String fianceOrgID) {
        this.fianceOrgID = fianceOrgID;
    }

    public String getFinanceTypeID() {
        return financeTypeID;
    }

    public void setFinanceTypeID(String financeTypeID) {
        this.financeTypeID = financeTypeID;
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
}
