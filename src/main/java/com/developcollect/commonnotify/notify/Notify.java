package com.developcollect.commonnotify.notify;

import com.developcollect.commonnotify.NotifyResult;

import java.io.Serializable;

/**
 * @author zak
 * @version 1.0.0
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
     * @author zak
     * @date 2020/8/24 14:32
     */
    NotifyResult send(NotifyParameter notifyParameter);
}
