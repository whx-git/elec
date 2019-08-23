package com.whx.elec8.domain;

import java.util.Date;

public class ElecLog {
    private String logid;

    private String ipaddress;

    private String opename;

    private Date opetime;

    private String details;

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid == null ? null : logid.trim();
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress == null ? null : ipaddress.trim();
    }

    public String getOpename() {
        return opename;
    }

    public void setOpename(String opename) {
        this.opename = opename == null ? null : opename.trim();
    }

    public Date getOpetime() {
        return opetime;
    }

    public void setOpetime(Date opetime) {
        this.opetime = opetime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }
}