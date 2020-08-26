package com.developcollect.commonnotify;

import java.io.Serializable;
import java.util.List;

/**
 * @author zak
 * @since 1.0.0
 */
public interface INotifyResult extends Serializable {

    int getNotifyType();

    List<SendResult> getSendResults();

}
