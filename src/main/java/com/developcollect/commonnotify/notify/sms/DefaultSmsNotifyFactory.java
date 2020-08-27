package com.developcollect.commonnotify.notify.sms;

import com.developcollect.commonnotify.notify.INotify;
import com.developcollect.commonnotify.notify.sms.alicloud.AliCloudSmsNotify;

/**
 * @author zak
 * @version 1.0.0
 */
public class DefaultSmsNotifyFactory implements ISmsNotifyFactory {

    @Override
    public INotify<SmsNotifyParameter, SmsNotifyResult> create(int smsPlatform) {
        switch (smsPlatform) {
            case SmsPlatforms.ALI:
                return new AliCloudSmsNotify();
            default:
                throw new IllegalArgumentException("不支持的短信服务平台: " + smsPlatform);
        }
    }
}
