package com.ningkangkj.wxWebService.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.ningkangkj.wxWebService.entity.AccessToken;
import org.apache.ibatis.annotations.Param;

/**
 * 微信相关秘钥数据表
 */
public interface AccessTokenMapper extends BaseMapper<AccessToken> {

    int selectUpdateCount(@Param("id") String id);

    boolean updateAccessToken(@Param("access_token") String access_token, @Param("jsapi_ticket") String jsapi_ticket,
                              @Param("id") String id);

    String getJsapiTicket(@Param("id") String id);

    String getAccessToken(@Param("id") String id);

    AccessToken selectWxInfo(@Param("appid") String appid);

    boolean insertRecord(@Param("record")AccessToken record);
}
