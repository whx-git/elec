package com.whx.elec8.domain;

import java.util.Date;

public class ElecStationbug {
    private Integer bugid;

    private String stationid;

    private String jctid;

    private String sbmonth;

    private String bugtype;

    private String occurdate;

    private String launchername;

    private String bugdescribe;

    private String resolvedate;

    private String resolvemethod;

    private String bugreason;

    private String comment;

    private String isdelete;

    private String createempid;

    private Date createdate;

    private String lastempid;

    private Date lastdate;

    public Integer getBugid() {
        return bugid;
    }

    public void setBugid(Integer bugid) {
        this.bugid = bugid;
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid == null ? null : stationid.trim();
    }

    public String getJctid() {
        return jctid;
    }

    public void setJctid(String jctid) {
        this.jctid = jctid == null ? null : jctid.trim();
    }

    public String getSbmonth() {
        return sbmonth;
    }

    public void setSbmonth(String sbmonth) {
        this.sbmonth = sbmonth == null ? null : sbmonth.trim();
    }

    public String getBugtype() {
        return bugtype;
    }

    public void setBugtype(String bugtype) {
        this.bugtype = bugtype == null ? null : bugtype.trim();
    }

    public String getOccurdate() {
        return occurdate;
    }

    public void setOccurdate(String occurdate) {
        this.occurdate = occurdate == null ? null : occurdate.trim();
    }

    public String getLaunchername() {
        return launchername;
    }

    public void setLaunchername(String launchername) {
        this.launchername = launchername == null ? null : launchername.trim();
    }

    public String getBugdescribe() {
        return bugdescribe;
    }

    public void setBugdescribe(String bugdescribe) {
        this.bugdescribe = bugdescribe == null ? null : bugdescribe.trim();
    }

    public String getResolvedate() {
        return resolvedate;
    }

    public void setResolvedate(String resolvedate) {
        this.resolvedate = resolvedate == null ? null : resolvedate.trim();
    }

    public String getResolvemethod() {
        return resolvemethod;
    }

    public void setResolvemethod(String resolvemethod) {
        this.resolvemethod = resolvemethod == null ? null : resolvemethod.trim();
    }

    public String getBugreason() {
        return bugreason;
    }

    public void setBugreason(String bugreason) {
        this.bugreason = bugreason == null ? null : bugreason.trim();
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