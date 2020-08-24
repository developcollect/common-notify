package com.developcollect.commonnotify;

import com.developcollect.commonnotify.config.AbstractNotifyConfig;
import com.developcollect.commonnotify.config.NotifyGlobalConfig;
import com.developcollect.commonnotify.notify.NotifyParameter;

/**
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/8/24 15:37
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class NotifyContext {

    private AbstractNotifyConfig notifyConfig;


    private NotifyContext() {
    }

    public <T extends AbstractNotifyConfig> T getNotifyConfig() {
        return (T) notifyConfig;
    }

    private static ThreadLocal<NotifyContext> notifyContextThreadLocal = new ThreadLocal<>();

    /**
     * 初始化上下文, 并绑定到当前线程
     */
    public static NotifyContext init(NotifyParameter notifyParameter) {
        NotifyContext context = new NotifyContext();
        context.notifyConfig = NotifyGlobalConfig.getNotifyConfig(notifyParameter.getNotifyType());
        notifyContextThreadLocal.set(context);
        return context;
    }


    public static NotifyContext currContext() {
        return notifyContextThreadLocal.get();
    }

}
