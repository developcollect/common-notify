package com.developcollect.commonnotify.notify;

import cn.hutool.core.lang.Assert;
import com.developcollect.commonnotify.INotifyResult;
import com.developcollect.commonnotify.NotifyContext;
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

        // 发信
        log.debug("发送通知: 接受者:[{}], 标题:[{}], 内容:[{}]", notifyParameter.getTos());
        return send(context);
    }

    protected abstract R send(NotifyContext context);

    protected void validParameter(N notifyParameter) {
        Assert.notBlank(notifyParameter.getTemplateSymbol(), "模板标识不能为空字符串");
        Assert.notEmpty(notifyParameter.getTos(), "通知目标不能为空");
    }

    protected String processTitle(NotifyContext context) {
        return context
                .getNotifyConfig()
                .getTitleProcessor()
                .apply(
                        context.getMessageTemplate(), context.getNotifyParameter()
                );
    }

    protected String processContent(NotifyContext context) {
        return context
                .getNotifyConfig()
                .getContentProcessor()
                .apply(
                        context.getMessageTemplate(), context.getNotifyParameter()
                );
    }

}
