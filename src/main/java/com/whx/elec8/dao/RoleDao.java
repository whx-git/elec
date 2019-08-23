package com.whx.elec8.dao;

import com.whx.elec8.domain.ElecPopedom;
import com.whx.elec8.domain.ElecRole;
import com.whx.elec8.domain.ElecUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleDao {
    @Select("select * from elec_role")
    public List<ElecRole> querryAllRoles();

    @Select("select * from elec_popedom")
    public List<ElecPopedom> queryAllPopes();

    @Select("SELECT * from elec_popedom where MID in(SELECT MID from elec_role_popedom where roleId=#{roleID})")
    public List<ElecPopedom> queryPopesByRoleID(String roleID);

    @Delete("delete from elec_role_popedom where roleID=#{param1} and mid=#{param2}")
    public void deleteRolePope(String roleID,String mid);

    @Insert("insert into elec_role_popedom values(#{param1},#{param2})")
    public void insertRolePope(String roleID,String mid);

    @Select("select *from elec_user")
    public List<ElecUser> queryAllUser();

    @Select("SELECT * from elec_user LEFT JOIN elec_role_user ON elec_user.userID=elec_role_user.userid WHERE roleid=#{roleID}")
    public List<ElecUser> queryRoleUser(String roleID);

    @Delete("delete from elec_role_user where userid=#{param1} and roleid=#{param2}")
    public void deleteRoleUser(String userid,String roleID);

    @Insert("insert into elec_role_user values(#{param1},#{param2})")
    public void insertRoleUser(String userid,String roleID);


}


