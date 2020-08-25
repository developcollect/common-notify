package com.developcollect.commonnotify.utils.email;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailException;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.FileTypeMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

/**
 * 邮件发送工具类
 * @author zak
 * @version 1.0.0
 */
public class EmailUtil extends cn.hutool.extra.mail.MailUtil {

    /**
     * 发送邮件给多人
     *
     * @param mailAccount 邮件帐户信息
     * @param to          收件人列表
     * @param subject     标题
     * @param content     正文
     * @param resources   附件列表
     * @return message-id
     * @since 4.6.3
     */
    public static String sendHtml(MailAccount mailAccount, String to, String subject, String content, Collection<Resource> resources) {
        return send(mailAccount, false, Collections.singletonList(to), Collections.emptyList(), Collections.emptyList(), subject, content, Collections.emptyMap(), true, resources);
    }

    /**
     * 发送邮件给多人
     *
     * @param mailAccount 邮件帐户信息
     * @param tos         收件人列表
     * @param subject     标题
     * @param content     正文
     * @param resources   附件列表
     * @return message-id
     * @since 4.6.3
     */
    public static String sendHtml(MailAccount mailAccount, Collection<String> tos, String subject, String content, Collection<Resource> resources) {
        return send(mailAccount, false, tos, Collections.emptyList(), Collections.emptyList(), subject, content, Collections.emptyMap(), true, resources);
    }

    /**
     * 发送邮件给多人
     *
     * @param mailAccount 邮件帐户信息
     * @param tos         收件人列表
     * @param ccs         抄送人列表，可以为null或空
     * @param bccs        密送人列表，可以为null或空
     * @param subject     标题
     * @param content     正文
     * @param resources   附件列表
     * @return message-id
     * @since 4.6.3
     */
    public static String sendHtml(MailAccount mailAccount, Collection<String> tos, Collection<String> ccs, Collection<String> bccs, String subject, String content,
                                  Collection<Resource> resources) {
        return send(mailAccount, false, tos, ccs, bccs, subject, content, Collections.emptyMap(), true, resources);
    }

    /**
     * 发送邮件给多人
     *
     * @param mailAccount 邮件帐户信息
     * @param tos         收件人列表
     * @param subject     标题
     * @param content     正文
     * @param isHtml      是否为HTML格式
     * @param resources   附件列表
     * @return message-id
     * @since 4.6.3
     */
    public static String send(MailAccount mailAccount, Collection<String> tos, String subject, String content,
                              boolean isHtml, Collection<Resource> resources) {
        return send(mailAccount, false, tos, Collections.emptyList(), Collections.emptyList(), subject, content, Collections.emptyMap(), isHtml, resources);
    }


    /**
     * 发送邮件给多人
     *
     * @param mailAccount 邮件帐户信息
     * @param tos         收件人列表
     * @param subject     标题
     * @param content     正文
     * @param imageMap    图片与占位符，占位符格式为cid:${cid}
     * @param isHtml      是否为HTML格式
     * @param resources   附件列表
     * @return message-id
     * @since 4.6.3
     */
    public static String send(MailAccount mailAccount, Collection<String> tos, String subject, String content,
                              Map<String, InputStream> imageMap, boolean isHtml, Collection<Resource> resources) {
        return send(mailAccount, false, tos, Collections.emptyList(), Collections.emptyList(), subject, content, imageMap, isHtml, resources);
    }

    /**
     * 发送邮件给多人
     *
     * @param mailAccount      邮件帐户信息
     * @param tos              收件人列表
     * @param ccs              抄送人列表，可以为null或空
     * @param bccs             密送人列表，可以为null或空
     * @param subject          标题
     * @param content          正文
     * @param imageMap         图片与占位符，占位符格式为cid:${cid}
     * @param isHtml           是否为HTML格式
     * @param resources            附件列表
     * @return message-id
     * @since 4.6.3
     */
    public static String send(MailAccount mailAccount, Collection<String> tos, Collection<String> ccs, Collection<String> bccs, String subject, String content,
                              Map<String, InputStream> imageMap, boolean isHtml, Collection<Resource> resources) {
        return send(mailAccount, false, tos, ccs, bccs, subject, content, imageMap, isHtml, resources);
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
     * @param resources            附件列表
     * @return message-id
     * @since 4.6.3
     */
    private static String send(MailAccount mailAccount, boolean useGlobalSession, Collection<String> tos, Collection<String> ccs, Collection<String> bccs, String subject, String content,
                               Map<String, InputStream> imageMap, boolean isHtml, Collection<Resource> resources) {
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

        // 附件
        setResources(mail, resources);


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


    private static void setResources(Mail mail, Collection<Resource> resources) {
        if (CollectionUtil.isEmpty(resources)) {
            return;
        }

        DataSource[] dataSources = resources.stream().map(resource -> {
            DataSource dataSource;
            if (resource instanceof FileSystemResource) {
                try {
                    dataSource = new FileDataSource(resource.getFile());
                } catch (IOException e) {
                    throw new MailException(e);
                }
            } else {
                ResourceDataHandler resourceDataHandler = new ResourceDataHandler(resource);
                dataSource = resourceDataHandler.getDataSource();
            }
            return dataSource;
        }).toArray(DataSource[]::new);

        mail.setAttachments(dataSources);
    }


    private static class ResourceDataHandler extends DataHandler {

        private Resource resource;

        public ResourceDataHandler(Resource resource) {
            super(resource, Optional
                    .ofNullable(FileTypeMap.getDefaultFileTypeMap().getContentType(resource.getFilename()))
                    .orElse("application/octet-stream"));
            this.resource = resource;
        }


        @Override
        public String getName() {
            return resource.getFilename();
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return resource.getInputStream();
        }
    }

}
