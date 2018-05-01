package com.ningkangkj.wxWebService.common;

import com.ningkangkj.wxWebService.util.GlobalConstants;
import com.ningkangkj.wxWebService.util.HttpUtils;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Description 获取维修用户信息
 * @Author luckypt
 * @Date 2018/04/30
 */
public class GetUserInfo {

    /**
     * @Description 通过Openid获取用户信息
     * @param openid
     * @return
     */
    public static HashMap<String, String> openidUserInfo(String openid) throws IOException {
        HashMap<String, String> params = new HashMap<>();
        params.put("access_token", GlobalConstants.getInterfaceUrl("access_token"));
        params.put("openid", openid);
        params.put("lang", "zh_CN");

        String subscribers = HttpUtils.sendGet(GlobalConstants.getInterfaceUrl("openIdUserInfoUrl"), params);
        System.out.println(subscribers);
        params.clear();

        //这里返回参数只取了昵称、头像和性别
        params.put("nickname", JSONObject.fromObject(subscribers).getString("nickname"));
        params.put("headimgurl", JSONObject.fromObject(subscribers).getString("headimgurl")); //图像
        params.put("sex", JSONObject.fromObject(subscribers).getString("sex"));

        return params;
    }
}
