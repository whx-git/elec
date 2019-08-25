package com.whx.elec8.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.whx.elec8.ConstantsKeys;
import com.whx.elec8.controller.vo.SiteAddVo;
import com.whx.elec8.controller.vo.SiteInfoVo;
import com.whx.elec8.domain.ElecStation;
import com.whx.elec8.domain.ElecSystemddl;
import com.whx.elec8.service.DDlService;
import com.whx.elec8.service.SiteInfoService;
import com.whx.elec8.service.bo.ExportSettingItem;
import com.whx.elec8.utils.DateTimeUtil;
import com.whx.elec8.utils.doPage.PageBean;
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
public class SiteInfoController {
    @Resource
    private SiteInfoService siteInfoService;
    @Resource
    private DDlService dDlService;
    @RequestMapping("siteInfoIndex")
    public String siteInfoIndex(Model model, HttpServletRequest request){
        PageBean<ElecStation> pageBean = siteInfoService.getAllPageDatas(request);
        List<ElecSystemddl> jctids = dDlService.queryDatasByKeyword("所属单位");
        List<ElecSystemddl> stationName = dDlService.queryDatasByKeyword("站点名称");
        List<ElecSystemddl> stationType = dDlService.queryDatasByKeyword("站点类别");
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("jctids",jctids);
        model.addAttribute("stationNames",stationName);
        model.addAttribute("stationTypes",stationType);
        return "siteEquapment/siteInfoIndex";
    }

    @RequestMapping("siteInfoView")
    public String siteInfoView(String stationid,Model model){
        ElecStation station = siteInfoService.getStation(stationid);
        model.addAttribute("station",station);
        return "siteEquapment/siteInfoView";
    }

    @RequestMapping("siteInfoPage")
    public String siteInfoPage(Model model,HttpServletRequest request){
        PageBean<ElecStation> pageBean = siteInfoService.getAllPageDatas(request);
        model.addAttribute("pageBean",pageBean);
        return "siteEquapment/siteInfoPage";

    }

    @RequestMapping("querySiteInfoDatas")
    public String querySiteInfoDatas(HttpServletRequest request, SiteInfoVo siteInfoVo,Model model){

        PageBean<ElecStation> pageBean = siteInfoService.getPageDatasCondition(request, siteInfoVo);
        model.addAttribute("pageBean",pageBean);
        model.addAttribute("condition",siteInfoVo);
        return "siteEquapment/siteInfoPage";

    }

    @RequestMapping("ExportSiteInfoVIew")
    public String ExportSiteInfoVIew(Model model,HttpSession session){
        Object ex = session.getAttribute(ConstantsKeys.SESSION_SITE_EX_ITEMS);
        List<ExportSettingItem> exportSettingItems=null;
        if (ex==null) {
            exportSettingItems= siteInfoService.ExportSiteInfo();
        }else{
            exportSettingItems= (List<ExportSettingItem>) ex;
        }

        Object noex = session.getAttribute(ConstantsKeys.SESSION_SITE_NOEX_ITEMS);
        List<ExportSettingItem> noExportSettingItems=null;
        if (noex==null) {
            noExportSettingItems=siteInfoService.NoExportSiteInfo();
        }else{
            noExportSettingItems= (List<ExportSettingItem>) noex;
        }

        model.addAttribute("exports",exportSettingItems);
        model.addAttribute("noExports",noExportSettingItems);

        return "siteEquapment/siteInfoExport";
    }

    @RequestMapping("saveExpoetInfo")
    public String saveExpoetInfo(HttpSession session,Model model,String expNameList,String expFieldName,
                                String noExpNameList,String noExpFieldName){

        siteInfoService.saveSiteExportInfo(session,expNameList,expFieldName,noExpNameList,noExpFieldName);
        model.addAttribute("resultInfo","设置成功");
        return "forward:ExportSiteInfoVIew.html";
    }

    @RequestMapping("exportSiteInfo")
    public void exportSiteInfo(HttpServletRequest request, HttpSession session, Model model, HttpServletResponse response,SiteInfoVo siteInfoVo){
        response.setCharacterEncoding("utf-8");
        Object ex = session.getAttribute(ConstantsKeys.SESSION_SITE_EX_ITEMS);
        List<ExportSettingItem> exportSettingItems=null;
        if (ex==null) {
            exportSettingItems=siteInfoService.ExportSiteInfo();
        }else{
            exportSettingItems= (List<ExportSettingItem>) ex;
        }
        try {
            byte[] bytes = siteInfoService.ExportSiteFiles(siteInfoVo, exportSettingItems);
            //处理文件名的中文
            String fileName="站点基本信息("+ DateTimeUtil.getNow_YYYY_MM_DD() +").xlsx";

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
                response.getWriter().write("网络异常请重试!!");
            } catch (IOException exc) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping("importSiteView")
    public String importSiteView(){
        return "siteEquapment/siteInfoImport";
    }

    @RequestMapping("siteImport")
    public String siteImport(MultipartFile file,Model model){
        String resultInfo = siteInfoService.SiteImports(file);
        model.addAttribute("resultInfo",resultInfo);

        return "forward:/importSiteView.html";
    }

    @RequestMapping("siteInfoAdd")
    public String siteInfoAdd(Model model){
        List<ElecSystemddl> jctids = dDlService.queryDatasByKeyword("所属单位");
        List<ElecSystemddl> stationName = dDlService.queryDatasByKeyword("站点名称");
        List<ElecSystemddl> stationType = dDlService.queryDatasByKeyword("站点类别");
        model.addAttribute("jctids",jctids);
        model.addAttribute("stationName",stationName);
        model.addAttribute("stationType",stationType);
        return "siteEquapment/siteInfoAdd";
    }

    @RequestMapping("addSite")
    public String addSite(Model model, SiteAddVo siteAddVo){
        boolean b = siteInfoService.AddSiteInfo(siteAddVo);
        if (!b) {
            model.addAttribute("resultInfo","添加失败!");
        }
        model.addAttribute("resultInfo","添加成功!");
        return "forward:/siteInfoAdd.html";
    }

    @RequestMapping("siteInfoEdit")
    public String siteInfoEdit(String stationid,Model model){
        ElecStation station = siteInfoService.getStation(stationid);
        List<ElecSystemddl> jctids = dDlService.queryDatasByKeyword("所属单位");
        List<ElecSystemddl> stationType = dDlService.queryDatasByKeyword("站点类别");
        model.addAttribute("jctids",jctids);
        model.addAttribute("stationType",stationType);
        model.addAttribute("station",station);
        return "siteEquapment/siteInfoEdit";
    }

    @RequestMapping("modifySiteInfo")
    public String modifySiteInfo(Model model,SiteAddVo siteAddVo,String stationid){
        ElecStation station = siteInfoService.getStation(stationid);
        String resultInfo = siteInfoService.modifiSiteInfo(siteAddVo, station);

        model.addAttribute("resultInfo",resultInfo);
        return "forward:/siteInfoEdit.html";
    }

    @RequestMapping("deleteSiteInfo")
    public String deleteSiteInfo(Integer stationid,Model model){
        String resultInfo = siteInfoService.deleteSite(stationid);
        model.addAttribute("resultInfo",resultInfo);
        return "forward:/siteInfoPage.html";

    }
}
