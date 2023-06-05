package com.assign;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//@MapperScan(basePackages = "com.assign.entrance.mapper")
public class EntranceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EntranceApplication.class);
    }
}
