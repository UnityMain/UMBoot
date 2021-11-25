package com.unitymain.student.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

public class Demo3 {
    public static void main(String[] args) {
        HttpResponse execute = HttpRequest.get("https://www.bilibili.com/vi" +
                "deo/BV17y4y1j74g?spm_id_from=333" +
                ".851.b_62696c695f7265706f72745f74656368.6")
                .execute();
        System.out.println(execute.body());

    }
}
