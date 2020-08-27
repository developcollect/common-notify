package com.developcollect.commonnotify.notify.sms.ali;

import com.developcollect.commonnotify.notify.INotify;
import com.developcollect.commonnotify.notify.sms.SmsNotifyParameter;
import com.developcollect.commonnotify.notify.sms.SmsNotifyResult;

/**
 * 阿里云短信通知
 */
public class AliSmsNotify implements INotify<SmsNotifyParameter, SmsNotifyResult> {

    @Override
    public SmsNotifyResult send(SmsNotifyParameter notifyParameter) {
        return null;
    }

}
