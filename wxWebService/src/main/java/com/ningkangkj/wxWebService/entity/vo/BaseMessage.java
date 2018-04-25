package com.ningkangkj.wxWebService.entity.vo;

/**
 * @Descrition 微信请求消息基本类
 * @Author luckypt
 * @Date 2018/04/25
 */
public class BaseMessage {
    //开发者微信号（公众号开发者设置的微信号,通常是开发者本人）
    private String toUserName;
    //发送方账户（一个关注公众号的用户的openid）
    private String fromUserName;
    //消息创建时间（整型)
    private long createTime;
    //消息类型(text/image/location/link/video/shortvideo)
    private String msgType;
    //消息id,64位整型
    private long msgId;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }
}
