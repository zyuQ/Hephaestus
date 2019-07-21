package com.zyu.zeus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ZeusBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZeusBackEndApplication.class, args);
    }

}
