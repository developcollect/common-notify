package com.developcollect.commonnotify;

import com.developcollect.commonnotify.notify.INotify;

/**
 * @author zak
 * @since 1.0.0
 */
public interface INotifyFactory {


    INotify create(int notifyType);

}
