/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: TestController
 * @Author: laosun
 * @Date: 2021/3/10 3:19 下午
 * @Description: TODO
 */
package com.test.eurekaclienthystrixprovider.controller;

import com.test.eurekaclienthystrixprovider.model.User;
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


    @GetMapping("/testParams1")
    public String testParams1(String name,Integer age){

        return "带参数 hystrix provider hello  8086" + name + "  age：" + age;
    }

    @RequestMapping("/testParams2")
    public String testParams2(@RequestBody User user){

        return "带参数 User hystrix provider hello 8086 " + user.getName() + "  age：" + user.getAge();
    }


    @RequestMapping("/testReturnUser")
    public Object testReturnUser(){

        User lisi = new User(1L, "lisi", 100);

        return lisi;
    }


    @RequestMapping("/testReturnList")
    public Object testReturnList(){

        User lisi = new User(1L, "lisi", 100);

        User lisi1 = new User(11L, "lisi11", 1001);

        ArrayList list = new ArrayList();
        list.add(lisi);
        list.add(lisi1);

        return list;
    }
}

