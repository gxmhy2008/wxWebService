package com.ningkangkj.wxWebService.entity.req;

/**
 * @Description 图片消息体
 * @Author luckypt
 * @Date 2018/04/25
 */
public class ImageMessageReq extends BaseMessageReq {
    //图片链接(由系统生成)
    private String PicUrl;
    //图片消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
