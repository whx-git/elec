package com.whx.elec8.domain;

import java.util.Date;

public class ElecEngineering {
    private String engineid;

    private String projid;

    private String enginename;

    private String enginestate;

    private String isdelete;

    private String createempid;

    private Date createdate;

    private String lastempid;

    private Date lastdate;

    public String getEngineid() {
        return engineid;
    }

    public void setEngineid(String engineid) {
        this.engineid = engineid == null ? null : engineid.trim();
    }

    public String getProjid() {
        return projid;
    }

    public void setProjid(String projid) {
        this.projid = projid == null ? null : projid.trim();
    }

    public String getEnginename() {
        return enginename;
    }

    public void setEnginename(String enginename) {
        this.enginename = enginename == null ? null : enginename.trim();
    }

    public String getEnginestate() {
        return enginestate;
    }

    public void setEnginestate(String enginestate) {
        this.enginestate = enginestate == null ? null : enginestate.trim();
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