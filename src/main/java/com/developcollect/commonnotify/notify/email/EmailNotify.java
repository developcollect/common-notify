package com.developcollect.commonnotify.notify.email;

import cn.hutool.extra.mail.MailAccount;
import com.developcollect.commonnotify.NotifyContext;
import com.developcollect.commonnotify.NotifyResult;
import com.developcollect.commonnotify.config.EmailNotifyConfig;
import com.developcollect.commonnotify.notify.AbstractNotify;
import com.developcollect.commonnotify.utils.email.EmailUtil;

import java.util.Collection;

/**
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/8/24 17:19
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class EmailNotify extends AbstractNotify {


    @Override
    protected NotifyResult send(String title, String content, Collection<String> targets) {
        NotifyContext context = NotifyContext.currContext();
        EmailNotifyConfig notifyConfig = context.getNotifyConfig();
        MailAccount mailAccount = notifyConfig.getMailAccountSupplier().get();
        EmailNotifyParameter notifyParameter = context.getNotifyParameter();
        EmailUtil.send(mailAccount, notifyParameter.getTos(), notifyParameter.getCcs(), notifyParameter.getBccs(), title, content, true);

        // todo  附件


        return null;
    }
}
