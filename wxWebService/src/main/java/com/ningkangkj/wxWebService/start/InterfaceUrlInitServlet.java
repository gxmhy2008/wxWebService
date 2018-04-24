package com.ningkangkj.wxWebService.start;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;

/**
 * @Description: 项目文件初始化
 * @Author luckypigger
 * @Date 2018/04/24
 */
public class InterfaceUrlInitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init(ServletConfig config){
        InterfaceUrlInit.init();
    }
}
