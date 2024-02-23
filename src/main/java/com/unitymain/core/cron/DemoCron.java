package com.unitymain.core.cron;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class DemoCron {

//    @Scheduled(cron = "*/5 * * * * ? ")
    public void run() {
        System.out.println("你好吗？");
    }
}
