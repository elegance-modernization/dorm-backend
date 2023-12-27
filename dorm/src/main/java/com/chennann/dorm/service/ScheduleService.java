package com.chennann.dorm.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduleService {

    @Scheduled(cron = "0 0 0 L * ?")
    public void monthlyBillGenerator () {
        System.out.println("开始生成月账单");

    }

}
