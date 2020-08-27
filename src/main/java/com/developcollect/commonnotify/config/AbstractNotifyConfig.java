package com.developcollect.commonnotify.config;

import com.developcollect.commonnotify.TextTemplate;
import com.developcollect.commonnotify.notify.INotifyParameter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author zak
 * @version 1.0.0
 */
@Data
@Accessors(chain = true)
public abstract class AbstractNotifyConfig implements Serializable {

    /**
     * 消息模板提取器
     */
    private Function<String, IMessageTemplate> messageTemplateFetcher;

    /**
     * 消息标题处理器
     */
    private BiFunction<IMessageTemplate, INotifyParameter, String> titleProcessor =
            (messageTemplate, notifyParameter) -> TextTemplate.mold(messageTemplate.getTitle(), notifyParameter.getMessageTemplateValueMap());

    /**
     * 消息内容处理器
     */
    private BiFunction<IMessageTemplate, INotifyParameter, String> contentProcessor =
            (messageTemplate, notifyParameter) -> TextTemplate.mold(messageTemplate.getContent(), notifyParameter.getMessageTemplateValueMap());

}
