package com.whx.elec8.service;

import com.whx.elec8.controller.vo.DevPlanSearchVo;
import com.whx.elec8.domain.ElecDevicePlan;
import com.whx.elec8.service.bo.ExportSettingItem;
import com.whx.elec8.utils.doPage.PageBean;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface DevicePlanService {
    public List<ElecDevicePlan> getAllPlans();

    public PageBean<ElecDevicePlan> getPageDatasIndex(HttpServletRequest request);

    public PageBean<ElecDevicePlan> getPageDatasCondition( HttpServletRequest request, DevPlanSearchVo devPlanSearchVo);

    public ElecDevicePlan getPlanByID(String devPlanId);

    public List<ExportSettingItem> getDefaltExportItems();

    public List<ExportSettingItem> getDefaltNoExportItems();

    public void saveExportSetting(String names, String fields, String nonames, String nofields, HttpSession session);

    public byte[] genExportFile(DevPlanSearchVo devPlanSearchVo,List<ExportSettingItem> exportSettingItems) throws Exception;

    public String importPlans(MultipartFile files);


}
