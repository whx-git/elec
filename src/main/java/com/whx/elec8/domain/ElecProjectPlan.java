package com.whx.elec8.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ElecProjectPlan {
    private String projplanid;

    private String jctid;

    private String layprojid;

    private String projname;

    private String projstate;

    private String projtype;

    private Date declaredate;

    private BigDecimal planinvest;

    private String keyan;

    private String chushe;

    private BigDecimal keyaninvest;

    private BigDecimal chusheinvest;

    private String isdeclare;

    private String isapprove;

    private String gist;

    private String maincontent;

    private String comment;

    private String isdelete;

    private String createempid;

    private Date createdate;

    private String lastempid;

    private Date lastdate;

    private String projsize;

    public String getProjplanid() {
        return projplanid;
    }

    public void setProjplanid(String projplanid) {
        this.projplanid = projplanid == null ? null : projplanid.trim();
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

    public Date getDeclaredate() {
        return declaredate;
    }

    public void setDeclaredate(Date declaredate) {
        this.declaredate = declaredate;
    }

    public BigDecimal getPlaninvest() {
        return planinvest;
    }

    public void setPlaninvest(BigDecimal planinvest) {
        this.planinvest = planinvest;
    }

    public String getKeyan() {
        return keyan;
    }

    public void setKeyan(String keyan) {
        this.keyan = keyan == null ? null : keyan.trim();
    }

    public String getChushe() {
        return chushe;
    }

    public void setChushe(String chushe) {
        this.chushe = chushe == null ? null : chushe.trim();
    }

    public BigDecimal getKeyaninvest() {
        return keyaninvest;
    }

    public void setKeyaninvest(BigDecimal keyaninvest) {
        this.keyaninvest = keyaninvest;
    }

    public BigDecimal getChusheinvest() {
        return chusheinvest;
    }

    public void setChusheinvest(BigDecimal chusheinvest) {
        this.chusheinvest = chusheinvest;
    }

    public String getIsdeclare() {
        return isdeclare;
    }

    public void setIsdeclare(String isdeclare) {
        this.isdeclare = isdeclare == null ? null : isdeclare.trim();
    }

    public String getIsapprove() {
        return isapprove;
    }

    public void setIsapprove(String isapprove) {
        this.isapprove = isapprove == null ? null : isapprove.trim();
    }

    public String getGist() {
        return gist;
    }

    public void setGist(String gist) {
        this.gist = gist == null ? null : gist.trim();
    }

    public String getMaincontent() {
        return maincontent;
    }

    public void setMaincontent(String maincontent) {
        this.maincontent = maincontent == null ? null : maincontent.trim();
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

    public String getProjsize() {
        return projsize;
    }

    public void setProjsize(String projsize) {
        this.projsize = projsize == null ? null : projsize.trim();
    }
}