package com.developcollect.commonnotify;

import lombok.Data;

/**
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/8/26 16:13
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
public class SendResult {

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
     * 是否发送成功
     * 注意: 这里只是表示发送成功, 接收者并不一定接收成功
     */
    private Boolean success;

}
