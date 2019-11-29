package com.ywf.srpingbootproject.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TestSchedule {

    @Scheduled(cron = "0/1 * * * * ?")
    public void test() {
        System.out.println("time is " + new Date());
    }
}
