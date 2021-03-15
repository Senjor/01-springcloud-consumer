package com.test.templateprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TemplateProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateProviderApplication.class, args);
    }

}
