package com.unitymain.student.utils;

import cn.hutool.core.util.HexUtil;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Demo5 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(HexUtil.encodeHex("ç”¨ç®±æ˜Žç»†", Charset.forName("UTF-8")));
        String a = HexUtil.decodeHexStr("c3a7e2809dc2a8c3a7c2aec2b1c3a6cb9cc5bdc3a7c2bbe280a0", Charset.forName("UTF-8"));
        String b = new String(a.getBytes("ISO-8859-1"),"UTF-8");

        System.out.println(a);
        System.out.println(b);
    }
}

