package com.developcollect.commonnotify;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zak
 * @version 1.0.0
 */
@Data
public class SendResult implements Serializable {

    /**
     * 消息id
     */
    private String messageId;

    /**
     * 发送者
     */
    private String sender;

    /**
     * 接收者
     */
    private String recipient;

    /**
     * 请求状态码
     */
    private String code;

    /**
     * 状态码的描述
     */
    private String codeDesc;


    /**
     * 是否请求成功
     * 注意: 这里只是表示发送请求是否成功
     *       第三方平台是否发送, 以及是否发送成功不做保证
     */
    private Boolean success;

}
