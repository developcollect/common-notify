package com.developcollect.commonnotify.notify;

import java.io.Serializable;
import java.util.Collection;

/**
 * 参数
 *
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/8/24 16:16
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface NotifyParameter extends Serializable {

    /**
     * 通知类型
     */
    int getNotifyType();

    String getTemplateSymbol();

    Collection<String> getTos();
}
