package com.whx.elec8.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ElecSubengineeringPlan {
    private String subengineid;

    private String projplanid;

    private String engineplanid;

    private String subenginename;

    private BigDecimal unitprice;

    private Integer quality;

    private BigDecimal planinvest;

    private String comment;

    private String isdelete;

    private String createempid;

    private Date createdate;

    private String lastempid;

    private Date lastdate;

    public String getSubengineid() {
        return subengineid;
    }

    public void setSubengineid(String subengineid) {
        this.subengineid = subengineid == null ? null : subengineid.trim();
    }

    public String getProjplanid() {
        return projplanid;
    }

    public void setProjplanid(String projplanid) {
        this.projplanid = projplanid == null ? null : projplanid.trim();
    }

    public String getEngineplanid() {
        return engineplanid;
    }

    public void setEngineplanid(String engineplanid) {
        this.engineplanid = engineplanid == null ? null : engineplanid.trim();
    }

    public String getSubenginename() {
        return subenginename;
    }

    public void setSubenginename(String subenginename) {
        this.subenginename = subenginename == null ? null : subenginename.trim();
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public BigDecimal getPlaninvest() {
        return planinvest;
    }

    public void setPlaninvest(BigDecimal planinvest) {
        this.planinvest = planinvest;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

    public String getCreateempid() {
        return createempid;
    }

    public void setCreateempid(String createempid) {
        this.createempid = createempid == null ? null : createempid.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getLastempid() {
        return lastempid;
    }

    public void setLastempid(String lastempid) {
        this.lastempid = lastempid == null ? null : lastempid.trim();
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }
}