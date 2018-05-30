package com.ningkangkj.wxWebService.task;

import com.ningkangkj.wxWebService.service.IAccessTokenService;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.text.ParseException;

public class UpdateWxToken implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //更新微信秘钥
        IAccessTokenService accessTokenService = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean(IAccessTokenService.class);
        boolean res = accessTokenService.updateAccessToken();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
