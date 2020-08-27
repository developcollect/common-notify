package com.developcollect.commonnotify.notify.sms;

import com.developcollect.commonnotify.BaseNotifyResult;
import com.developcollect.commonnotify.NotifyTypes;
import com.developcollect.commonnotify.SendResult;
import lombok.Data;

import java.util.List;


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


    public static SmsNotifyResult of(List<SendResult> sendResultList) {
        SmsNotifyResult smsNotifyResult = new SmsNotifyResult();
        smsNotifyResult.setSendResults(sendResultList);
        return smsNotifyResult;
    }
}
