/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: TestController
 * @Author: laosun
 * @Date: 2021/3/10 3:19 下午
 * @Description: TODO
 */
package com.test.templateprovider.controller;

import com.test.templateprovider.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/getForEntity")
    public User test(){
        return new User(1L, "zhangsan", 23);
    }
}

