package com.ningkangkj.wxWebService.common;

import com.ningkangkj.wxWebService.util.GlobalConstants;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Description 用户微信前端页面的Jssdk配置使用
 * @Author luckypt
 * @Date 2018/04/30
 */
public class JSSDKConfig {

    /**
     * @Description 前端jssdk页面配置需要用到的配置参数
     * @param url
     * @return hasmap {appid,timestam,nonceStr,signature}
     */
    public static HashMap<String, String> jsSDKSign(String url) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String nonceStr = createNonceStr();
        //TODO
        Long  timestamp =  new Date().getTime();
        //String timestamp = new Timestamp(new Date().getTime()).toString() ;
        System.out.println("timestamp is :" + timestamp);
        String jsapiTicket = GlobalConstants.getInterfaceUrl("jsapi_ticket");
        //注意这里参数名必须全部小写，且必须有序
        String string1 = "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonceStr
                        + "&timestamp=" + timestamp + "&url=" + url;
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(string1.getBytes("UTF-8"));
        String signature = byteTOHex(crypt.digest());
        HashMap<String, String> jssdk = new HashMap<>();
        jssdk.put("appId", GlobalConstants.getInterfaceUrl("Appid"));
        jssdk.put("timestamp", timestamp.toString());
        jssdk.put("nonceStr", nonceStr);
        jssdk.put("signature", signature);
        return jssdk;
    }

    private static String byteTOHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String createNonceStr() {
        return UUID.randomUUID().toString();
    }
}
