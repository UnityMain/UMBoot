package com.unitymain.student.utils;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

import javax.activation.DataHandler;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;

public class Demo6 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String a = "用箱明细";
        String b = null;
        String c = "ç\u0094¨ç®±æ\u0098\u008Eç»\u0086";
        String d = null;
        try {
           b = new String(a.getBytes("UTF-8"),"ISO8859-1");
//           d = new String(c.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(new String(b.getBytes("ISO-8859-1"),"ISO-8859-1"));
        System.out.println(new String(b.getBytes("ISO-8859-1"),"UTF-8"));
//        System.out.println(HexUtil.encodeHex(b,Charset.forName("UTF-8")));
        System.out.println(new String(c.getBytes("ISO-8859-1"),"UTF-8"));
    }
}
