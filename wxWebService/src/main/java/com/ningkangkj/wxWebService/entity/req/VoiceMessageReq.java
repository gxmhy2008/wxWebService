package com.ningkangkj.wxWebService.entity.req;

/**
 * @Description 语音消息
 * @Author luckypt
 * @Date 2018/04/25
 */
public class VoiceMessageReq extends BaseMessageReq {
    //语音消息媒体id，可以调用多媒体文件下载接口拉取数据
    private String MediaId;
    //语音格式,如amr，speex等
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
