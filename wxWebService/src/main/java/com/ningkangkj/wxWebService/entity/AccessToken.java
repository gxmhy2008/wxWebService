package com.ningkangkj.wxWebService.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * 微信相关秘钥数据表
 */
@TableName("weixin_access_token")
public class AccessToken {

    /**
     * appid编号
     */
    private String id;

    /**
     * 秘钥
     */
    @TableField("access_token")
    private String accessToken;

    /**
     * 票据
     */
    @TableField("jsapi_ticket")
    private String jsapiTicket;

    /**
     * 插入时间
     */
    private Date insertDate;

    /**
     * 票据插入时间
     */
    private Date jsapiDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getJsapiTicket() {
        return jsapiTicket;
    }

    public void setJsapiTicket(String jsapiTicket) {
        this.jsapiTicket = jsapiTicket;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getJsapiDate() {
        return jsapiDate;
    }

    public void setJsapiDate(Date jsapiDate) {
        this.jsapiDate = jsapiDate;
    }
}
