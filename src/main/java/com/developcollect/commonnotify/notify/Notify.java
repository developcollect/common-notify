package com.developcollect.commonnotify.notify;

import com.developcollect.commonnotify.NotifyResult;

import java.io.Serializable;

/**
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/5/31 14:31
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface Notify extends Serializable {

    /**
     * 发送通知到指定的目标
     * 1. 使用配置的模板提取器获取模板标识所代表的模板
     * 2. 将变量值填充到模板, 生成消息文本
     * 3. 发送通知消息
     *
     * @param notifyParameter 通知参数
     * @return 通知结果
     * @author Zhu Kaixiao
     * @date 2020/8/24 14:32
     */
    NotifyResult send(NotifyParameter notifyParameter);
}
