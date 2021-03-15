/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: TestController
 * @Author: laosun
 * @Date: 2021/3/10 3:19 下午
 * @Description: TODO
 */
package com.test.eurekaclienthystrixprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){

//        模拟服务异常，实现异常熔断
//        System.out.println(10/0);
        return "服务异常 hystrix provider hello  8086";
    }

    @GetMapping("/test1")
    public String test1(){

//        模拟服务延迟，实现异常熔断
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "服务延迟 hystrix provider hello  8086";
    }
}

