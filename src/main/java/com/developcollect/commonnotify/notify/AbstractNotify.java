package com.developcollect.commonnotify.notify;

import cn.hutool.core.lang.Assert;
import com.developcollect.commonnotify.INotifyResult;
import com.developcollect.commonnotify.NotifyContext;
import com.developcollect.commonnotify.config.IMessageTemplate;
import com.developcollect.commonnotify.exception.NotifyException;
import lombok.extern.slf4j.Slf4j;


/**
 * @author zak
 * @since 1.0.0
 */
@Slf4j
public abstract class AbstractNotify<N extends INotifyParameter, R extends INotifyResult> implements INotify<N, R> {

    @Override
    public R send(N notifyParameter) {
        // 参数校验
        validParameter(notifyParameter);

        // 初始化上下文
        NotifyContext context = NotifyContext.init(notifyParameter);

        // 获取消息模板
        IMessageTemplate messageTemplate = getMessageTemplate(context);

        // 处理消息标题和内容
        String title = processTitle(context, messageTemplate);
        String content = processContent(context, messageTemplate);

        // 发信
        log.debug("发送通知: 接受者:[{}], 标题:[{}], 内容:[{}]", notifyParameter.getTos(), title, content);
        return send(title, content, context);
    }

    protected abstract R send(String title, String content, NotifyContext context);

    protected void validParameter(N notifyParameter) {
        Assert.notBlank(notifyParameter.getTemplateSymbol(), "模板标识不能为空字符串");
        Assert.notEmpty(notifyParameter.getTos(), "通知目标不能为空");
    }

    protected IMessageTemplate getMessageTemplate(NotifyContext notifyContext) {
        INotifyParameter notifyParameter = notifyContext.getNotifyParameter();

        IMessageTemplate messageTemplate = notifyContext.getNotifyConfig()
                .getMessageTemplateFetcher()
                .apply(notifyParameter.getTemplateSymbol());

        if (messageTemplate == null) {
            throw new NotifyException("消息模板不存在: symbol: [{}]", notifyParameter.getTemplateSymbol());
        }

        return messageTemplate;
    }

    protected String processTitle(NotifyContext context, IMessageTemplate messageTemplate) {
        return context
                .getNotifyConfig()
                .getTitleProcessor()
                .apply(
                        messageTemplate, context.getNotifyParameter()
                );
    }

    protected String processContent(NotifyContext context, IMessageTemplate messageTemplate) {
        return context
                .getNotifyConfig()
                .getContentProcessor()
                .apply(
                        messageTemplate, context.getNotifyParameter()
                );
    }

}
