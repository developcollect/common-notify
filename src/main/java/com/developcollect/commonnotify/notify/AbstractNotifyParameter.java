package com.developcollect.commonnotify.notify;

import com.developcollect.dcinfra.utils.CollectionUtil;
import lombok.Data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zak
 * @since 1.0.0
 */
@Data
public abstract class AbstractNotifyParameter implements INotifyParameter {

    private String templateSymbol;

    private Collection<String> tos;

    private Map<String, String> messageTemplateValueMap;

    public void setTos(Collection<String> tos) {
        this.tos = CollectionUtil.distinct(tos);
    }

    public void setMessageTemplateValueMap(Map<String, String> messageTemplateValueMap) {
        this.messageTemplateValueMap = new HashMap<>(messageTemplateValueMap);
    }
}
