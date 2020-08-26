package com.developcollect.commonnotify.notify;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * 参数
 *
 * @author zak
 * @since 1.0.0
 */
public interface INotifyParameter extends Serializable {

    /**
     * 通知类型
     */
    int getNotifyType();

    /**
     * 模板标识
     */
    String getTemplateSymbol();

    /**
     * 接收者
     */
    Collection<String> getTos();

    /**
     * 模板变量
     */
    Map<String, String> getMessageTemplateValueMap();
}
