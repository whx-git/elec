package com.whx.elec8.domain;

import java.util.Date;

public class ElecApplication {
    private Integer applicationid;

    private Integer applicationtemplateid;

    private String applicationuserid;

    private String title;

    private String path;

    private Date applytime;

    private String status;

    private String processinstanceid;

    public Integer getApplicationid() {
        return applicationid;
    }

    public void setApplicationid(Integer applicationid) {
        this.applicationid = applicationid;
    }

    public Integer getApplicationtemplateid() {
        return applicationtemplateid;
    }

    public void setApplicationtemplateid(Integer applicationtemplateid) {
        this.applicationtemplateid = applicationtemplateid;
    }

    public String getApplicationuserid() {
        return applicationuserid;
    }

    public void setApplicationuserid(String applicationuserid) {
        this.applicationuserid = applicationuserid == null ? null : applicationuserid.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Date getApplytime() {
        return applytime;
    }

    public void setApplytime(Date applytime) {
        this.applytime = applytime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getProcessinstanceid() {
        return processinstanceid;
    }

    public void setProcessinstanceid(String processinstanceid) {
        this.processinstanceid = processinstanceid == null ? null : processinstanceid.trim();
    }
}