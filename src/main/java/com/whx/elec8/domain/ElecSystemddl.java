package com.whx.elec8.domain;

public class ElecSystemddl {
    private Integer seqid;

    private String keyword;

    private Integer ddlcode;

    private String ddlname;

    public Integer getSeqid() {
        return seqid;
    }

    public void setSeqid(Integer seqid) {
        this.seqid = seqid;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getDdlcode() {
        return ddlcode;
    }

    public void setDdlcode(Integer ddlcode) {
        this.ddlcode = ddlcode;
    }

    public String getDdlname() {
        return ddlname;
    }

    public void setDdlname(String ddlname) {
        this.ddlname = ddlname == null ? null : ddlname.trim();
    }
}