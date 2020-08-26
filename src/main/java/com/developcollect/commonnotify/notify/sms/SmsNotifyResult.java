package com.developcollect.commonnotify.notify.sms;

import com.developcollect.commonnotify.BaseNotifyResult;
import com.developcollect.commonnotify.NotifyTypes;
import com.developcollect.commonnotify.SendResult;
import lombok.Data;

import java.util.List;


/**
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/8/26 16:39
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
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
