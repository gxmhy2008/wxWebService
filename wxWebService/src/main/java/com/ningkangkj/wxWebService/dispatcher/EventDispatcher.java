package com.ningkangkj.wxWebService.dispatcher;

import com.ningkangkj.wxWebService.util.MessageUtil;

import java.util.Map;

/**
 * @Description 事件消息的业务分发处理器
 * @Author luckypt
 * @Date 2018/04/25
 */
public class EventDispatcher {
    public static String processEvent(Map<String,String> map) {
        switch (map.get("Event")) {
            case MessageUtil.EVENT_TYPE_SUBSCRIBE:
                System.out.println("=============================这是关注事件!");
                break;
            case MessageUtil.EVENT_TYPE_UNSUBSCRIBE:
                System.out.println("=============================这是取消关注事件!");
                break;
            case MessageUtil.EVENT_TYPE_SCAN:
                System.out.println("=============================这是扫描二维码事件!");
                break;
            case MessageUtil.EVENT_TYPE_LOCATION:
                System.out.println("=============================这是位置上报事件!");
                break;
            case MessageUtil.EVENT_TYPE_CLICK:
                System.out.println("=============================这是自定义菜单点击事件!");
                break;
            case MessageUtil.EVENT_TYPE_VIEW:
                System.out.println("=============================这是自定义菜单View事件!");
                break;
            default:
                System.out.println("==============================事件消息类型有误!");
                break;

        }
        return null;
    }
}
