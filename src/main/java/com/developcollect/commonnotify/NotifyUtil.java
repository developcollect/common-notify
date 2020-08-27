package com.developcollect.commonnotify;

import com.developcollect.commonnotify.config.NotifyGlobalConfig;
import com.developcollect.commonnotify.notify.INotify;
import com.developcollect.commonnotify.notify.INotifyParameter;
import com.developcollect.commonnotify.notify.email.EmailNotifyParameter;
import org.springframework.core.io.Resource;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * @author zak
 * @since 1.0.0
 */
public class NotifyUtil {


    public static INotifyResult sendEmail(String templateSymbol, Map<String, String> vals, String to, Resource... resources) {
        return send(EmailNotifyParameter.of(templateSymbol, vals, Collections.singletonList(to), resources));
    }

    public static INotifyResult sendEmail(String templateSymbol, Map<String, String> vals, String to, Collection<Resource> resources) {
        return send(EmailNotifyParameter.of(templateSymbol, vals, Collections.singletonList(to), resources));
    }

    public static INotifyResult sendEmail(String templateSymbol, Map<String, String> vals, Collection<String> tos, Resource... resources) {
        return send(EmailNotifyParameter.of(templateSymbol, vals, tos, resources));
    }

    public static INotifyResult sendEmail(String templateSymbol, Map<String, String> vals, Collection<String> tos, Collection<Resource> resources) {
        return send(EmailNotifyParameter.of(templateSymbol, vals, tos, resources));
    }

    public static INotifyResult sendEmail(String templateSymbol, Map<String, String> vals, Collection<String> tos, Collection<String> ccs, Resource... resources) {
        return send(EmailNotifyParameter.of(templateSymbol, vals, tos, ccs, resources));
    }

    public static INotifyResult sendEmail(String templateSymbol, Map<String, String> vals, Collection<String> tos, Collection<String> ccs, Collection<Resource> resources) {
        return send(EmailNotifyParameter.of(templateSymbol, vals, tos, ccs, resources));
    }

    public static INotifyResult sendEmail(String templateSymbol, Map<String, String> vals, Collection<String> tos, Collection<String> ccs, Collection<String> bccs, Resource... resources) {
        return send(EmailNotifyParameter.of(templateSymbol, vals, tos, ccs, bccs, resources));
    }

    public static INotifyResult sendEmail(String templateSymbol, Map<String, String> vals, Collection<String> tos, Collection<String> ccs, Collection<String> bccs, Collection<Resource> resources) {
        return send(EmailNotifyParameter.of(templateSymbol, vals, tos, ccs, bccs, resources));
    }


    public static INotifyResult sendSms(String templateSymbol, Map<String, String> vals, Collection<String> tos) {
        return null;
    }


    public static INotifyResult send(INotifyParameter notifyParameter) {
        INotify notify = NotifyGlobalConfig
                .getInstance()
                .getNotifyFactory()
                .create(notifyParameter.getNotifyType());

        INotifyResult notifyResult = notify.send(notifyParameter);
        return notifyResult;
    }

}
