package com.ningkangkj.wxWebService.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ningkangkj.wxWebService.config.ServerProperty;
import com.ningkangkj.wxWebService.entity.AccessToken;
import com.ningkangkj.wxWebService.mapper.AccessTokenMapper;
import com.ningkangkj.wxWebService.service.IAccessTokenService;
import com.ningkangkj.wxWebService.service.support.BaseServiceImpl;
import com.ningkangkj.wxWebService.util.HttpUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Service
public class AccessTokenServiceImpl extends BaseServiceImpl<AccessTokenMapper, AccessToken> implements IAccessTokenService{

    //公众号appid
    private static final String appid = ServerProperty.get("Appid");
    //公众号开发者密码
    private static final String secret = ServerProperty.get("AppSecret");

    private HashMap<String, String> params = new HashMap<>();

    @Override
    public boolean updateAccessToken() {
         AccessToken accessToken = baseMapper.selectWxInfo(appid);
        if (accessToken == null) {
            System.out.println("还没有添加该公众号");
            accessToken = new AccessToken();
            accessToken.setId(appid);
            Date oldTime = null;
            try {
                oldTime = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            accessToken.setInsertDate(oldTime);
            //baseMapper.insertRecord(accessToken);
            baseMapper.insert(accessToken);
        }
        int count = baseMapper.selectUpdateCount(appid);

        boolean res = false;
        if (count > 0) {
            System.out.println("秘钥过期,重新获取");
            try {
                //获取秘钥
                params.clear();
                params.put("grant_type", "client_credential");
                params.put("appid", appid);
                params.put("secret", secret);
                String dataToken = HttpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/token", params);
                JSONObject jo = JSON.parseObject(dataToken);
                String access_token = jo.get("access_token").toString();
                System.out.println("微信秘钥===" + access_token);

                //获取票据
                params.clear();
                params.put("access_token", access_token);
                params.put("type", "jsapi");
                String dataTicket = HttpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/ticket/getticket", params);
                JSONObject ticket = JSON.parseObject(dataTicket);
                String jsapiTicket = ticket.get("ticket").toString();
                System.out.println("票据===" + jsapiTicket);

                if (!"".equals(access_token) && !"".equals(jsapiTicket)) {
                    res = baseMapper.updateAccessToken(access_token, jsapiTicket, appid);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else {
            System.out.println("秘钥未过期");
        }
        return res;
    }

    @Override
    public String getJsapiTicket() {
        return baseMapper.getJsapiTicket(appid);
    }

    @Override
    public String getAccessToken() {
        return baseMapper.getAccessToken(appid);
    }
}
