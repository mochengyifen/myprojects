package com.zhhong.mochen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhhong.mochen.mapper")
public class MochenManagerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MochenManagerWebApplication.class, args);
    }

}
