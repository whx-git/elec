package com.whx.elec8.domain;

import java.util.Date;

public class ElecStation {
    private Integer stationid;

    private String jctid;

    private String stationcode;

    private String stationname;

    private String jcfrequency;

    private String producehome;

    private String contacttype;

    private Date usestartdate;

    private String comment;

    private String isdelete;

    private String createempid;

    private Date createdate;

    private String lastempid;

    private Date lastdate;

    private String stationtype;

    private String attributionground;

    private String period;

    public Integer getStationid() {
        return stationid;
    }

    public void setStationid(Integer stationid) {
        this.stationid = stationid;
    }

    public String getJctid() {
        return jctid;
    }

    public void setJctid(String jctid) {
        this.jctid = jctid == null ? null : jctid.trim();
    }

    public String getStationcode() {
        return stationcode;
    }

    public void setStationcode(String stationcode) {
        this.stationcode = stationcode == null ? null : stationcode.trim();
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname == null ? null : stationname.trim();
    }

    public String getJcfrequency() {
        return jcfrequency;
    }

    public void setJcfrequency(String jcfrequency) {
        this.jcfrequency = jcfrequency == null ? null : jcfrequency.trim();
    }

    public String getProducehome() {
        return producehome;
    }

    public void setProducehome(String producehome) {
        this.producehome = producehome == null ? null : producehome.trim();
    }

    public String getContacttype() {
        return contacttype;
    }

    public void setContacttype(String contacttype) {
        this.contacttype = contacttype == null ? null : contacttype.trim();
    }

    public Date getUsestartdate() {
        return usestartdate;
    }

    public void setUsestartdate(Date usestartdate) {
        this.usestartdate = usestartdate;
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

    public String getStationtype() {
        return stationtype;
    }

    public void setStationtype(String stationtype) {
        this.stationtype = stationtype == null ? null : stationtype.trim();
    }

    public String getAttributionground() {
        return attributionground;
    }

    public void setAttributionground(String attributionground) {
        this.attributionground = attributionground == null ? null : attributionground.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }
}