package com.unitymain.core;

import cn.hutool.http.HttpRequest;
import org.junit.jupiter.api.Test;

public class ManyThreadTest {

    public static void main(String[] args) {
        new ManyThreadTest().test17();
    }

    public void test17(){
        for(int i=0;i<20;i++){
            new Thread(()->{
                String s = this.myThread1();
                System.out.println(s);
            }).start();
        }
    }

    @Test
    public String myThread1(){
        String body = HttpRequest.get("http://127.0.0.1:8080/index")
                .execute().body();
        return body;
    }

}
