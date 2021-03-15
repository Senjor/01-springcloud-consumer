/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: TestController
 * @Author: laosun
 * @Date: 2021/3/10 3:19 下午
 * @Description: TODO
 */
package com.test.feignconsumer.controller;



import com.test.feignconsumer.model.User;
import com.test.feignconsumer.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class TestController {

    @Resource
    private TestService testService;

    @GetMapping("/test")
    public String test(){

        String test = testService.test();

        return "feign client consumer..." + test;
    }


    @GetMapping("/testParams1")
    public String testParams1(){

        String test = testService.testParams1("zhangsan",18);

        return "feign client consumer..." + test;
    }

    @RequestMapping("/testParams2")
    public String testParams2(){

        User user = new User();
        user.setName("laosun");
        user.setAge(20);

        String test = testService.testParams2(user);

        return "feign client consumer..." + test;
    }


    @RequestMapping("/testReturnUser")
    public String testReturnUser(){

        User user = testService.testReturnUser();

        return "feign client consumer..." + user.getName() + "   " + user.getAge();
    }

    @RequestMapping("/testReturnList")
    public String testReturnList(){

        List list = testService.testReturnList();

        return "feign client consumer..." +list;
    }

}

