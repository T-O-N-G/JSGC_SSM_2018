package pojo.com.jsgc.admin;

public class PayMethod {
    private Integer paymethodid;

    private String paymethodinfo;

    private Integer versionid;

    public Integer getPaymethodid() {
        return paymethodid;
    }

    public void setPaymethodid(Integer paymethodid) {
        this.paymethodid = paymethodid;
    }

    public String getPaymethodinfo() {
        return paymethodinfo;
    }

    public void setPaymethodinfo(String paymethodinfo) {
        this.paymethodinfo = paymethodinfo == null ? null : paymethodinfo.trim();
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }
}