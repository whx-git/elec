package com.whx.elec8.domain;

import java.math.BigDecimal;
import java.util.Date;

public class ElecJctbuild {
    private String buildid;

    private String jctid;

    private String buildname;

    private String buildtype;

    private Date buildstartdate;

    private Date dxdate;

    private Date usedate;

    private String buildlayer;

    private String buildarea;

    private Date extendbuilddate;

    private String extendbuildarea;

    private BigDecimal buildexpense;

    private String comment;

    private String isdelete;

    private String createempid;

    private Date createdate;

    private String lastempid;

    private Date lastdate;

    public String getBuildid() {
        return buildid;
    }

    public void setBuildid(String buildid) {
        this.buildid = buildid == null ? null : buildid.trim();
    }

    public String getJctid() {
        return jctid;
    }

    public void setJctid(String jctid) {
        this.jctid = jctid == null ? null : jctid.trim();
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname == null ? null : buildname.trim();
    }

    public String getBuildtype() {
        return buildtype;
    }

    public void setBuildtype(String buildtype) {
        this.buildtype = buildtype == null ? null : buildtype.trim();
    }

    public Date getBuildstartdate() {
        return buildstartdate;
    }

    public void setBuildstartdate(Date buildstartdate) {
        this.buildstartdate = buildstartdate;
    }

    public Date getDxdate() {
        return dxdate;
    }

    public void setDxdate(Date dxdate) {
        this.dxdate = dxdate;
    }

    public Date getUsedate() {
        return usedate;
    }

    public void setUsedate(Date usedate) {
        this.usedate = usedate;
    }

    public String getBuildlayer() {
        return buildlayer;
    }

    public void setBuildlayer(String buildlayer) {
        this.buildlayer = buildlayer == null ? null : buildlayer.trim();
    }

    public String getBuildarea() {
        return buildarea;
    }

    public void setBuildarea(String buildarea) {
        this.buildarea = buildarea == null ? null : buildarea.trim();
    }

    public Date getExtendbuilddate() {
        return extendbuilddate;
    }

    public void setExtendbuilddate(Date extendbuilddate) {
        this.extendbuilddate = extendbuilddate;
    }

    public String getExtendbuildarea() {
        return extendbuildarea;
    }

    public void setExtendbuildarea(String extendbuildarea) {
        this.extendbuildarea = extendbuildarea == null ? null : extendbuildarea.trim();
    }

    public BigDecimal getBuildexpense() {
        return buildexpense;
    }

    public void setBuildexpense(BigDecimal buildexpense) {
        this.buildexpense = buildexpense;
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