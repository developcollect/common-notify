package com.developcollect.commonnotify.utils.email;

import cn.hutool.extra.mail.MailAccount;
import org.junit.Test;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EmailUtilTest {

    @Test
    public void testSend() throws MalformedURLException {
        List<Resource> resources = new ArrayList<>();
        resources.add(new FileSystemResource("C:\\Users\\ASUS\\Pictures\\hxjpg\\v.f30.mp4"));
        resources.add(new UrlResource("https://csdnimg.cn/cdn/content-toolbar/csdn-logo.png?v=20200416.1"));
        resources.add(new UrlResource("https://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=2&pn=3&spn=0&di=2090&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=1906469856%2C4113625838&os=1062705421%2C520912533&simid=3285371631%2C209838447&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=%E5%9B%BE%E7%89%87&objurl=http%3A%2F%2Fa2.att.hudong.com%2F36%2F48%2F19300001357258133412489354717.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fp7rtwg_z%26e3Bkwthj_z%26e3Bv54AzdH3Ftrw1AzdH3Fwd_nm_9b_8lnaaaa8nc0dcb8nn98d9blnc9080_3r2_z%26e3Bip4s&gsm=3&islist=&querylist="));

        MailAccount mailAccount = new MailAccount();
        mailAccount.setAuth(true);
        mailAccount.setHost("smtp.qq.com");
        mailAccount.setUser("1033160032@qq.com");
        mailAccount.setPass("rqovrdfhdrfgbbfh");
        mailAccount.setFrom("私人定制<1033160032@qq.com>");

        String s = EmailUtil.sendHtml(mailAccount, Arrays.asList("3617246657@qq.com", "690710726@qq.com"), "主题", "内筒", resources);
        System.out.println(s);
    }

}