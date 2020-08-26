package com.developcollect.commonnotify.notify.sms;

import com.developcollect.commonnotify.NotifyTypes;
import com.developcollect.commonnotify.notify.AbstractNotifyParameter;
import lombok.Data;

/**
 * @author zak
 * @since 1.0.0
 */
@Data
public class SmsNotifyParameter extends AbstractNotifyParameter {

    @Override
    public int getNotifyType() {
        return NotifyTypes.SMS;
    }

}
