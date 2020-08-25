package com.sanshao.basic.springbootbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootbasicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootbasicApplication.class, args);
    }

}
