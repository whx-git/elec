package com.whx.elec8.service;

import com.whx.elec8.domain.ElecSystemddl;

import java.util.List;

public interface DDlService {
    public List<String> queryAllKeyword();

    public List<ElecSystemddl> queryDatasByKeyword(String keyword);

    public void addKeyword(String keyword,String[] datas) throws Exception;

    public void modifyKeyword(String keyword,String[] datas) throws Exception;

}
