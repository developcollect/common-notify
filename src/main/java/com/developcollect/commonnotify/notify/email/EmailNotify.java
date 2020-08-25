package com.developcollect.commonnotify.notify.email;

import cn.hutool.extra.mail.MailAccount;
import com.developcollect.commonnotify.NotifyContext;
import com.developcollect.commonnotify.NotifyResult;
import com.developcollect.commonnotify.config.EmailNotifyConfig;
import com.developcollect.commonnotify.notify.AbstractNotify;
import com.developcollect.commonnotify.utils.email.EmailUtil;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zak
 * @since 1.0.0
 */
public class EmailNotify extends AbstractNotify {


    @Override
    protected NotifyResult send(String title, String content, Collection<String> targets) {
        NotifyContext context = NotifyContext.currContext();
        EmailNotifyConfig notifyConfig = context.getNotifyConfig();
        MailAccount mailAccount = notifyConfig.getMailAccountSupplier().get();
        EmailNotifyParameter notifyParameter = context.getNotifyParameter();

        // 邮件发送只有一个messageId, 发信方法调用成功了就说明投送成功了
        // 对方是否收到还要取决于邮箱平台是否拦截过滤等等
        String messageId = EmailUtil.sendHtml(mailAccount, notifyParameter.getTos(), notifyParameter.getCcs(), notifyParameter.getBccs(),
                title, content, notifyParameter.getResource());

        NotifyResult notifyResult = buildResult(notifyParameter, mailAccount, messageId);
        return notifyResult;
    }

    private static NotifyResult buildResult(EmailNotifyParameter notifyParameter, MailAccount mailAccount, String messageId) {
        NotifyResult result = new NotifyResult();
        List<NotifyResult.SendResult> sendResults = notifyParameter.getTos().stream().map(to -> {
            NotifyResult.SendResult sendResult = new NotifyResult.SendResult();
            sendResult.setMessageId(messageId);
            sendResult.setSender(mailAccount.getFrom());
            sendResult.setRecipient(to);
            sendResult.setSuccess(true);
            return sendResult;
        }).collect(Collectors.toList());
        result.setSendResults(sendResults);
        return result;
    }
}
