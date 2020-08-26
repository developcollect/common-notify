package com.developcollect.commonnotify.config;


import cn.hutool.core.util.ReUtil;
import com.developcollect.commonnotify.TextTemplate;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zak
 * @version 1.0.0
 */
@Data
public class NotifyGlobalConfig {

    private Map<Integer, AbstractNotifyConfig> notifyConfigMap = new HashMap<>();

    /**
     * 模板变量正则表达式
     * 该表达式只匹配占位符中的变量名, 不含展位符起始和结束
     */
    private static String TEMPLATE_VALUE_REGEX = "[A-Za-z]+?[A-Za-z0-9_#@~!`%^&*=+/?><';:\\-]*?";
    /**
     * 模板变量占位符起始
     */
    private String placeholderBegin = "${";
    /**
     * 模板变量占位符结束
     */
    private String placeholderEnd = "}";


    private void init() {
        INSTANCE = this;

        // 设置模板占位符正则
        TextTemplate.setPlaceholderRegex(ReUtil.escape(placeholderBegin) + "(" + TEMPLATE_VALUE_REGEX + ")" + ReUtil.escape(placeholderEnd));
    }

    private static NotifyGlobalConfig INSTANCE;

    private static NotifyGlobalConfig getInstance() {
        return INSTANCE;
    }

    public static <T extends AbstractNotifyConfig> T getNotifyConfig(int notifyType) {
        return (T) getInstance().notifyConfigMap.get(notifyType);
    }

}
