package com.developcollect.commonnotify;

import com.developcollect.commonnotify.config.AbstractNotifyConfig;
import com.developcollect.commonnotify.config.NotifyGlobalConfig;
import com.developcollect.commonnotify.notify.INotifyParameter;

/**
 * @author zak
 * @version 1.0.0
 */
public class NotifyContext {

    private AbstractNotifyConfig notifyConfig;

    private INotifyParameter notifyParameter;

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
        notifyContextThreadLocal.set(context);
        return context;
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
