package com.whx.elec8.controller;

import com.whx.elec8.domain.ElecFileupload;
import com.whx.elec8.domain.ElecSystemddl;
import com.whx.elec8.service.DDlService;
import com.whx.elec8.service.DataChartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DataChartController {

    @Resource
    private DDlService dDlService;

    @Resource
    private DataChartService dataChartService;
    @RequestMapping("dataChartIndex")
    public String dataChartIndex(Model model){
        List<ElecSystemddl> jctids = dDlService.queryDatasByKeyword("所属单位");
        List<ElecSystemddl> types = dDlService.queryDatasByKeyword("图纸类别");

        model.addAttribute("jctids",jctids);
        model.addAttribute("types",types);

        return "dataChart/dataChartIndex";
    }

    @RequestMapping("dataChartAdd")
    public String dataChartAdd(Model model){
        List<ElecSystemddl> jctids = dDlService.queryDatasByKeyword("所属单位");
        List<ElecSystemddl> types = dDlService.queryDatasByKeyword("图纸类别");

        model.addAttribute("jctids",jctids);
        model.addAttribute("types",types);
        return "dataChart/dataChartAdd";
    }

    @RequestMapping("uploadFiles")
    public String uploadFiles(MultipartFile[] uploads ,String[] comments,String projId,String belongTo,Model model){

        String resultInfo = dataChartService.uploadFiles(uploads, comments, projId, belongTo);
        model.addAttribute("resultInfo",resultInfo);
        return "forward:/dataChartAdd.html";
    }

    @RequestMapping("queryAddData")
    public String queryAddData(String projId,String belongTo,Model model){
        List<ElecFileupload> elecFileuploads = dataChartService.queryAddData(projId, belongTo);
        model.addAttribute("elecFileuploads",elecFileuploads);

        return "dataChart/dataChartAddList";

    }

    @RequestMapping("queryData")
    public String queryData(String projId,String belongTo,String queryString,Model model){
        List<ElecFileupload> elecFileuploads = dataChartService.queryData(projId, belongTo, queryString);
        model.addAttribute("elecFileuploads",elecFileuploads);

        return "forward:/dataChartIndex.html";

    }
}
