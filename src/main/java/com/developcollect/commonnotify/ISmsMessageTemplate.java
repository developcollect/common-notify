package com.developcollect.commonnotify;

/**
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/5/31 15:02
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
public interface ISmsMessageTemplate extends IMessageTemplate {

    /**
     * 获取短信模板
     */
    String getSmsTemplate();

}
