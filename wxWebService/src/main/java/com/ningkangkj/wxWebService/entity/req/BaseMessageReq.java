package com.ningkangkj.wxWebService.entity.req;

/**
 * @Descrition 微信请求消息基本类
 * @Author luckypt
 * @Date 2018/04/25
 */
public class BaseMessageReq {
    //开发者微信号（公众号开发者设置的微信号,通常是开发者本人）
    private String ToUserName;
    //发送方账户（一个关注公众号的用户的openid）
    private String FromUserName;
    //消息创建时间（整型)
    private long CreateTime;
    //消息类型(text/image/location/link/video/shortvideo)
    private String MsgType;
    //消息id,64位整型
    private long MsgId;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
