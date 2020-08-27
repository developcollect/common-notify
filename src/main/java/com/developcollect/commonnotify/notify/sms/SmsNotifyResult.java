package com.developcollect.commonnotify.notify.sms;

import com.developcollect.commonnotify.BaseNotifyResult;
import com.developcollect.commonnotify.NotifyTypes;
import lombok.Data;
import lombok.ToString;


/**
 * @author zak
 * @version 1.0.0
 */
@Data
@ToString(callSuper = true)
public class SmsNotifyResult extends BaseNotifyResult {

    @Override
    public int getNotifyType() {
        return NotifyTypes.SMS;
    }
}
