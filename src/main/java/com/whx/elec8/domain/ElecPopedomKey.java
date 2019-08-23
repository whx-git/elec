package com.whx.elec8.domain;

public class ElecPopedomKey {


    private String pid;


    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }
}