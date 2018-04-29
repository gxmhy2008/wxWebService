package com.ningkangkj.wxWebService.dispatcher;

import com.ningkangkj.wxWebService.entity.resp.ImageMessageResp;
import com.ningkangkj.wxWebService.util.HttpPostUploadUtil;
import com.ningkangkj.wxWebService.util.MessageUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 事件消息的业务分发处理器
 * @Author luckypt
 * @Date 2018/04/25
 */
public class EventDispatcher {
    public static String processEvent(Map<String,String> map) {
        String openid = map.get("FromUserName"); //用户openid
        String mpid = map.get("ToUserName"); //公众号原始id

        switch (map.get("Event")) {
            case MessageUtil.EVENT_TYPE_SUBSCRIBE:
                System.out.println("=============================这是关注事件!");
                ImageMessageResp imgmsg = new ImageMessageResp();
                imgmsg.setToUserName(openid);
                imgmsg.setFromUserName(mpid);
                imgmsg.setCreateTime(new Date().getTime());
                imgmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_IMAGE);
                HttpPostUploadUtil util = new HttpPostUploadUtil();
                String filePath = "/home/Recreation/pics/monkey.jpg";
                Map<String, String> textMap = new HashMap<>();
                textMap.put("name", "testname");
                Map<String, String> fileMap = new HashMap<>();
                fileMap.put("userfile", filePath);
                //表达上传文件到微信服务器
                String mediaidrs = util.formUpload(textMap, fileMap);
                //解析微信服务器信息
                System.out.println(mediaidrs);
                String mediaid = net.sf.json.JSONObject.fromObject(mediaidrs).getString("media_id");
                imgmsg.setMediaId(mediaid);

                return MessageUtil.imageMessageToXml(imgmsg);
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
