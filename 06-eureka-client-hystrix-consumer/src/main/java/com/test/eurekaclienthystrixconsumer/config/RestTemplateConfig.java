/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: RestTemplateConfig
 * @Author: laosun
 * @Date: 2021/3/10 10:35 上午
 * @Description: TODO
 */
package com.test.eurekaclienthystrixconsumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced  //用于标记当前的restTemplate 使用ribbon的负载均衡来访问服务的调用者，将来使用Feign来调用
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> list = new ArrayList<>();
        list.add((request, body, execution) -> {
            System.out.println("当前请求的URL是：" + request.getURI().toString());
            return execution.execute(request, body);
        });
        restTemplate.setInterceptors(list);

        return restTemplate;
    }

//  改变ribbon的默认负载均衡策略
    @Bean
    public IRule iRule(){
        return new RandomRule();
    }

}
