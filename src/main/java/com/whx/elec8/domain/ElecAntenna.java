package com.whx.elec8.domain;

import java.util.Date;

public class ElecAntenna {
    private String antennaid;

    private String jctid;

    private String antennaname;

    private String txzengyi;

    private String spbswidth;

    private String jihuafangshi;

    private String txchengshi;

    private String workhz;

    private String comment;

    private String isdelete;

    private String createempid;

    private Date createdate;

    private String lastempid;

    private Date lastdate;

    public String getAntennaid() {
        return antennaid;
    }

    public void setAntennaid(String antennaid) {
        this.antennaid = antennaid == null ? null : antennaid.trim();
    }

    public String getJctid() {
        return jctid;
    }

    public void setJctid(String jctid) {
        this.jctid = jctid == null ? null : jctid.trim();
    }

    public String getAntennaname() {
        return antennaname;
    }

    public void setAntennaname(String antennaname) {
        this.antennaname = antennaname == null ? null : antennaname.trim();
    }

    public String getTxzengyi() {
        return txzengyi;
    }

    public void setTxzengyi(String txzengyi) {
        this.txzengyi = txzengyi == null ? null : txzengyi.trim();
    }

    public String getSpbswidth() {
        return spbswidth;
    }

    public void setSpbswidth(String spbswidth) {
        this.spbswidth = spbswidth == null ? null : spbswidth.trim();
    }

    public String getJihuafangshi() {
        return jihuafangshi;
    }

    public void setJihuafangshi(String jihuafangshi) {
        this.jihuafangshi = jihuafangshi == null ? null : jihuafangshi.trim();
    }

    public String getTxchengshi() {
        return txchengshi;
    }

    public void setTxchengshi(String txchengshi) {
        this.txchengshi = txchengshi == null ? null : txchengshi.trim();
    }

    public String getWorkhz() {
        return workhz;
    }

    public void setWorkhz(String workhz) {
        this.workhz = workhz == null ? null : workhz.trim();
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