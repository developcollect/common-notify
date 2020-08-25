package com.developcollect.commonnotify.config;

import com.developcollect.commonnotify.TextTemplate;
import com.developcollect.commonnotify.notify.NotifyParameter;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author zak
 * @version 1.0.0
 */
@Data
@Accessors(chain = true)
public abstract class AbstractNotifyConfig {

    private Function<String, IMessageTemplate> messageTemplateFetcher;

    private BiFunction<IMessageTemplate, NotifyParameter, String> titleProcessor =
            (messageTemplate, notifyParameter) -> TextTemplate.mold(messageTemplate.getTitle(), notifyParameter.getMessageTemplateValueMap());

    private BiFunction<IMessageTemplate, NotifyParameter, String> contentProcessor =
            (messageTemplate, notifyParameter) -> TextTemplate.mold(messageTemplate.getContent(), notifyParameter.getMessageTemplateValueMap());

}
