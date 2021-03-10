/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: TestController
 * @Author: laosun
 * @Date: 2021/3/10 3:19 下午
 * @Description: TODO
 */
package com.test.eurekaclientconsumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("test")
    public String test(){

//      通过RestTemplate完成服务间的调用
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8083/hello", String.class);
//       注册到eureka中，使用服务名来访问（服务名在注册中心 代表ip+端口号），但是会报错

        ResponseEntity<String> entity = restTemplate.getForEntity("http://02-EUREKA-CLIENT-PROVIDER/hello", String.class);


        System.out.println(entity.getStatusCode());
        System.out.println(entity.getHeaders());


        return "eureka client consumer..." + entity.getBody();
    }
}

