package com.ningkangkj.wxWebService.entity.resp;

/**
 * @Description 图片消息
 * @Author luckpy
 * @Date 2018/04/26
 */
public class ImageMessageResp extends BaseMessageResp {
    //通过素材管理中的接口上传多媒体文件，得到的id
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
