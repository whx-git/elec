package com.whx.elec8.controller;

import com.whx.elec8.ConstantsKeys;
import com.whx.elec8.domain.ElecPopedom;
import com.whx.elec8.domain.ElecRole;
import com.whx.elec8.domain.ElecUser;
import com.whx.elec8.domain.LoginResultInfo;
import com.whx.elec8.service.UserService;
import com.whx.elec8.utils.MD5Utils;
import com.whx.elec8.utils.UtilSetUrl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("login")
    public String login(@RequestParam(required = true) String name, @RequestParam(required = true) String password, Model model){
        LoginResultInfo login = userService.login(name, MD5Utils.md5(password));
        ElecUser elecUser = login.getElecUser();

        if (elecUser!=null) {
            return "menu/home";
        }else {
            model.addAttribute("resultInfo", login.getResultIndo());
            return "menu/index";
        }
    }

    @RequestMapping("getMenuPopes")
    @ResponseBody
    public List<ElecPopedom> getMenuPopes(HttpSession session){
        TreeSet<ElecPopedom> elecPopes = (TreeSet<ElecPopedom>) session.getAttribute(ConstantsKeys.SESSION_POPES_NOW);

        List<ElecPopedom> menuPopes=new ArrayList<>();
        for (ElecPopedom elecPope : elecPopes) {
            if (elecPope.getIsmenu()) {
                menuPopes.add(elecPope);
            }
            if(elecPope.getName().equals("用户管理")){
//                System.out.println(  session.getAttribute(ConstantsKeys.SESSION_ROLES_NOW).getClass().getName());
                List<ElecRole> elecRoles= (List<ElecRole>) session.getAttribute(ConstantsKeys.SESSION_ROLES_NOW);
                UtilSetUrl.setUserManagerUrl(elecRoles,elecPope );

            }
        }
        return menuPopes;

    }
    @RequestMapping("userIndex")
    public String userIndex(){
        return "system/userIndex";
    }
    @RequestMapping("userEdit")
    public String userEdit(){
        return "system/userEdit";
    }
}
