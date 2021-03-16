/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: TestController
 * @Author: laosun
 * @Date: 2021/3/10 3:19 下午
 * @Description: TODO
 */
package com.test.eurekaclientzuulprovider.controller;


import com.test.eurekaclientzuulprovider.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){

//        模拟服务异常，实现异常熔断
//        System.out.println(10/0);
        return "zuul provider test  8101";
    }

    @GetMapping("/test1")
    public String test1(){

//        模拟服务延迟，实现异常熔断
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "zuul provider test1  8101";
    }


    @GetMapping("/test2")
    public String test2(){

        return "zuul provider test2  8101";
    }

}

