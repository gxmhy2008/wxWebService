package com.ningkangkj.wxWebService.controller;

import com.ningkangkj.wxWebService.common.JSSDKConfig;
import com.ningkangkj.wxWebService.common.Message;
import com.ningkangkj.wxWebService.util.HttpPostUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
     * @return
     * @Description 调用Jssdk接口
     */
    @RequestMapping("jssdkApply")
    public String jssdkApply() {
        return "jssdk/checkJsApi";
    }

    @RequestMapping("uploadFile")
    public void uploadFile(){
        HttpPostUploadUtil upFile = new HttpPostUploadUtil();
        Map<String, String> fileImage = new HashMap<>();
        fileImage.put("lyc1.jpg","E:\\壁纸\\lyc.jpg");
        String res = upFile.formUpload(null, fileImage);
        System.out.println(res);
    }
}
