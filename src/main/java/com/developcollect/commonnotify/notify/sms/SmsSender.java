package com.developcollect.commonnotify.notify.sms;

import com.developcollect.commonnotify.NotifyContext;
import com.developcollect.commonnotify.SendResult;

import java.util.List;

/**
 * 短信发送器
 */
@FunctionalInterface
public interface SmsSender {

    List<SendResult> send(NotifyContext notifyContext);
}
