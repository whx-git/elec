package com.whx.elec8.service;

import com.whx.elec8.controller.vo.SiteInfoVo;
import com.whx.elec8.domain.ElecStation;
import com.whx.elec8.utils.doPage.PageBean;

import javax.servlet.http.HttpServletRequest;

public interface SiteInfoService {
    public PageBean<ElecStation> getAllPageDatas(HttpServletRequest request);

    public ElecStation getStation(String stationid);

    public PageBean<ElecStation> getPageDatasCondition(HttpServletRequest request, SiteInfoVo siteInfoVo);
}
