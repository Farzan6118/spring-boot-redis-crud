package com.example.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class DataRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataRedisApplication.class, args);
    }

}
