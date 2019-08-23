package com.whx.elec8.domain;

import java.util.Date;

public class ElecEngineeringPlanHistory {
    private String sepid;

    private String engineplanid;

    private String projplanid;

    private String enginename;

    private String isdelete;

    private String createempid;

    private Date createdate;

    private String lastempid;

    private Date lastdate;

    private String declareyear;

    public String getSepid() {
        return sepid;
    }

    public void setSepid(String sepid) {
        this.sepid = sepid == null ? null : sepid.trim();
    }

    public String getEngineplanid() {
        return engineplanid;
    }

    public void setEngineplanid(String engineplanid) {
        this.engineplanid = engineplanid == null ? null : engineplanid.trim();
    }

    public String getProjplanid() {
        return projplanid;
    }

    public void setProjplanid(String projplanid) {
        this.projplanid = projplanid == null ? null : projplanid.trim();
    }

    public String getEnginename() {
        return enginename;
    }

    public void setEnginename(String enginename) {
        this.enginename = enginename == null ? null : enginename.trim();
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

    public String getDeclareyear() {
        return declareyear;
    }

    public void setDeclareyear(String declareyear) {
        this.declareyear = declareyear == null ? null : declareyear.trim();
    }
}