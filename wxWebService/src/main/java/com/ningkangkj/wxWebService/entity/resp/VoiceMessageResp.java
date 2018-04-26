package com.ningkangkj.wxWebService.entity.resp;

/**
 * @Description 语音消息
 * @Author luckypt
 * @Date 2018/04/26
 */
public class VoiceMessageResp extends BaseMessageResp {
    //通过素材管理中的接口上传多媒体文件，得到的id
    private String MediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
