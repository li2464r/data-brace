package com.racacia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.racacia.middleware", "com.racacia.repository", "com.racacia.regular"})
public class RegularApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegularApplication.class, args);
    }
}
