package com.ningkangkj.wxWebService.controller;

import com.ningkangkj.wxWebService.util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 定义于微信服务器交互方法
 * @Author   luckypt
 * @Date    2018/04/25
 */
@Controller
@RequestMapping("/wechat")
public class WechatSecurity {
    private static Logger logger = LoggerFactory.getLogger(WechatSecurity.class);

    /**
     * @Descriptin 接收微信服务器的get请求，验证合法性
     * @param request
     * @param response
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     */
    @RequestMapping(value = "security", method = RequestMethod.GET)
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response,
                      @RequestParam(value = "signature",required = true) String signature,
                      @RequestParam(value = "timestamp",required = true) String timestamp,
                      @RequestParam(value = "nonce",required = true) String nonce,
                      @RequestParam(value = "echostr",required = true) String echostr) {
        try {
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            }else{
                logger.info("这里存在非法请求");
                System.out.println("这里存在非法请求");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * 接收微信服务端消息
     */
    @RequestMapping(value = "security", method = RequestMethod.POST)
    public void DoPost() {
        System.out.println("这是post方法");
    }

}
