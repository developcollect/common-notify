package com.developcollect.commonnotify.notify;

import com.developcollect.commonnotify.IEmailMessageTemplate;
import com.developcollect.commonnotify.IMessageTemplate;
import com.developcollect.commonnotify.utils.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

/**
 * 邮件通知
 *
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/5/31 14:34
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Slf4j
class EmailNotify extends AbstractNotify {

    @Override
    protected void send(String title, String notifyContent, Collection<String> targets) {
        MailUtil.sendHtml(targets, title, notifyContent);
    }

    @Override
    protected String fetchTemplateFromIMessageTemplate(IMessageTemplate messageTemplate) {
        if (messageTemplate instanceof IEmailMessageTemplate) {
            return ((IEmailMessageTemplate) messageTemplate).getEmailTemplate();
        } else {
            throw new IllegalArgumentException("不支持的模板类型");
        }
    }

    @Override
    protected String fetchTitleFromIMessageTemplate(IMessageTemplate messageTemplate) {
        if (messageTemplate instanceof IEmailMessageTemplate) {
            return ((IEmailMessageTemplate) messageTemplate).getEmailTitle();
        } else {
            throw new IllegalArgumentException("不支持的模板类型");
        }
    }
}
