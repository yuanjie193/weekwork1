package com.youname.pojo;

import org.springframework.stereotype.Component;

@Component
public class Games {
    private Integer sid;
    private String sx;
    private String sxname;
    private String month;
    private String mname;
    private String xz;
    private String xzname;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSx() {
        return sx;
    }

    public void setSx(String sx) {
        this.sx = sx;
    }

    public String getSxname() {
        return sxname;
    }

    public void setSxname(String sxname) {
        this.sxname = sxname;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz;
    }

    public String getXzname() {
        return xzname;
    }

    public void setXzname(String xzname) {
        this.xzname = xzname;
    }

    @Override
    public String toString() {
        return "Games{" +
                "sid=" + sid +
                ", sx='" + sx + '\'' +
                ", sxname='" + sxname + '\'' +
                ", month='" + month + '\'' +
                ", mname='" + mname + '\'' +
                ", xz='" + xz + '\'' +
                ", xzname='" + xzname + '\'' +
                '}';
    }
}
