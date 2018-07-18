package pojo.com.jsgc.business;

import java.util.Date;

public class Asset {
    private Integer assetId;

    private String assetSerial;

    private String assetName;

    private String assetSpec;

    private String assetModel;

    private Integer assetAmount;

    private Integer assetMoney;

    private Date assetDate;

    private String assetOwner;

    private String assetComment;

    private Integer assetDelete;

    private Integer assetStatus;

    private Integer projectId;

    private Integer assetdepId;

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getAssetSerial() {
        return assetSerial;
    }

    public void setAssetSerial(String assetSerial) {
        this.assetSerial = assetSerial == null ? null : assetSerial.trim();
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName == null ? null : assetName.trim();
    }

    public String getAssetSpec() {
        return assetSpec;
    }

    public void setAssetSpec(String assetSpec) {
        this.assetSpec = assetSpec == null ? null : assetSpec.trim();
    }

    public String getAssetModel() {
        return assetModel;
    }

    public void setAssetModel(String assetModel) {
        this.assetModel = assetModel == null ? null : assetModel.trim();
    }

    public Integer getAssetAmount() {
        return assetAmount;
    }

    public void setAssetAmount(Integer assetAmount) {
        this.assetAmount = assetAmount;
    }

    public Integer getAssetMoney() {
        return assetMoney;
    }

    public void setAssetMoney(Integer assetMoney) {
        this.assetMoney = assetMoney;
    }

    public Date getAssetDate() {
        return assetDate;
    }

    public void setAssetDate(Date assetDate) {
        this.assetDate = assetDate;
    }

    public String getAssetOwner() {
        return assetOwner;
    }

    public void setAssetOwner(String assetOwner) {
        this.assetOwner = assetOwner == null ? null : assetOwner.trim();
    }

    public String getAssetComment() {
        return assetComment;
    }

    public void setAssetComment(String assetComment) {
        this.assetComment = assetComment == null ? null : assetComment.trim();
    }

    public Integer getAssetDelete() {
        return assetDelete;
    }

    public void setAssetDelete(Integer assetDelete) {
        this.assetDelete = assetDelete;
    }

    public Integer getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(Integer assetStatus) {
        this.assetStatus = assetStatus;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getAssetdepId() {
        return assetdepId;
    }

    public void setAssetdepId(Integer assetdepId) {
        this.assetdepId = assetdepId;
    }
}