package com.ningkangkj.wxWebService.common;

import com.ningkangkj.wxWebService.util.GlobalConstants;
import com.ningkangkj.wxWebService.util.HttpUtils;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 微信两小时定时任务，定时获取access_token
 * @Author luckypt
 * @Date 2018/04/27
 */
public class WechatTask {
    public void getAccessToken() throws IOException {
        Map<String,String> params = new HashMap<String,String>();
        params.put("grant_type", "client_credential");
        params.put("appid", GlobalConstants.getInterfaceUrl("Appid"));
        params.put("secret", GlobalConstants.getInterfaceUrl("AppSecret"));
        //获取并保存调用微信服务器接口需要的access_token
        String jstoken = HttpUtils.sendGet(GlobalConstants.getInterfaceUrl("tokenUrl"), params);
        String access_token = JSONObject.fromObject(jstoken).getString("access_token");
        GlobalConstants.interfaceUrlProperties.put("access_token", access_token);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                +" token为======================="+access_token);

        //获取jsticket并保存
        params.clear();
        params.put("access_token", access_token);
        params.put("type", "jsapi");
        String jsticket = HttpUtils.sendGet(GlobalConstants.getInterfaceUrl("ticketUrl"), params);
        //保存jsapi_ticket到全局缓存中
        String jsapi_ticket = JSONObject.fromObject(jsticket).getString("ticket");
        GlobalConstants.interfaceUrlProperties.put("jsapi_ticket", jsapi_ticket);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
                +"jsapi_ticket为=================="+jsapi_ticket);
    }
}
