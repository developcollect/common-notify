package com.developcollect.commonnotify;

import com.developcollect.commonnotify.notify.INotifyParameter;
import com.developcollect.commonnotify.notify.email.EmailNotifyParameter;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * @author zak
 * @since 1.0.0
 */
public class NotifyUtil {


    public static void sendEmail(String templateSymbol, Map<String, String> vals, String to) {
        sendEmail(templateSymbol, vals, Collections.singletonList(to));
    }

    public static void sendEmail(String templateSymbol, Map<String, String> vals, Collection<String> tos) {
        EmailNotifyParameter emailNotifyParameter = new EmailNotifyParameter();
        sendEmail(templateSymbol, vals, tos);
    }


    public static void send(INotifyParameter notifyParameter) {

    }

}
