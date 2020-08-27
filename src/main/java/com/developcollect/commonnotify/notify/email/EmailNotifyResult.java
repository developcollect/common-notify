package com.developcollect.commonnotify.notify.email;

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
public class EmailNotifyResult extends BaseNotifyResult {

    @Override
    public int getNotifyType() {
        return NotifyTypes.EMAIL;
    }

}
