package com.ningkangkj.wxWebService.dispatcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ningkangkj.wxWebService.entity.resp.Article;
import com.ningkangkj.wxWebService.entity.resp.NewsMessageResp;
import com.ningkangkj.wxWebService.entity.resp.TextMessageResp;
import com.ningkangkj.wxWebService.util.MessageUtil;

/**
 * @Description 普通消息的业务分发处理器
 * @Author luckypt
 * @Date 2018/04/25
 */
public class MsgDispatcher {
    public static String processMessage(Map<String, String> map) {

        String openId = map.get("FromUserName"); //用户openId
        String mpId = map.get("ToUserName");  //公众号原始id
        switch (map.get("MsgType")){
            case MessageUtil.REQ_MESSAGE_TYPE_TEXT:
                System.out.println("=================这是文本消息!");
                //响应普通文本消息
                TextMessageResp txtMsg = new TextMessageResp();
                txtMsg.setToUserName(openId);
                txtMsg.setFromUserName(mpId);
                txtMsg.setCreateTime(new Date().getTime());
                txtMsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                txtMsg.setContent("你好，欢迎光临！");
                return MessageUtil.textMessageToXml(txtMsg);
            case MessageUtil.REQ_MESSAGE_TYPE_IMAGE:
                System.out.println("=================这是图片消息!");
                NewsMessageResp newsMessageResp = new NewsMessageResp();
                newsMessageResp.setToUserName(openId);
                newsMessageResp.setFromUserName(mpId);
                newsMessageResp.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                newsMessageResp.setCreateTime(new Date().getTime());
                Article article = new Article();
                //图文信息的描述
                article.setDescription("翱翔的飞鹰");
                //图文消息图片地址
                article.setPicUrl("http://app.ah122.cn/app3_0-cms/upload/image/20180425/20180425165617_58.jpg");
                //图文消息标题
                article.setTitle("翱翔的飞鹰");
                //图文url连接
                article.setUrl("http://www.baidu.com");
                List<Article> list = new ArrayList<Article>();
                //这里只发送一个图文，如果需要发送多图文则在list中加入多个Article即可
                list.add(article);
                newsMessageResp.setArticleCount(list.size());
                newsMessageResp.setArticles(list);
                return MessageUtil.newsMessageToXml(newsMessageResp);
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
