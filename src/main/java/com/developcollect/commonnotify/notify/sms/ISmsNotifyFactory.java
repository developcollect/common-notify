package com.developcollect.commonnotify.notify.sms;

import com.developcollect.commonnotify.notify.INotify;

/**
 * 短信通知工厂
 * 之所以短信通知有额外的工厂, 是因为短信通知都是依托于第三方服务
 * 在实际使用时会有很多不同的短信服务提供商
 */
public interface ISmsNotifyFactory {


    /**
     * 创建短信通知
     *
     * @param smsPlatform 短信服务平台
     */
    INotify<SmsNotifyParameter, SmsNotifyResult> create(int smsPlatform);


}
