package com.developcollect.commonnotify;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TextTemplateTest {


    @Test
    public void test2() {
        String t = "模板测试{13},{13aaa}, {{code}}, {a{b}c}  {ab}{cc}  {order_code}, {orderCode}, {orderCode12}, {orderCode12&*} \n哈塞京 {code},";
        TextTemplate st = TextTemplate.compile(t);
        Map<String, String> val = new HashMap<>();
        val.put("code", "1");
        val.put("order_code", "ijvoiakfvio2389aksjd2j");
        val.put("orderCode", "jkaskdjflww");
        val.put("orderCode12", "hahahha");
        System.out.println(st.mold(val, false));
    }

}
