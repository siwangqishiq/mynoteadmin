package com.mynote.admin.model;

public class Version {
    public static final int STATUS_IDLE = 0;
    public static final int STATUS_USE = 1;
    public static final int STATUS_DELETE = -1;

    public static final int TYPE_IOS = 1;
    public static final int TYPE_ANDROID = 2;

    private int id;
    private int versionCode;
    private String versionName;
    private String url;
    private String descrption;
    private String extra;
    private int status;
    private int type;
    private long updateTime;
    private long createTime;


    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Version{" +
                "id=" + id +
                ", versionCode=" + versionCode +
                ", versionName='" + versionName + '\'' +
                ", url='" + url + '\'' +
                ", descrption='" + descrption + '\'' +
                ", extra='" + extra + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                '}';
    }
}//end class
