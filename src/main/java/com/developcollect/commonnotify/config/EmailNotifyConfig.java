package com.developcollect.commonnotify.config;

import cn.hutool.extra.mail.MailAccount;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.function.Supplier;

/**
 * @author zak
 * @version 1.0.0
 */
@Data
@Accessors(chain = true)
public class EmailNotifyConfig extends AbstractNotifyConfig {

    private Supplier<MailAccount> mailAccountSupplier;

}
