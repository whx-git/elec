package com.whx.elec8.controller;

import com.whx.elec8.domain.ElecPopedom;
import com.whx.elec8.domain.ElecRole;
import com.whx.elec8.domain.ElecUser;
import com.whx.elec8.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RoleController {
    @Resource
    private RoleService roleService;
    @RequestMapping("roleIndex")
    public String roleIndex(Model model ){
        List<ElecRole> allRoles = roleService.getAllRoles();
        List<ElecPopedom> allPopes = roleService.getAllPopes();
        model.addAttribute("allRoles",allRoles);
        model.addAttribute("allPopes",allPopes);

        return "system/roleIndex";
    }

    @RequestMapping("getRoleDatas")
    public String getRoleDatas(String roleID,Model model){
        List<ElecPopedom> rolePopes = roleService.getRolePopes(roleID);
        List<ElecUser> roleUsers = roleService.getRoleUsers(roleID);
        model.addAttribute("rolePopes",rolePopes);
        model.addAttribute("roleUsers",roleUsers);

        return "system/roleEdit";
    }

    @RequestMapping("modifyRole")
    public String modifyRole(String roleID,String[] selectoper,String[] selectuser,Model model){
        try {
            roleService.modifyRole(roleID,selectoper,selectuser);
            model.addAttribute("resultInfo","修改成功!");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("resultInfo","修改失败!");
        }

        return "forward:/roleIndex.html";
    }
}
