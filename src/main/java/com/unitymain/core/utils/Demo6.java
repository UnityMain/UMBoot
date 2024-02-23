package com.unitymain.core.utils;

import java.io.UnsupportedEncodingException;

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
