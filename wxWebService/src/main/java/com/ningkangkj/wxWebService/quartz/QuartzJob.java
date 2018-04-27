package com.ningkangkj.wxWebService.quartz;

import com.ningkangkj.wxWebService.common.WechatTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @Description 任务执行获取token
 * @Autor luckypt
 * @Date 2018/04/27
 */
public class QuartzJob {
    private static Logger logger = LoggerFactory.getLogger(QuartzJob.class);

    public void workForToken() {
        try {
            WechatTask timer = new WechatTask();
            timer.getAccessToken();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
