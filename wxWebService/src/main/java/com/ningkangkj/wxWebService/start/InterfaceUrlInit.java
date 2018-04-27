package com.ningkangkj.wxWebService.start;

import com.ningkangkj.wxWebService.util.GlobalConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
    /*log4j日志调用*/
    private static Logger logger = LoggerFactory.getLogger(InterfaceUrlInit.class);

    public synchronized static void init(){
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Properties props = new Properties();
        if(GlobalConstants.interfaceUrlProperties == null){
            GlobalConstants.interfaceUrlProperties = new Properties();
        }

        InputStream in = null;
        try{
            in = cl.getResourceAsStream("properties/interface_url.properties");
            props.load(in);
            for (Object key : props.keySet()) {
                GlobalConstants.interfaceUrlProperties.put(key, props.get(key));
//                System.out.println("key:"+key+", value:"+props.get(key));
//                logger.info("key:"+key+", value:"+props.get(key));
            }

            props = new Properties();
            in = cl.getResourceAsStream("properties/wechat.properties");
            props.load(in);
            for (Object key : props.keySet()) {
                GlobalConstants.interfaceUrlProperties.put(key, props.get(key));
//                System.out.println("key:"+key+", value:"+props.get(key));
//                logger.info("key:"+key+", value:"+props.get(key));
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
    private static Logger log = LoggerFactory.getLogger(InterfaceUrlInit.class);

    public static void main(String[] args) {

        log.debug("debug");
        log.info("info");
        log.error("error");
    }
}
