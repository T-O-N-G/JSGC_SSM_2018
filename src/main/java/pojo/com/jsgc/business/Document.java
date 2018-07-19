package pojo.com.jsgc.business;

import java.util.Date;

public class Document {
    private Integer documentId;

    private String documentSerial;

    private String documentName;

    private Date documentUploadTime;

    private String documentOwner;

    private String documentComment;

    private String documentUrl;

    private Integer documentType;

    private Integer documentDelete;

    private Integer projectId;

    private Integer contractId;

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public String getDocumentSerial() {
        return documentSerial;
    }

    public void setDocumentSerial(String documentSerial) {
        this.documentSerial = documentSerial;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Date getDocumentUploadTime() {
        return documentUploadTime;
    }

    public void setDocumentUploadTime(Date documentUploadTime) {
        this.documentUploadTime = documentUploadTime;
    }

    public String getDocumentOwner() {
        return documentOwner;
    }

    public void setDocumentOwner(String documentOwner) {
        this.documentOwner = documentOwner;
    }

    public String getDocumentComment() {
        return documentComment;
    }

    public void setDocumentComment(String documentComment) {
        this.documentComment = documentComment;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public Integer getDocumentType() {
        return documentType;
    }

    public void setDocumentType(Integer documentType) {
        this.documentType = documentType;
    }

    public Integer getDocumentDelete() {
        return documentDelete;
    }

    public void setDocumentDelete(Integer documentDelete) {
        this.documentDelete = documentDelete;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }
}