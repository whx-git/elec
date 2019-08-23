package com.whx.elec8.domain;

public class ElecExportfields {
    private String belongto;

    private String expnamelist;

    private String expfieldname;

    private String noexpnamelist;

    private String noexpfieldname;

    public String getBelongto() {
        return belongto;
    }

    public void setBelongto(String belongto) {
        this.belongto = belongto == null ? null : belongto.trim();
    }

    public String getExpnamelist() {
        return expnamelist;
    }

    public void setExpnamelist(String expnamelist) {
        this.expnamelist = expnamelist == null ? null : expnamelist.trim();
    }

    public String getExpfieldname() {
        return expfieldname;
    }

    public void setExpfieldname(String expfieldname) {
        this.expfieldname = expfieldname == null ? null : expfieldname.trim();
    }

    public String getNoexpnamelist() {
        return noexpnamelist;
    }

    public void setNoexpnamelist(String noexpnamelist) {
        this.noexpnamelist = noexpnamelist == null ? null : noexpnamelist.trim();
    }

    public String getNoexpfieldname() {
        return noexpfieldname;
    }

    public void setNoexpfieldname(String noexpfieldname) {
        this.noexpfieldname = noexpfieldname == null ? null : noexpfieldname.trim();
    }
}