package com.whx.elec8.domain;

public class ElecProjectDeclare {
    private Integer seqid;

    private String projplanid;

    private String declareyear;

    private String declarestate;

    public Integer getSeqid() {
        return seqid;
    }

    public void setSeqid(Integer seqid) {
        this.seqid = seqid;
    }

    public String getProjplanid() {
        return projplanid;
    }

    public void setProjplanid(String projplanid) {
        this.projplanid = projplanid == null ? null : projplanid.trim();
    }

    public String getDeclareyear() {
        return declareyear;
    }

    public void setDeclareyear(String declareyear) {
        this.declareyear = declareyear == null ? null : declareyear.trim();
    }

    public String getDeclarestate() {
        return declarestate;
    }

    public void setDeclarestate(String declarestate) {
        this.declarestate = declarestate == null ? null : declarestate.trim();
    }
}