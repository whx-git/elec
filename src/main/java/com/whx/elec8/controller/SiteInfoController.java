package com.whx.elec8.controller;

import com.whx.elec8.controller.vo.SiteInfoVo;
import com.whx.elec8.domain.ElecStation;
import com.whx.elec8.domain.ElecSystemddl;
import com.whx.elec8.service.DDlService;
import com.whx.elec8.service.SiteInfoService;
import com.whx.elec8.utils.doPage.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
        model.addAttribute("stationName",stationName);
        model.addAttribute("stationType",stationType);
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

}
