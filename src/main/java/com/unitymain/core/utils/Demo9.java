package com.unitymain.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo9 {
    public static void main(String[] args) {
        String input = "FIX:put,place,position,FIX:dispose,remove,FIX:stick,FIX:dislodge";
        Pattern pattern = Pattern.compile("(?i)fix:(.+?)(?=fix:|$)");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}
