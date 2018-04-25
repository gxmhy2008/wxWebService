package com.ningkangkj.wxWebService.dispatcher;

import java.util.Map;
import com.ningkangkj.wxWebService.util.MessageUtil;

/**
 * @Description 普通消息的业务分发处理器
 * @Author luckypt
 * @Date 2018/04/25
 */
public class MsgDispatcher {
    public static String processMessage(Map<String, String> map) {
        switch (map.get("MsgType")){
            case MessageUtil.REQ_MESSAGE_TYPE_TEXT:
                System.out.println("=================这是文本消息!");
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_IMAGE:
                System.out.println("=================这是图片消息!");
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_LINK:
                System.out.println("=================这是链接消息!");
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_LOCATION:
                System.out.println("=================这是位置消息!");
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_VOICE:
                System.out.println("=================这是语音消息!");
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_VIDEO:
                System.out.println("=================这是视频消息!");
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO:
                System.out.println("=================这是小视频消息!");
            default:
                System.out.println("=================普通消息类型有误!");
                break;
        }
        return null;
    }
}
