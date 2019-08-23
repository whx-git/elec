package com.whx.elec8.utils;

import com.whx.elec8.ConstantsKeys;
import com.whx.elec8.domain.ElecPopedom;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.TreeSet;


public class CheckPopeTag extends SimpleTagSupport {
    //获取jsp中动态填写的属性值
    private String have;

    public String getHave() {
        return have;
    }

    public void setHave(String have) {
        this.have = have;
    }

    @Override
    public void doTag() throws JspException, IOException {
        //获取session
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        TreeSet<ElecPopedom> popedoms= (TreeSet<ElecPopedom>) session.getAttribute(ConstantsKeys.SESSION_POPES_NOW);
        boolean canHave=false;
        for (ElecPopedom popedom : popedoms) {
            if (popedom.getMid().equals("ec")){
                canHave=true;
                break;

            }
        }
        if(canHave) {
            //让自定义标签中的内容显示出来
            getJspBody().invoke(null);
        }


        

    }
}
