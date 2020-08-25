package com.sanshao.basic.springbootbasic.damon;


import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
public class ScheduleService{

    @Scheduled(fixedDelay = 30000)
    public void task1() {
        System.out.println("This is Task1");
    }

    @Scheduled(fixedRate = 10000)
    public void task2() {
        System.out.println("This is Task2");
    }
}
