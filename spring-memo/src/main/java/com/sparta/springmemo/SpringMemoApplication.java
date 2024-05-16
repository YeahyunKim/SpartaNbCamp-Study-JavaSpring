package com.sparta.springmemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringMemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMemoApplication.class, args);
    }

}
