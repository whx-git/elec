package com.whx.elec8.service;

import com.whx.elec8.domain.ElecPopedom;
import com.whx.elec8.domain.ElecRole;
import com.whx.elec8.domain.ElecUser;

import java.util.List;

public interface RoleService {
    public List<ElecRole> getAllRoles();
    public List<ElecPopedom> getAllPopes();

    public List<ElecPopedom> getRolePopes(String roleID);
    public List<ElecUser> getRoleUsers(String roleID);

    public void modifyRole(String roleID,String[] selectoper,String[] selectuser) throws Exception;

}
