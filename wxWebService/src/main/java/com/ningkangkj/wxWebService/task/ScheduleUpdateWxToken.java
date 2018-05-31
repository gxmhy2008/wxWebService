package com.ningkangkj.wxWebService.task;

import com.ningkangkj.wxWebService.service.IAccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleUpdateWxToken {
    @Autowired
    private IAccessTokenService accessTokenService;

    /**
     * 监听微信秘钥是否过期
     */
    @Scheduled(cron="0 0/5 * * * ? ")
    public void updateAccessToken(){
        accessTokenService.updateAccessToken();
        System.out.println("check wxToken valid=====================");
    }
}
