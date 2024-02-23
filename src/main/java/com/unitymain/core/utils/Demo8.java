package com.unitymain.core.utils;

import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.util.RandomUtil;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

public class Demo8 {
    public static void main(String[] args) {
        ThreadPoolExecutor build = ExecutorBuilder.create().setCorePoolSize(50)
                .setMaxPoolSize(100)
                .setWorkQueue(new LinkedBlockingDeque<>(500))
                .build();
        while (true){
            build.execute(new Thread(()->{
                new Demo8().startThread();
            }));
        }

    }

    public void startThread(){
        try {
            Thread.sleep(RandomUtil.randomInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("---------111");
    }
}
