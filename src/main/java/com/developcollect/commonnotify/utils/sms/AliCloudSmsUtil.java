package com.developcollect.commonnotify.utils.sms;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.developcollect.commonnotify.exception.SendException;
import com.developcollect.dcinfra.utils.SerializeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 阿里云短信发送工具类
 *
 * @author zak
 * @version 1.0.0
 */
@Slf4j
public class AliCloudSmsUtil {

    public static CommonResponse send(String regionId, String accessKeyId, String accessSecret, Collection<String> tos, String signName, String templateCode, Map<String, String> templateParam, String smsUpExtendCode) {
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", regionId);
        request.putQueryParameter("PhoneNumbers", StringUtils.join(tos, ","));
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", SerializeUtil.beanToJson(templateParam));
        if (StringUtils.isNotBlank(smsUpExtendCode)) {
            request.putQueryParameter("SmsUpExtendCode", smsUpExtendCode);
        }

        try {
            CommonResponse response = client.getCommonResponse(request);
            return response;
        } catch (Exception e) {
            throw new SendException(e);
        }
    }

}
