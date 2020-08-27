package com.developcollect.commonnotify;

import com.developcollect.commonnotify.config.AbstractNotifyConfig;
import com.developcollect.commonnotify.config.IMessageTemplate;
import com.developcollect.commonnotify.config.NotifyGlobalConfig;
import com.developcollect.commonnotify.exception.NotifyException;
import com.developcollect.commonnotify.notify.INotifyParameter;
import lombok.Getter;

import java.util.function.Function;

/**
 * @author zak
 * @version 1.0.0
 */
public class NotifyContext {

    private AbstractNotifyConfig notifyConfig;

    private INotifyParameter notifyParameter;

    @Getter
    private IMessageTemplate messageTemplate;

    private NotifyContext() {
    }



    private static ThreadLocal<NotifyContext> notifyContextThreadLocal = new ThreadLocal<>();

    /**
     * 初始化上下文, 并绑定到当前线程
     */
    public static NotifyContext init(INotifyParameter notifyParameter) {
        NotifyContext context = new NotifyContext();
        context.notifyParameter = notifyParameter;
        context.notifyConfig = NotifyGlobalConfig.getInstance().getNotifyConfig(notifyParameter.getNotifyType());
        context.messageTemplate = context.fetchMessageTemplate();

        notifyContextThreadLocal.set(context);
        return context;
    }

    protected IMessageTemplate fetchMessageTemplate() {
        Function<String, IMessageTemplate> messageTemplateFetcher = notifyConfig.getMessageTemplateFetcher();

        if (messageTemplateFetcher != null) {
            IMessageTemplate messageTemplate = messageTemplateFetcher.apply(notifyParameter.getTemplateSymbol());
            if (messageTemplate == null) {
                throw new NotifyException("消息模板不存在: symbol: [{}]", notifyParameter.getTemplateSymbol());
            }

            return messageTemplate;
        }

        return null;
    }


    public static NotifyContext currContext() {
        return notifyContextThreadLocal.get();
    }

    public <T extends INotifyParameter> T getNotifyParameter() {
        return (T) this.notifyParameter;
    }

    public <T extends AbstractNotifyConfig> T getNotifyConfig() {
        return (T) notifyConfig;
    }
}
