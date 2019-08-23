package com.whx.elec8.service.impls;

import com.whx.elec8.ConstantsKeys;
import com.whx.elec8.dao.RoleDao;
import com.whx.elec8.dao.UserDao;
import com.whx.elec8.domain.ElecPopedom;
import com.whx.elec8.domain.ElecRole;
import com.whx.elec8.domain.ElecUser;
import com.whx.elec8.domain.LoginResultInfo;
import com.whx.elec8.service.RoleService;
import com.whx.elec8.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static com.whx.elec8.ConstantsKeys.SESSION_ROLES_NOW;

@Service
@EnableCaching
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private RoleDao roleDao;
    @Override
//    @Cacheable(cacheNames=ConstantsKeys.REDIES_CACHE_MANAGER,key =ConstantsKeys.REDIES_KEY_USER+"+#name"+"+#password")
    public LoginResultInfo login(String name, String password) {

        LoginResultInfo loginResultInfo=new LoginResultInfo();
        System.out.println("UserServiceImpl.login");

        ElecUser elecUser = userDao.queryUserByNameAndPwd(name, password);
        if (elecUser==null) {
            loginResultInfo.setResultIndo("用户名密码错误!");
            return loginResultInfo;
        }
        List<ElecRole> elecRoles = userDao.queryUserRoles(elecUser.getUserid());

//        List<ElecPopedom> allPopes=new ArrayList<>();
        TreeSet<ElecPopedom> allPopes=new TreeSet<>();
        for (ElecRole elecRole : elecRoles) {
            List<ElecPopedom> rolePopes = roleDao.queryPopesByRoleID(elecRole.getRoleid());
            allPopes.addAll(rolePopes);

        }
        if (allPopes==null) {
            loginResultInfo.setResultIndo("请联系管理员添加权限!");
            return loginResultInfo;
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.setAttribute(ConstantsKeys.SESSION_USER_NOW, elecUser);
        session.setAttribute(ConstantsKeys.SESSION_ROLES_NOW, elecRoles);
        session.setAttribute(ConstantsKeys.SESSION_POPES_NOW, allPopes);

        loginResultInfo.setElecUser(elecUser);
        loginResultInfo.setResultIndo("登录成功");
        return loginResultInfo;
    }
}
