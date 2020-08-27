package com.developcollect.commonnotify.notify.sms;

import com.developcollect.commonnotify.NotifyTypes;
import com.developcollect.commonnotify.notify.AbstractNotifyParameter;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zak
 * @since 1.0.0
 */
@Data
public class SmsNotifyParameter extends AbstractNotifyParameter {

    private Map<String, Object> extMap = new HashMap<>();

    @Override
    public int getNotifyType() {
        return NotifyTypes.SMS;
    }

    public void putExt(String key, Object val) {
        extMap.put(key, val);
    }

    public <T> T getExt(String key) {
        return (T) extMap.get(key);
    }

}
