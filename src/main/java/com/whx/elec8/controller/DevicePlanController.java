package com.whx.elec8.controller;

import com.whx.elec8.ConstantsKeys;
import com.whx.elec8.controller.vo.DevPlanSearchVo;
import com.whx.elec8.domain.ElecDevicePlan;
import com.whx.elec8.domain.ElecSystemddl;
import com.whx.elec8.service.DDlService;
import com.whx.elec8.service.DevicePlanService;
import com.whx.elec8.service.bo.ExportSettingItem;
import com.whx.elec8.utils.DateTimeUtil;
import com.whx.elec8.utils.doPage.PageBean;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class DevicePlanController {
    @Resource
    private DevicePlanService devicePlanService;
    @Resource
    private DDlService dDlService;
    @RequestMapping("devicePlanIndex")
    public String devicePlanIndex(Model model, HttpServletRequest request){
        PageBean pageBean = devicePlanService.getPageDatasIndex(request);

        List<ElecSystemddl> jctids = dDlService.queryDatasByKeyword("所属单位");
        List<ElecSystemddl> devtypes = dDlService.queryDatasByKeyword("设备类型");
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("jctids",jctids);
        model.addAttribute("devtypes",devtypes);

        return  "equapment/planIndex";
    }


    @RequestMapping("planView")
    public String planView(String devPlanId,Model model){
        ElecDevicePlan plan = devicePlanService.getPlanByID(devPlanId);
        model.addAttribute("plan",plan);

        return "equapment/planView";
    }
    @RequestMapping("planPage")
    public String planPage(Model model, HttpServletRequest request){
        PageBean pageBean = devicePlanService.getPageDatasIndex(request);
        model.addAttribute("pageBean",pageBean);
        return "equapment/planPage";
    }
    //查询按钮查询数据
    @RequestMapping("queryDatas")
    public String queryDatas(Model model, HttpServletRequest request, DevPlanSearchVo devPlanSearchVo){
        PageBean pageBean = devicePlanService.getPageDatasCondition(request, devPlanSearchVo);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("condition",devPlanSearchVo);

        return "equapment/planPage";
    }
    @RequestMapping("planExportView")
    public String planExportView(Model model,HttpSession session){
        Object ex = session.getAttribute(ConstantsKeys.SESSION_PLAN_EX_ITEMS);
        List<ExportSettingItem> defaltExportItems =null;
        if (ex==null) {
            defaltExportItems = devicePlanService.getDefaltExportItems();
        }else {
            defaltExportItems= (List<ExportSettingItem>) ex;
        }


        Object noex = session.getAttribute(ConstantsKeys.SESSION_PLAN_NOEX_ITEMS);
        List<ExportSettingItem> defaltNoExportItems = null;
        if (noex==null) {
            defaltNoExportItems = devicePlanService.getDefaltNoExportItems();
        }else{
            defaltNoExportItems= (List<ExportSettingItem>) noex;
        }

        model.addAttribute("defaltExportItems",defaltExportItems);
        model.addAttribute("defaltNoExportItems",defaltNoExportItems);
        return "equapment/planExport";
    }

    @RequestMapping("saveExportSetting")
    public String saveExportSetting(Model model,String names, String fields, String nonames, String nofields, HttpSession session){

        devicePlanService.saveExportSetting(names,fields,nonames,nofields,session);

        model.addAttribute("resultInfo","设置成功!!");

        return "forward:planExportView.html";
    }

    @RequestMapping("exportPlans")
    public void exportPlans(HttpServletRequest request,HttpSession session,Model model, HttpServletResponse response, DevPlanSearchVo devPlanSearchVo){
        response.setCharacterEncoding("utf-8");
        Object ex = session.getAttribute(ConstantsKeys.SESSION_PLAN_EX_ITEMS);
        List<ExportSettingItem> exportSettingItems=null;
        if (ex==null) {
            exportSettingItems=devicePlanService.getDefaltExportItems();
        }else{
            exportSettingItems= (List<ExportSettingItem>) ex;
        }
        try {
            byte[] bytes = devicePlanService.genExportFile(devPlanSearchVo, exportSettingItems);
            //处理文件名的中文  设备计划表(2019-05-19).xlsx
            String fileName="设备计划表("+ DateTimeUtil.getNow_YYYY_MM_DD() +").xlsx";

            String userAgent = request.getHeader("User-Agent");
            //针对IE或者以IE为内核的浏览器：
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                //非IE浏览器的处理：
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            }

            //设置为附件类型
            response.setHeader("content-disposition", "attachment;filename="+fileName);

            response.getOutputStream().write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.getWriter().write("网络异常请重试");
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

    }
    @RequestMapping("planImportView")
    public String planImportView(){

        return  "equapment/planImport";
    }

    @RequestMapping("planImport")
    public String planImport(MultipartFile files,Model model){
        String resultInfo = devicePlanService.importPlans(files);
        model.addAttribute("resultInfo",resultInfo);

        return "forward:/planImportView.html";
    }
}
