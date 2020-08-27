package com.developcollect.commonnotify.config;

import java.io.Serializable;

/**
 * 消息模板
 *
 * @author zak
 * @version 1.0.0
 */
public interface IMessageTemplate extends Serializable {


    String getTitle();

    String getContent();

}
