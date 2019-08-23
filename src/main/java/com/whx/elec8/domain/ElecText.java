package com.whx.elec8.domain;

import java.util.Date;

public class ElecText {
    private String textid;

    private String textname;

    private Date textdate;

    private String textremark;

    public String getTextid() {
        return textid;
    }

    public void setTextid(String textid) {
        this.textid = textid == null ? null : textid.trim();
    }

    public String getTextname() {
        return textname;
    }

    public void setTextname(String textname) {
        this.textname = textname == null ? null : textname.trim();
    }

    public Date getTextdate() {
        return textdate;
    }

    public void setTextdate(Date textdate) {
        this.textdate = textdate;
    }

    public String getTextremark() {
        return textremark;
    }

    public void setTextremark(String textremark) {
        this.textremark = textremark == null ? null : textremark.trim();
    }
}