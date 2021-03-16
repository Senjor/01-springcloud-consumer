package com.test.eurekaclientzuulconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZuulConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulConsumerApplication.class, args);
    }

}
