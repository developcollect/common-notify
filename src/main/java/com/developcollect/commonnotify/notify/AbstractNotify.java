package com.developcollect.commonnotify.notify;

import cn.hutool.core.lang.Assert;
import com.developcollect.commonnotify.NotifyContext;
import com.developcollect.commonnotify.NotifyResult;
import com.developcollect.commonnotify.config.AbstractNotifyConfig;
import com.developcollect.commonnotify.config.IMessageTemplate;
import com.developcollect.commonnotify.exception.NotifyException;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

/**
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/5/31 14:35
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Slf4j
public abstract class AbstractNotify implements Notify {

    @Override
    public NotifyResult send(NotifyParameter notifyParameter) {
        validParameter(notifyParameter);
        // 初始化上下文
        NotifyContext context = NotifyContext.init(notifyParameter);

        // 获取消息模板
        IMessageTemplate messageTemplate = getBySymbol(notifyParameter.getTemplateSymbol());
        if (messageTemplate == null) {
            throw new NotifyException("消息模板不存在: symbol: [{}]", notifyParameter.getTemplateSymbol());
        }

        //
        AbstractNotifyConfig notifyConfig = context.getNotifyConfig();
        String content = notifyConfig.getContentProcessor().apply(messageTemplate);
        String title = notifyConfig.getTitleProcessor().apply(messageTemplate);

        // 发信
        log.debug("发送通知: 目标:[{}],  内容:[{}]", notifyParameter.getTos(), content);
        NotifyResult notifyResult = send(title, content, notifyParameter.getTos());
        return notifyResult;
    }

    protected abstract NotifyResult send(String title, String notifyContent, Collection<String> targets);

    protected IMessageTemplate getBySymbol(String templateSymbol) {
        AbstractNotifyConfig notifyConfig = NotifyContext.currContext().getNotifyConfig();
        IMessageTemplate messageTemplate = notifyConfig.getMessageTemplateFetcher().apply(templateSymbol);
        return messageTemplate;
    }

    protected void validParameter(NotifyParameter notifyParameter) {
        Assert.notBlank(notifyParameter.getTemplateSymbol(), "模板标识不能为空字符串");
        Assert.notEmpty(notifyParameter.getTos(), "通知目标不能为空");
    }

}
