package com.whx.elec8.domain;

import java.util.Date;

public class ElecApproveinfo {
    private Integer approveid;

    private Integer applicationid;

    private String comment;

    private Boolean approval;

    private String approveuserid;

    private Date approvetime;

    public Integer getApproveid() {
        return approveid;
    }

    public void setApproveid(Integer approveid) {
        this.approveid = approveid;
    }

    public Integer getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(Integer applicationid) {
        this.applicationid = applicationid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Boolean getApproval() {
        return approval;
    }

    public void setApproval(Boolean approval) {
        this.approval = approval;
    }

    public String getApproveuserid() {
        return approveuserid;
    }

    public void setApproveuserid(String approveuserid) {
        this.approveuserid = approveuserid == null ? null : approveuserid.trim();
    }

    public Date getApprovetime() {
        return approvetime;
    }

    public void setApprovetime(Date approvetime) {
        this.approvetime = approvetime;
    }
}