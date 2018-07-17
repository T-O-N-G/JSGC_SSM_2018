package pojo.com.jsxm.admin;

public class BuyType {
    private Integer buytypeid;

    private String buytypeinfo;

    private Integer versionid;

    public Integer getBuytypeid() {
        return buytypeid;
    }

    public void setBuytypeid(Integer buytypeid) {
        this.buytypeid = buytypeid;
    }

    public String getBuytypeinfo() {
        return buytypeinfo;
    }

    public void setBuytypeinfo(String buytypeinfo) {
        this.buytypeinfo = buytypeinfo == null ? null : buytypeinfo.trim();
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }
}