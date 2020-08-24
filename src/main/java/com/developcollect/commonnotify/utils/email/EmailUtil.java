package com.developcollect.commonnotify.utils.email;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.FileTypeMap;
import javax.activation.URLDataSource;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.Map;

/**
 * 邮件发送工具类
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/8/24 13:52
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public class EmailUtil extends cn.hutool.extra.mail.MailUtil {


    public void test() {
    }

    /**
     * 发送邮件给多人
     *
     * @param mailAccount      邮件帐户信息
     * @param useGlobalSession 是否全局共享Session
     * @param tos              收件人列表
     * @param ccs              抄送人列表，可以为null或空
     * @param bccs             密送人列表，可以为null或空
     * @param subject          标题
     * @param content          正文
     * @param imageMap         图片与占位符，占位符格式为cid:${cid}
     * @param isHtml           是否为HTML格式
     * @param files            附件列表
     * @return message-id
     * @since 4.6.3
     */
    private static String send(MailAccount mailAccount, boolean useGlobalSession, Collection<String> tos, Collection<String> ccs, Collection<String> bccs, String subject, String content,
                               Map<String, InputStream> imageMap, boolean isHtml, Resource... resources) {
        final Mail mail = Mail.create(mailAccount).setUseGlobalSession(useGlobalSession);

        // 可选抄送人
        if (CollUtil.isNotEmpty(ccs)) {
            mail.setCcs(ccs.toArray(new String[0]));
        }
        // 可选密送人
        if (CollUtil.isNotEmpty(bccs)) {
            mail.setBccs(bccs.toArray(new String[0]));
        }

        mail.setTos(tos.toArray(new String[0]));
        mail.setTitle(subject);
        mail.setContent(content);
        mail.setHtml(isHtml);

        DataSource[] a = new DataSource[1];
        for (Resource resource : resources) {
            if (resource instanceof FileSystemResource) {
                FileTypeMap.getDefaultFileTypeMap().getContentType("");
                FileDataSource fileDataSource = new FileDataSource(resource.getFile());
            } else {
                URL url = resource.getURL();
                URLDataSource urlDataSource = new URLDataSource();
                a[0] = urlDataSource;

            }
        }
        mail.setAttachments(a);

        // 图片
        if (MapUtil.isNotEmpty(imageMap)) {
            for (Map.Entry<String, InputStream> entry : imageMap.entrySet()) {
                mail.addImage(entry.getKey(), entry.getValue());
                // 关闭流
                IoUtil.close(entry.getValue());
            }
        }

        return mail.send();
    }

}
