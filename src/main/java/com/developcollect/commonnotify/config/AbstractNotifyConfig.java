package com.developcollect.commonnotify.config;

import lombok.Data;

import java.util.function.Function;

/**
 * @author Zhu Kaixiao
 * @version 1.0
 * @date 2020/8/24 14:57
 * @copyright 江西金磊科技发展有限公司 All rights reserved. Notice
 * 仅限于授权后使用，禁止非授权传阅以及私自用于商业目的。
 */
@Data
public abstract class AbstractNotifyConfig {

    private Function<String, IMessageTemplate> messageTemplateFetcher;

    private Function<IMessageTemplate, String> titleProcessor;

    private Function<IMessageTemplate, String> contentProcessor;

}
