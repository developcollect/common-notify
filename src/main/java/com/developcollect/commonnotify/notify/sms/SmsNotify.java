package com.developcollect.commonnotify.notify.sms;

import com.developcollect.commonnotify.INotifyResult;
import com.developcollect.commonnotify.notify.AbstractNotify;

import java.util.Collection;

/**
 * 短信发送
 * 短信发送需要依托于第三方平台, 例如阿里,腾讯等等..
 *
 * @author zak
 * @since 1.0.0
 */
public class SmsNotify extends AbstractNotify {

    @Override
    protected INotifyResult send(String title, String notifyContent, Collection<String> targets) {
//        SmsUtil.
        return null;
    }

}
