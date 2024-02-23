package com.unitymain.core.utils;

import javax.naming.Context;
import javax.naming.InitialContext;

public class RecursionExample {
    public static void main(String[] args) throws Exception {
        Context ctx = new InitialContext();
        Object obj = ctx.lookup("somename");

    }

}