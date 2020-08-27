package com.developcollect.commonnotify.notify.email;

import cn.hutool.extra.mail.MailAccount;
import com.developcollect.commonnotify.NotifyContext;
import com.developcollect.commonnotify.SendResult;
import com.developcollect.commonnotify.notify.AbstractNotify;
import com.developcollect.commonnotify.utils.email.EmailUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zak
 * @since 1.0.0
 */
@Slf4j
public class EmailNotify extends AbstractNotify<EmailNotifyParameter, EmailNotifyResult> {


    @Override
    protected EmailNotifyResult send(NotifyContext context) {
        EmailNotifyConfig notifyConfig = context.getNotifyConfig();
        EmailNotifyParameter notifyParameter = context.getNotifyParameter();

        // 邮箱认证配置
        MailAccount mailAccount = notifyConfig.getMailAccountSupplier().get();

        // 邮件发送只有一个messageId, 发信方法调用成功了就说明投送成功了
        // 对方是否收到还要取决于邮箱平台是否拦截过滤等等
        String messageId = EmailUtil.sendHtml(
                mailAccount,
                notifyParameter.getTos(), notifyParameter.getCcs(), notifyParameter.getBccs(),
                processTitle(context), processContent(context), notifyParameter.getResources()
        );

        // 创建通知结果
        EmailNotifyResult notifyResult = buildNotifyResult(notifyParameter, mailAccount, messageId);
        return notifyResult;
    }


    protected static EmailNotifyResult buildNotifyResult(EmailNotifyParameter notifyParameter, MailAccount mailAccount, String messageId) {
        EmailNotifyResult result = new EmailNotifyResult();
        result.setRawResult(messageId);

        List<SendResult> sendResults = notifyParameter.getTos().stream().map(to -> {
            SendResult sendResult = new SendResult();
            sendResult.setMessageId(messageId);
            sendResult.setSender(mailAccount.getFrom());
            sendResult.setRecipient(to);
            sendResult.setSuccess(true);
            sendResult.setCode("OK");
            sendResult.setCodeDesc("OK");
            return sendResult;
        }).collect(Collectors.toList());

        result.setSendResults(sendResults);
        return result;
    }


}
