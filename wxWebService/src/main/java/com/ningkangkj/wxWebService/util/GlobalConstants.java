package com.ningkangkj.wxWebService.util;

import java.util.Properties;

/**
 * @Description 全局变量
 * @Author luckyPt
 * @Date 2018/04/24
 */
public class GlobalConstants {
    public static Properties interfaceUrlProperties;

    /**
     * @Description 获取接口调用url
     * @Author luckypt
     * @param key
     * @return
     */
    public static String getInterfaceUrl(String key) {
        return interfaceUrlProperties.get(key).toString();
    }
}
