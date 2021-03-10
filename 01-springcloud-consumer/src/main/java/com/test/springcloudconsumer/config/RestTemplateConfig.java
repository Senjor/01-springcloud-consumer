/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: RestTemplateConfig
 * @Author: laosun
 * @Date: 2021/3/10 10:35 上午
 * @Description: TODO
 */
package com.test.springcloudconsumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
