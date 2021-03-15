/**
 * @Copyright (C), 2013-2021, 德一集团
 * @FileName: TestService
 * @Author: laosun
 * @Date: 2021/3/15 2:46 下午
 * @Description: TODO
 */
package com.test.feignconsumer.service;

import com.test.feignconsumer.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//name后面指定的要远程调用的服务名称
@FeignClient(name = "06-EUREKA-CLIENT-HYSTRIX-PROVIDER")
//spring会为此接口生成动态代理对象
@Service
public interface TestService {

    @RequestMapping("/test")
    String test();

    @RequestMapping("/testParams1")
    String testParams1(@RequestParam String name,@RequestParam Integer age);

    @RequestMapping("/testParams2")
    String testParams2(@RequestBody User user);
}
