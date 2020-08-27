package com.developcollect.commonnotify.notify.sms;


import com.developcollect.commonnotify.config.AbstractNotifyConfig;
import lombok.Data;

import java.util.HashMap;
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
    private int smsPlatform = SmsPlatforms.ALI_CLOUD;

    /**
     * 短信发送平台配置
     */
    private Map<String, Object> smsPlatformConfigMap = new HashMap<>();


    /**
     * 短信通知工厂
     */
    private ISmsNotifyFactory smsNotifyFactory = new DefaultSmsNotifyFactory();


    public void putPlatformConfig(String key, Object val) {
        smsPlatformConfigMap.put(key, val);
    }

    public <T> T getPlatformConfig(String key) {
        return (T) smsPlatformConfigMap.get(key);
    }
}
