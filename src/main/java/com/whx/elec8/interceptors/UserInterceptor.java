package com.whx.elec8.interceptors;

import com.whx.elec8.ConstantsKeys;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.TreeSet;

//基于spring-aop理念做的
//拦截器
public class UserInterceptor implements HandlerInterceptor {
    //前置
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userNow = request.getSession().getAttribute(ConstantsKeys.SESSION_USER_NOW);

        Object rolesNow = request.getSession().getAttribute(ConstantsKeys.SESSION_ROLES_NOW);

        Object popesNow = request.getSession().getAttribute(ConstantsKeys.SESSION_POPES_NOW);

        boolean canPass=userNow!=null && rolesNow!=null && popesNow!=null && ((List)rolesNow).size()>0 && ((TreeSet)popesNow).size()>0;

        if (!canPass) {
            response.sendRedirect("/index.jsp");
        }

        //返回false相当于不放行
        return canPass;
    }
    //后置
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //后置的后置(after)
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
