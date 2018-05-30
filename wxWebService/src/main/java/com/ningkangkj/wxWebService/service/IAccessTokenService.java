package com.ningkangkj.wxWebService.service;

import com.baomidou.mybatisplus.service.IService;
import com.ningkangkj.wxWebService.entity.AccessToken;

import java.text.ParseException;

public interface IAccessTokenService extends IService<AccessToken>{
    boolean updateAccessToken();

    String getJsapiTicket();

    String getAccessToken();
}
