package com.developcollect.commonnotify.notify.sms;


import com.developcollect.commonnotify.config.AbstractNotifyConfig;
import lombok.Data;

import java.util.Map;

/**
 * 短信发送配置
 *
 * @author zak
 * @version 1.0.0
 */
@Data
public class SmsNotifyConfig extends AbstractNotifyConfig {

    /**
     * 短信发送平台
     */
    private int smsPlatform;

    /**
     * 短信发送平台配置
     */
    private Map<String, Object> smsPlatformConfigMap;

    /**
     * 短信发送器
     */
    private SmsSender smsSender;
}
