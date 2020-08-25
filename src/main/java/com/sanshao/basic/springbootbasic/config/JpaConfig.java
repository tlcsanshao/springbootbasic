package com.sanshao.basic.springbootbasic.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:mysql.properties")
public class JpaConfig {
    //添加这个类，主要用来指定配置文件
}
