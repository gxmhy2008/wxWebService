package com.ningkangkj.wxWebService.entity.resp;

/**
 * @Description 回复视频消息
 * @Author luckypt
 * @Date 2018/04/26
 */
public class VideoMessageResp extends BaseMessageResp {

    //通过素材管理中的接口上传多媒体文件，得到的Id
    private String MediaId;
    //视频消息的标题
    private String Title;
    //视频消息描述
    private String Description;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

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
}
