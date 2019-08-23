package com.whx.elec8.service.impls;

import com.whx.elec8.ConstantsKeys;
import com.whx.elec8.dao.RoleDao;
import com.whx.elec8.domain.ElecPopedom;
import com.whx.elec8.domain.ElecRole;
import com.whx.elec8.domain.ElecUser;
import com.whx.elec8.service.RoleService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;
    @Resource
    private RedisTemplate redisTemplate;
    @Override
    public List<ElecRole> getAllRoles() {

        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object o = valueOperations.get(ConstantsKeys.REDIES_KEY_ROLES);
        List<ElecRole> elecRoles=null;
        if (o==null) {
            System.out.println("缓存中没有数据getAllRoles");
             elecRoles = roleDao.querryAllRoles();
             if (elecRoles!=null){
                 valueOperations.set(ConstantsKeys.REDIES_KEY_ROLES,elecRoles);
             }
        }else{
            System.out.println("从缓存中的拿数据getAllRoles");
            elecRoles= (List<ElecRole>) o;
        }

        return elecRoles;
    }

    @Override
    public List<ElecPopedom> getAllPopes() {

        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object o = valueOperations.get(ConstantsKeys.REDIES_KEY_POPES);
        List<ElecPopedom> elecPopedoms=null;
        if (o==null) {
            System.out.println("缓存中没有数据getAllPopes");
            elecPopedoms= roleDao.queryAllPopes();
            if (elecPopedoms!=null){
                valueOperations.set(ConstantsKeys.REDIES_KEY_POPES,elecPopedoms);
            }
        }else{
            System.out.println("从缓存中拿数据getAllPopes");
            elecPopedoms= (List<ElecPopedom>) o;
        }
        return elecPopedoms;
    }

    @Override
    public List<ElecPopedom> getRolePopes(String roleID) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object o = valueOperations.get(ConstantsKeys.REDIES_KEY_GETROLEPOPES + roleID);
        Object o1= valueOperations.get(ConstantsKeys.REDIES_KEY_POPES);
        List<ElecPopedom> elecPopedoms=null;
        List<ElecPopedom> allPopes=null;
        if (o==null) {
            System.out.println("缓存中没有getRolePopes");
            elecPopedoms= roleDao.queryPopesByRoleID(roleID);
            allPopes= (List<ElecPopedom>) o1;
            for (ElecPopedom popedom : allPopes) {
                if(elecPopedoms.contains(popedom)){
                    popedom.setChecked(true);
                }

            }
            valueOperations.set(ConstantsKeys.REDIES_KEY_GETROLEPOPES+roleID,allPopes);
        }else{
            System.out.println("缓存中有getRolePopes");
            allPopes= (List<ElecPopedom>) o;
        }
        return allPopes;
    }

    @Override
    public List<ElecUser> getRoleUsers(String roleID) {
        List<ElecUser> allUsers = roleDao.queryAllUser();
        List<ElecUser> roleUsers= roleDao.queryRoleUser(roleID);

        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object o = valueOperations.get(ConstantsKeys.RREDIS_KEY_USE+roleID);
        if (o==null) {
            System.out.println("缓存中没有getRoleUsers");
            for (ElecUser elecUser : allUsers) {
                if(roleUsers.contains(elecUser)){
                    elecUser.setChecked(true);
                }
            }
            valueOperations.set(ConstantsKeys.RREDIS_KEY_USE+roleID,allUsers);
        }else{
            System.out.println("缓存中有getRoleUsers");
            allUsers= (List<ElecUser>) o;
        }


        return allUsers;
    }

    @Override
    @Transactional
    public void modifyRole(String roleID, String[] selectoper,String[] selectuser) {
        //原有角色所拥有的的权限
        List<ElecPopedom> elecPopedomsOld1 = roleDao.queryPopesByRoleID(roleID);
        //现有权限
        List<ElecPopedom> elecPopedomsNew=new ArrayList<>();
        for (String s : selectoper) {
            ElecPopedom elecPopedom=new ElecPopedom();
            elecPopedom.setMid(s);
            elecPopedomsNew.add(elecPopedom);

        }

        //备份一份原来的权限
        List<ElecPopedom> elecPopedomsOld2=new ArrayList<>();
        for (ElecPopedom elecPopedom : elecPopedomsOld1) {
            elecPopedomsOld2.add(elecPopedom);
        }


        //old1:a b c e
        //new:b c f h
        //removeall---->old1:a e
        elecPopedomsOld1.removeAll(elecPopedomsNew);
        elecPopedomsNew.removeAll(elecPopedomsOld2);

        for (ElecPopedom elecPopedom1 : elecPopedomsOld1) {
            roleDao.deleteRolePope(roleID,elecPopedom1.getMid());
        }

        for (ElecPopedom elecPopedom2 : elecPopedomsNew) {
            roleDao.insertRolePope(roleID,elecPopedom2.getMid());
        }
//-------------------------------------------------------------------------------------------
        //原来的用户角色
        List<ElecUser> roleUsersOld1= roleDao.queryRoleUser(roleID);
        //备份用户角色
        List<ElecUser> roleUsersOld2=new ArrayList<>();
        for (ElecUser elecUser : roleUsersOld1) {
            roleUsersOld2.add(elecUser);
        }
        //现在的用户角色
        List<ElecUser> roleUsersNew=new ArrayList<>();
        for (String s : selectuser) {
            ElecUser elecUser=new ElecUser();
            elecUser.setUserid(s);
            roleUsersNew.add(elecUser);
        }

        roleUsersOld1.removeAll(roleUsersNew);
        for (ElecUser elecUser : roleUsersOld1) {
            roleDao.deleteRoleUser(elecUser.getUserid(),roleID);
        }


        roleUsersNew.removeAll(roleUsersOld2);
        for (ElecUser elecUser : roleUsersNew) {
            roleDao.insertRoleUser(elecUser.getUserid(),roleID);
        }




        redisTemplate.delete(ConstantsKeys.RREDIS_KEY_USE+roleID);
        redisTemplate.delete(ConstantsKeys.REDIES_KEY_GETROLEPOPES+roleID);


    }
}
