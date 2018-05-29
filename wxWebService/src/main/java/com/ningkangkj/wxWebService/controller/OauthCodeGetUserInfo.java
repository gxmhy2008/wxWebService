package com.ningkangkj.wxWebService.controller;

import com.ningkangkj.wxWebService.util.GlobalConstants;
import com.ningkangkj.wxWebService.util.HttpUtils;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * @Description oauth认证通过code获取用户信息
 * @Author luckypt
 * @Date 2018/05/29
 */
@Controller
@RequestMapping("/authrz")
public class OauthCodeGetUserInfo {
    private String openid;
    private String accessToken;
    private String code;
    private String unionid;
    private HashMap<String, String> params = new HashMap<>();

    @RequestMapping("/index")
    public String indexPage() {
        return "authRZ/ydsq";
    }
    @RequestMapping("/getWxCode")
    public String getWxCode(HttpServletRequest request) throws IOException {
        String wxAuth = GlobalConstants.getInterfaceUrl("WX_AUTH");
        //拼接本地openid回调地址,微信授权获取到code后,回调本地服务器地址（可以通过该回调地址获取openid）
        String requestUrl = request.getRequestURL().toString();
        String wxRedirectUri = requestUrl.substring(0, requestUrl.lastIndexOf("getWxCode"))+"openIdGet";
        String authoUrl = wxAuth.replace("APPID",GlobalConstants.getInterfaceUrl("Appid"))
                .replace("REDIRECT_URI",URLEncoder.encode(wxRedirectUri,"UTF-8"));

       return "redirect:"+  authoUrl;
    }
    @RequestMapping("/openIdGet")
    public HashMap<String, String> getUserInfo(@RequestParam(value = "code", required = true) String code,
                                               @RequestParam(value = "state", required = true) String state) throws IOException {
        //通过code获取access_token,openid,unionid
        params.put("appid", GlobalConstants.getInterfaceUrl("Appid"));
        params.put("secret", GlobalConstants.getInterfaceUrl("AppSecret"));
        params.put("code", code);
        params.put("grant_type", "authorization_code");
        String tokenrs = HttpUtils.sendGet(GlobalConstants.getInterfaceUrl("WX_OPENID"), params);
        System.out.println("tokenrs===========================" + tokenrs);
        accessToken = JSONObject.fromObject(tokenrs).getString("access_token");
        openid = JSONObject.fromObject(tokenrs).getString("openid");
        // unionid = JSONObject.fromObject(tokenrs).getString("unionid");
        //通过Openid获取用户详细信息
        params.clear();
        params.put("access_token", accessToken);
        params.put("openid", openid);

        return null;

    }
}
