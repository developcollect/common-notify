package com.developcollect.commonnotify;

import cn.hutool.core.util.ReflectUtil;
import cn.hutool.extra.mail.MailAccount;
import com.developcollect.commonnotify.config.IMessageTemplate;
import com.developcollect.commonnotify.config.NotifyGlobalConfig;
import com.developcollect.commonnotify.notify.email.EmailNotifyConfig;
import com.developcollect.commonnotify.notify.sms.SmsNotifyConfig;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class NotifyUtilTest {

    private Map<String, IMessageTemplate> messageTemplateMap = new HashMap<>();


    public void initTemplateMap() {
        messageTemplateMap.put("e1", new IMessageTemplate() {
            @Override
            public String getTitle() {
                return "请假条";
            }

            @Override
            public String getContent() {
                return "请假1天";
            }
        });

        messageTemplateMap.put("e2", new IMessageTemplate() {
            @Override
            public String getTitle() {
                return "e2-邮件标题 ${tp}";
            }

            @Override
            public String getContent() {
                return "e1-正文 ==> \n验证码: ${code}";
            }
        });
    }

    @Before
    public void bb() {
        initTemplateMap();


        EmailNotifyConfig emailNotifyConfig = new EmailNotifyConfig();
        emailNotifyConfig
                .setMailAccountSupplier(() -> {
                    MailAccount mailAccount = new MailAccount();
                    mailAccount.setAuth(true);
                    mailAccount.setHost("smtp.qq.com");
                    mailAccount.setUser("1033160032@qq.com");
                    mailAccount.setPass("rqovrdfhdrfgbbfh");
                    mailAccount.setFrom("私人定制<1033160032@qq.com>");
                    return mailAccount;
                })
                .setMessageTemplateFetcher(t -> messageTemplateMap.get(t));

        SmsNotifyConfig smsNotifyConfig = new SmsNotifyConfig();
        smsNotifyConfig.setMessageTemplateFetcher(t -> messageTemplateMap.get(t));

        NotifyGlobalConfig notifyGlobalConfig = new NotifyGlobalConfig();
        notifyGlobalConfig.getNotifyConfigMap().put(NotifyTypes.EMAIL, () -> emailNotifyConfig);
        notifyGlobalConfig.getNotifyConfigMap().put(NotifyTypes.SMS, () -> smsNotifyConfig);
        ReflectUtil.invoke(notifyGlobalConfig, "init");

    }

    @Test
    public void sendEmail() {
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("code", "578846");
        valueMap.put("tp", "标题占位");


        INotifyResult notifyResult = NotifyUtil.sendEmail("e1", valueMap, "3617246657@qq.com");
        System.out.println(notifyResult);
    }

    @Test
    public void sendEmail1() {
    }

    @Test
    public void sendEmail2() {
    }

    @Test
    public void sendEmail3() {
    }

    @Test
    public void sendEmail4() {
    }

    @Test
    public void sendEmail5() {
    }
}