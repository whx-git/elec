package com.whx.elec8.dao;

import com.whx.elec8.domain.ElecRole;
import com.whx.elec8.domain.ElecUser;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    @Select("select * from elec_user where logonName=#{param1} and logonPwd=#{param2}")
    public ElecUser queryUserByNameAndPwd(String name, String pwd);

    @Select("select *from elec_role LEFT JOIN elec_role_user ON elec_role.roleID=elec_role_user.roleid where userid=#{userid} ")
    public List<ElecRole> queryUserRoles(String userid);
}
