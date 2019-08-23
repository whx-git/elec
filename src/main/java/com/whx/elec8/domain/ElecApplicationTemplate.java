package com.whx.elec8.domain;

public class ElecApplicationTemplate {
    private Integer id;

    private String name;

    private String processdefinitionkey;

    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProcessdefinitionkey() {
        return processdefinitionkey;
    }

    public void setProcessdefinitionkey(String processdefinitionkey) {
        this.processdefinitionkey = processdefinitionkey == null ? null : processdefinitionkey.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
}