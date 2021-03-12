/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: TestController
 * @Author: laosun
 * @Date: 2021/3/10 10:07 上午
 * @Description: TODO
 */
package com.test.springcloudconsumer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test(){

//      通过RestTemplate完成服务间的调用
//        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8081/hello", String.class);

        System.out.println(entity.getStatusCode());
        System.out.println(entity.getHeaders());


        return "consumer..." + entity.getBody();
    }


}
