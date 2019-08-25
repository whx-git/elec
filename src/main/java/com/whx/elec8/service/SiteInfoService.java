package com.whx.elec8.service;

import com.whx.elec8.controller.vo.SiteAddVo;
import com.whx.elec8.controller.vo.SiteInfoVo;
import com.whx.elec8.domain.ElecStation;
import com.whx.elec8.service.bo.ExportSettingItem;
import com.whx.elec8.utils.doPage.PageBean;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface SiteInfoService {
    public PageBean<ElecStation> getAllPageDatas(HttpServletRequest request);

    public ElecStation getStation(String stationid);

    public PageBean<ElecStation> getPageDatasCondition(HttpServletRequest request, SiteInfoVo siteInfoVo);

    public List<ExportSettingItem> ExportSiteInfo();

    public List<ExportSettingItem> NoExportSiteInfo();

    public void saveSiteExportInfo(HttpSession session, String expNameList, String expFieldName,
                                   String noExpNameList, String noExpFieldName);

    public byte[] ExportSiteFiles(SiteInfoVo siteInfoVo,List<ExportSettingItem> exportSettingItems) throws NoSuchFieldException, Exception;

    public String SiteImports(MultipartFile file);

    public boolean AddSiteInfo(SiteAddVo siteAddVo);

    public String modifiSiteInfo(SiteAddVo siteAddVo,ElecStation station) ;

    public String deleteSite(Integer statinid);
}
