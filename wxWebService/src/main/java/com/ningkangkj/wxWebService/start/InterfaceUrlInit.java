package com.ningkangkj.wxWebService.start;

import com.ningkangkj.wxWebService.util.GlobalConstants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description 项目启动配置文件初始化
 *              初始化两个配置文件，一个用来配置在微信开发中经常用到的appid，AppSecret的参数(wechat.properties),
 *              另一个用来初始化我们经常用到的http请求的url地址interface_url.properties
 * @Author luckypigger
 * @Date 2018/04/24
 */
public class InterfaceUrlInit {
    public synchronized static void init(){
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        if(GlobalConstants.interfaceUrlProperties == null){
            GlobalConstants.interfaceUrlProperties = new Properties();
        }

        InputStream in = null;
        try{
            in = cl.getResourceAsStream("interface_url.properties");
            props.load(in);
            for (Object key : props.keySet()) {
                GlobalConstants.interfaceUrlProperties.put(key, props.get(key));
                System.out.println("key:"+key+", value:"+props.get(key));
            }

            props = new Properties();
            in = cl.getResourceAsStream("wechat.properties");
            props.load(in);
            for (Object key : props.keySet()) {
                GlobalConstants.interfaceUrlProperties.put(key, props.get(key));
                System.out.println("key:"+key+", value:"+props.get(key));
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally{
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
