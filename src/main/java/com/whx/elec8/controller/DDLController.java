package com.whx.elec8.controller;

import com.whx.elec8.domain.ElecSystemddl;
import com.whx.elec8.service.DDlService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class DDLController {
    @Resource
    private DDlService dDlService;
    @RequestMapping("dictionaryIndex")
    public String dictionaryIndex(Model model){
        List<String> keywords = dDlService.queryAllKeyword();
        model.addAttribute("keywords",keywords);
        return "system/dictionaryIndex";
    }

    @RequestMapping("getDatas")
    public String getDatas(String keyword,Model model){
        System.out.println("keyword = " +keyword);
        List<ElecSystemddl> keywordDatas = dDlService.queryDatasByKeyword(keyword);
        model.addAttribute("keywordDatas",keywordDatas);

        return "system/dictionaryEdit";

    }

    @RequestMapping("modifyDatas")
    public String modifyDatas(String keyword,String keywordname,String[] itemname){
        boolean empty1= StringUtils.isEmpty(keyword);
        boolean empty2 = StringUtils.isEmpty(keywordname);
        if (empty1&& !empty2) {
            //新增
            try {
                dDlService.addKeyword(keywordname,itemname);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(!empty1&&empty2){
            //修改
            try {
                dDlService.modifyKeyword(keyword,itemname);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "forward:/dictionaryIndex.html";
    }
}
