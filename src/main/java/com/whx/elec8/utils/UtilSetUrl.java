package com.whx.elec8.utils;

import com.whx.elec8.domain.ElecPopedom;
import com.whx.elec8.domain.ElecRole;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.List;

public class UtilSetUrl {
    public static void setUserManagerUrl(List<ElecRole> elecRoles, ElecPopedom elecPopedom){
        //0号元素代表用户的最高角色
        ElecRole elecRole = elecRoles.get(0);
        Integer roleID = NumberUtils.createInteger(elecRole.getRoleid());
        if (roleID<=3) {
            //管理员
            elecPopedom.setUrl("/userIndex.html");
        }else{
            //用户
            elecPopedom.setUrl("/userEdit.html");
        }
    };
}
