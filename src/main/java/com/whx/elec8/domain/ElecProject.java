package com.whx.elec8.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ElecProject {
    private String projid;

    private String jctid;

    private String layprojid;

    private String projname;

    private String projstate;

    private String projtype;

    private BigDecimal planinvest;

    private String maincontent;

    private Date builddate;

    private String isyanshou;

    private String cycle;

    private String comment;

    private String isdelete;

    private String createempid;

    private Date createdate;

    private String lastempid;

    private Date lastdate;

    private Date yanshoudate;

    private String projsize;

    public String getProjid() {
        return projid;
    }

    public void setProjid(String projid) {
        this.projid = projid == null ? null : projid.trim();
    }

    public String getJctid() {
        return jctid;
    }

    public void setJctid(String jctid) {
        this.jctid = jctid == null ? null : jctid.trim();
    }

    public String getLayprojid() {
        return layprojid;
    }

    public void setLayprojid(String layprojid) {
        this.layprojid = layprojid == null ? null : layprojid.trim();
    }

    public String getProjname() {
        return projname;
    }

    public void setProjname(String projname) {
        this.projname = projname == null ? null : projname.trim();
    }

    public String getProjstate() {
        return projstate;
    }

    public void setProjstate(String projstate) {
        this.projstate = projstate == null ? null : projstate.trim();
    }

    public String getProjtype() {
        return projtype;
    }

    public void setProjtype(String projtype) {
        this.projtype = projtype == null ? null : projtype.trim();
    }

    public BigDecimal getPlaninvest() {
        return planinvest;
    }

    public void setPlaninvest(BigDecimal planinvest) {
        this.planinvest = planinvest;
    }

    public String getMaincontent() {
        return maincontent;
    }

    public void setMaincontent(String maincontent) {
        this.maincontent = maincontent == null ? null : maincontent.trim();
    }

    public Date getBuilddate() {
        return builddate;
    }

    public void setBuilddate(Date builddate) {
        this.builddate = builddate;
    }

    public String getIsyanshou() {
        return isyanshou;
    }

    public void setIsyanshou(String isyanshou) {
        this.isyanshou = isyanshou == null ? null : isyanshou.trim();
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle == null ? null : cycle.trim();
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

    public Date getYanshoudate() {
        return yanshoudate;
    }

    public void setYanshoudate(Date yanshoudate) {
        this.yanshoudate = yanshoudate;
    }

    public String getProjsize() {
        return projsize;
    }

    public void setProjsize(String projsize) {
        this.projsize = projsize == null ? null : projsize.trim();
    }
}