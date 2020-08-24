package com.developcollect.commonnotify.notify.email;

import com.developcollect.commonnotify.NotifyTypes;
import com.developcollect.commonnotify.notify.BaseNotifyParameter;
import lombok.Data;
import org.springframework.core.io.Resource;

import java.util.Collection;
import java.util.List;

/**
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/8/24 16:19
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
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
    private List<Resource> resource;

    @Override
    public int getNotifyType() {
        return NotifyTypes.EMAIL;
    }

}
