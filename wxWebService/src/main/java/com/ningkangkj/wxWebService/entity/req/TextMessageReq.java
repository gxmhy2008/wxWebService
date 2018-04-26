package com.ningkangkj.wxWebService.entity.req;

/**
 * @Description 文本消息
 * @Author luckypt
 * @Date 2018/04/25
 */
public class TextMessageReq extends BaseMessageReq {
    //消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
