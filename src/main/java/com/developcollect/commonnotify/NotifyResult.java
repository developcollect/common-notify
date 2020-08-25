package com.developcollect.commonnotify;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zak
 * @since 1.0.0
 */
@Data
public class NotifyResult implements Serializable {


    private List<SendResult> sendResults;


    @Data
    public static class SendResult {
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

}
