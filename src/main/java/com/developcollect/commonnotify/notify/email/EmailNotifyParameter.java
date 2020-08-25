package com.developcollect.commonnotify.notify.email;

import com.developcollect.commonnotify.NotifyTypes;
import com.developcollect.commonnotify.notify.BaseNotifyParameter;
import lombok.Data;
import org.springframework.core.io.Resource;

import java.util.Collection;

/**
 * @author zak
 * @since 1.0.0
 */
@Data
public class EmailNotifyParameter extends BaseNotifyParameter {

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
    private Collection<Resource> resource;

    @Override
    public int getNotifyType() {
        return NotifyTypes.EMAIL;
    }

}
