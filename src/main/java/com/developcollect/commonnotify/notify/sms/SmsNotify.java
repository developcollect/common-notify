package com.developcollect.commonnotify.notify.sms;

import com.developcollect.commonnotify.NotifyContext;
import com.developcollect.commonnotify.SendResult;
import com.developcollect.commonnotify.config.IMessageTemplate;
import com.developcollect.commonnotify.notify.AbstractNotify;

import java.util.List;


/**
 * 短信发送
 * 短信发送需要依托于第三方平台, 例如阿里,腾讯等等..
 *
 * @author zak
 * @since 1.0.0
 */
public class SmsNotify extends AbstractNotify<SmsNotifyParameter, SmsNotifyResult> {


    @Override
    protected SmsNotifyResult send(String title, String content, NotifyContext context) {
        SmsNotifyConfig notifyConfig = context.getNotifyConfig();
        List<SendResult> sendResults = notifyConfig.getSmsSender().send(context);
        return SmsNotifyResult.of(sendResults);
    }

    @Override
    protected String processTitle(NotifyContext context, IMessageTemplate messageTemplate) {
        return null;
    }

}
