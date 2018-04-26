package com.ningkangkj.wxWebService.entity.req;

/**
 * @Description 链接消息体
 * @Author luckypt
 * @Date 2018/04/25
 */
public class LinkMessageReq extends BaseMessageReq {
    //消息标题
    private String Title;
    //消息描述
    private String Description;
    //消息链接
    private String Url;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
