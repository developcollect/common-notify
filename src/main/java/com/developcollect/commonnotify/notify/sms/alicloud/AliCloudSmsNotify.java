package com.developcollect.commonnotify.notify.sms.alicloud;

import com.aliyuncs.CommonResponse;
import com.developcollect.commonnotify.config.NotifyGlobalConfig;
import com.developcollect.commonnotify.notify.INotify;
import com.developcollect.commonnotify.notify.sms.SmsNotifyConfig;
import com.developcollect.commonnotify.notify.sms.SmsNotifyParameter;
import com.developcollect.commonnotify.notify.sms.SmsNotifyResult;
import com.developcollect.commonnotify.utils.sms.AliCloudSmsUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * 阿里云短信通知
 */
@Slf4j
public class AliCloudSmsNotify implements INotify<SmsNotifyParameter, SmsNotifyResult> {

    /**
     * 阿里云短信发送
     * https://help.aliyun.com/document_detail/101414.html?spm=a2c4g.11186623.2.13.27af3e2cVWQqXz
     *
     * @param notifyParameter
     */
    @Override
    public SmsNotifyResult send(SmsNotifyParameter notifyParameter) {
        SmsNotifyConfig notifyConfig = NotifyGlobalConfig.getInstance().getNotifyConfig(notifyParameter.getNotifyType());
        // 平台参数配置
        Map<String, Object> smsPlatformConfigMap = notifyConfig.getSmsPlatformConfigMap();
        String regionId = smsPlatformConfigMap.get("regionId").toString();
        String accessKeyId = smsPlatformConfigMap.get("accessKeyId").toString();
        String accessSecret = smsPlatformConfigMap.get("accessSecret").toString();

        CommonResponse response = AliCloudSmsUtil.send(
                regionId, accessKeyId, accessSecret,
                notifyParameter.getTos(), "",
                notifyParameter.getTemplateSymbol(), notifyParameter.getMessageTemplateValueMap(),
                ""
        );
        return null;
    }

}
