package com.developcollect.commonnotify;

import com.developcollect.commonnotify.config.NotifyGlobalConfig;
import com.developcollect.commonnotify.notify.INotify;
import com.developcollect.commonnotify.notify.email.EmailNotify;
import com.developcollect.commonnotify.notify.sms.SmsNotifyConfig;

/**
 * @author zak
 * @version 1.0.0
 */
public class DefaultNotifyFactory implements INotifyFactory {
    @Override
    public INotify create(int notifyType) {
        switch (notifyType) {
            case NotifyTypes.EMAIL:
                return new EmailNotify();
            case NotifyTypes.SMS:
                SmsNotifyConfig smsNotifyConfig = NotifyGlobalConfig.getInstance().getNotifyConfig(NotifyTypes.SMS);
                return smsNotifyConfig.getSmsNotifyFactory().create(smsNotifyConfig.getSmsPlatform());
            default:
                throw new IllegalArgumentException("不支持的通知类型: " + notifyType);
        }
    }
}
