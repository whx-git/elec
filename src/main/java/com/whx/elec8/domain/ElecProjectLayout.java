package com.whx.elec8.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ElecProjectLayout {
    private String layprojid;

    private String projname;

    private Integer seqid;

    private Integer projgrade;

    private String parentprojid;

    private String property;

    private String size;

    private String adress;

    private Date starttime;

    private Date endtime;

    private Date planstarttime;

    private BigDecimal planinvest;

    private String maincontent;

    private String comment;

    private String isdelete;

    private String createempid;

    private Date createdate;

    private String lastempid;

    private Date lastdate;

    private String varseqid;

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

    public Integer getSeqid() {
        return seqid;
    }

    public void setSeqid(Integer seqid) {
        this.seqid = seqid;
    }

    public Integer getProjgrade() {
        return projgrade;
    }

    public void setProjgrade(Integer projgrade) {
        this.projgrade = projgrade;
    }

    public String getParentprojid() {
        return parentprojid;
    }

    public void setParentprojid(String parentprojid) {
        this.parentprojid = parentprojid == null ? null : parentprojid.trim();
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Date getPlanstarttime() {
        return planstarttime;
    }

    public void setPlanstarttime(Date planstarttime) {
        this.planstarttime = planstarttime;
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

    public String getVarseqid() {
        return varseqid;
    }

    public void setVarseqid(String varseqid) {
        this.varseqid = varseqid == null ? null : varseqid.trim();
    }
}