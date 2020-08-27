package com.developcollect.commonnotify.notify.email;

import cn.hutool.core.util.ArrayUtil;
import com.developcollect.commonnotify.NotifyTypes;
import com.developcollect.commonnotify.notify.AbstractNotifyParameter;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.util.*;

/**
 * @author zak
 * @since 1.0.0
 */
@Data
@Accessors(chain = true)
public class EmailNotifyParameter extends AbstractNotifyParameter {

    /**
     * 抄送
     */
    private Collection<String> ccs;

    /**
     * 密送
     */
    private Collection<String> bccs;

    /**
     * 附件
     */
    private Collection<Resource> resources;

    @Override
    public int getNotifyType() {
        return NotifyTypes.EMAIL;
    }


    public static EmailNotifyParameter of(String templateSymbol, Map<String, String> vals, Collection<String> tos, Collection<String> ccs, Collection<String> bccs, Collection<Resource> resources) {
        EmailNotifyParameter emailNotifyParameter = new EmailNotifyParameter();
        emailNotifyParameter.setCcs(ccs);
        emailNotifyParameter.setBccs(bccs);
        emailNotifyParameter.setResources(resources);
        emailNotifyParameter.setTos(tos);
        emailNotifyParameter.setMessageTemplateValueMap(vals);
        emailNotifyParameter.setTemplateSymbol(templateSymbol);
        return emailNotifyParameter;
    }

    public static EmailNotifyParameter of(String templateSymbol, Map<String, String> vals, Collection<String> tos, Collection<String> ccs, Collection<String> bccs, Resource... resources) {
        return of(templateSymbol, vals, tos, ccs, bccs, ArrayUtil.isEmpty(resources) ? Collections.emptyList() : Arrays.asList(resources));
    }

    public static EmailNotifyParameter of(String templateSymbol, Map<String, String> vals, Collection<String> tos, Collection<String> ccs, Collection<Resource> resources) {
        return of(templateSymbol, vals, tos, ccs, Collections.emptyList(), resources);
    }

    public static EmailNotifyParameter of(String templateSymbol, Map<String, String> vals, Collection<String> tos, Collection<String> ccs, Resource... resources) {
        return of(templateSymbol, vals, tos, ccs, Collections.emptyList(), resources);
    }

    public static EmailNotifyParameter of(String templateSymbol, Map<String, String> vals, Collection<String> tos, Collection<Resource> resources) {
        return of(templateSymbol, vals, tos, Collections.emptyList(), Collections.emptyList(), resources);
    }

    public static EmailNotifyParameter of(String templateSymbol, Map<String, String> vals, Collection<String> tos, Resource... resources) {
        return of(templateSymbol, vals, tos, Collections.emptyList(), Collections.emptyList(), resources);
    }

    public static void main(String[] args) {
        String s = "";
        Map<String, String> vals = new HashMap<>();

        Collection<String> tos = new ArrayList<>();
        Collection<String> ccs = new ArrayList<>();
        Collection<String> bccs = new ArrayList<>();
        FileSystemResource resource1 = new FileSystemResource("");
        FileSystemResource resource2 = new FileSystemResource("");
        Collection<Resource> resources = new ArrayList<>();


        EmailNotifyParameter.of(s, vals, tos);
        EmailNotifyParameter.of(s, vals, tos, resource1, resource2);
        EmailNotifyParameter.of(s, vals, tos, resources);
        EmailNotifyParameter.of(s, vals, tos, ccs);
        EmailNotifyParameter.of(s, vals, tos, ccs, resource1, resource2);
        EmailNotifyParameter.of(s, vals, tos, ccs, resources);
        EmailNotifyParameter.of(s, vals, tos, ccs, bccs);
        EmailNotifyParameter.of(s, vals, tos, ccs, bccs, resource1, resource2);
        EmailNotifyParameter.of(s, vals, tos, ccs, bccs, resources);


    }
}
