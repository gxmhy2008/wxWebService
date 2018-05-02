package com.ningkangkj.wxWebService.controller;

import com.ningkangkj.wxWebService.common.JSSDKConfig;
import com.ningkangkj.wxWebService.common.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Description 前端用户微信配置获取
 * @Author luckypt
 * @Date 2018/04/30
 */
@Controller
@RequestMapping("/wechatconfig")
public class WechatController {

    /**
     * @param url
     * @return
     * @Description 前端获取微信jssdk的配置参数
     */
    @RequestMapping("jssdk")
    @ResponseBody
    public Message jsSdkConfig(@RequestParam(value = "url", required = true) String url) {
        try {
            System.out.println(url);
            Map<String, String> configMap = JSSDKConfig.jsSDKSign(url);
            return Message.success(configMap);
        } catch (Exception e) {
            return Message.error();
        }
    }

    @RequestMapping("jssdkConfig")
    public String jssdkConfig() {
        return "jssdkConfig";
    }

    /**
     * @Description 调用Jssdk接口
     * @return
     */
    @RequestMapping("jssdkApply")
    public String jssdkApply() {
        return "jssdk/checkJsApi";
    }
}
