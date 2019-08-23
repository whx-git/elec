package com.whx.elec8.domain;

import java.util.Date;

public class ElecCommonmsg {
    private String comid;

    private String stationrun;

    private String devrun;

    private Date createdate;

    private String createempcode;

    public String getComid() {
        return comid;
    }

    public void setComid(String comid) {
        this.comid = comid == null ? null : comid.trim();
    }

    public String getStationrun() {
        return stationrun;
    }

    public void setStationrun(String stationrun) {
        this.stationrun = stationrun == null ? null : stationrun.trim();
    }

    public String getDevrun() {
        return devrun;
    }

    public void setDevrun(String devrun) {
        this.devrun = devrun == null ? null : devrun.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getCreateempcode() {
        return createempcode;
    }

    public void setCreateempcode(String createempcode) {
        this.createempcode = createempcode == null ? null : createempcode.trim();
    }
}