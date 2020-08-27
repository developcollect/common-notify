package com.developcollect.commonnotify;

import com.developcollect.commonnotify.notify.INotify;

import java.io.Serializable;

/**
 * @author zak
 * @since 1.0.0
 */
public interface INotifyFactory extends Serializable {


    INotify create(int notifyType);

}
