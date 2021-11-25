package com.unitymain.student.cron;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class DemoCron {

//    @Scheduled(cron = "*/5 * * * * ? ")
    public void run() {
        System.out.println("你好吗？");
    }
}
