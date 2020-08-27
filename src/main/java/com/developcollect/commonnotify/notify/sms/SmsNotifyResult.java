package com.developcollect.commonnotify.notify.sms;

import com.developcollect.commonnotify.BaseNotifyResult;
import com.developcollect.commonnotify.NotifyTypes;
import lombok.Data;



/**
 * @author zak
 * @version 1.0.0
 */
@Data
public class SmsNotifyResult extends BaseNotifyResult {

    @Override
    public int getNotifyType() {
        return NotifyTypes.SMS;
    }
}
