package pojo.com.jsgc.admin;

public class BuyMethod {
    private Integer buymethodid;

    private String buymethodinfo;

    private Integer versionid;

    public Integer getBuymethodid() {
        return buymethodid;
    }

    public void setBuymethodid(Integer buymethodid) {
        this.buymethodid = buymethodid;
    }

    public String getBuymethodinfo() {
        return buymethodinfo;
    }

    public void setBuymethodinfo(String buymethodinfo) {
        this.buymethodinfo = buymethodinfo == null ? null : buymethodinfo.trim();
    }

    public Integer getVersionid() {
        return versionid;
    }

    public void setVersionid(Integer versionid) {
        this.versionid = versionid;
    }
}