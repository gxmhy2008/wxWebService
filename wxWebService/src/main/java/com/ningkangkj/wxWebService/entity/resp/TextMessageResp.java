package com.ningkangkj.wxWebService.entity.resp;

/**
 * @Description 文本消息消息体
 * @Author luckypt
 * @Date 2018/04/26
 */
public class TextMessageResp extends BaseMessageResp {
    //回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
