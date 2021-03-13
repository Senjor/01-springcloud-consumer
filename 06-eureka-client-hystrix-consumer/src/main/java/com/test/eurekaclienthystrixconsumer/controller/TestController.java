/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: TestController
 * @Author: laosun
 * @Date: 2021/3/10 3:19 下午
 * @Description: TODO
 */
package com.test.eurekaclienthystrixconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    /***
     * HystrixCommand 标记当前控制器方法启用hystrix熔断机制，当调用远程服务时，如果服务出现异常或超时（指定时间没有返回响应），会自动进行熔断
     * @return
     */
    @HystrixCommand(fallbackMethod = "error")//指定本地回调方法名称，服务熔断后，执行该方法来替代服务提供者的响应信息
    @GetMapping("/test")
    public String test(){
        ResponseEntity<String> entity = restTemplate.getForEntity("http://06-EUREKA-CLIENT-HYSTRIX-PROVIDER/test", String.class);

//      put方法用于修改，因为调用时没有返回值，所以不清楚本地调用是否成功，所以非必要情况下不建议使用put方法。
//      restTemplate.put();
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getHeaders());


        return "hystrix client consumer..." + entity.getBody();
    }

    /*
    * 服务降级方法
    * */
    public String error(Throwable throwable){

//       异常信息打印
//        System.out.println(throwable.getMessage());
        log.info(throwable.getMessage());


        return "服务熔断了";
    }


//   熔断属性设置超时时间1.5s 默认是1s
    @HystrixCommand(fallbackMethod = "error",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    @GetMapping("/test1")
    public String test1(){
        ResponseEntity<String> entity = restTemplate.getForEntity("http://06-EUREKA-CLIENT-HYSTRIX-PROVIDER/test1", String.class);


        System.out.println(entity.getStatusCode());
        System.out.println(entity.getHeaders());


        return "延时 hystrix client consumer..." + entity.getBody();
    }

}

