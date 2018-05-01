package com.ningkangkj.wxWebService.dispatcher;

import com.ningkangkj.wxWebService.common.GetUserInfo;
import com.ningkangkj.wxWebService.entity.resp.Article;
import com.ningkangkj.wxWebService.entity.resp.ImageMessageResp;
import com.ningkangkj.wxWebService.entity.resp.NewsMessageResp;
import com.ningkangkj.wxWebService.util.HttpPostUploadUtil;
import com.ningkangkj.wxWebService.util.MessageUtil;

import java.io.IOException;
import java.util.*;

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
                //图片消息回复
                /*
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
                */
                //图文消息回复
                NewsMessageResp newmsg = new NewsMessageResp();
                newmsg.setToUserName(openid);
                newmsg.setFromUserName(mpid);
                newmsg.setCreateTime(new Date().getTime());
                newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);

                try {
                    HashMap<String, String> userInfo = GetUserInfo.openidUserInfo(openid);
                    Article article = new Article();
                    article.setDescription("欢迎光临！");
                    article.setPicUrl(userInfo.get("headimgurl"));//图文消息图片地址
                    article.setTitle("尊敬的：" + userInfo.get("nickname") + ",您好！");//图文消息的标题
                    article.setUrl("http://www.ningkangkj.com:18080/index"); //图文url链接
                    List<Article> list = new ArrayList<>();
                    list.add(article);
                    newmsg.setArticles(list);
                    newmsg.setArticleCount(list.size());
                    return MessageUtil.newsMessageToXml(newmsg);
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("==代码有问题");
                }

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
