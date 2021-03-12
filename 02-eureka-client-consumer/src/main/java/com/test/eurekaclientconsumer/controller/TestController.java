/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: TestController
 * @Author: laosun
 * @Date: 2021/3/10 3:19 下午
 * @Description: TODO
 */
package com.test.eurekaclientconsumer.controller;

import com.test.eurekaclientconsumer.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/template")
    public String template(){

//      String也可以改成User对象
        ResponseEntity<String> entity = restTemplate.getForEntity("http://02-EUREKA-CLIENT-PROVIDER/getForEntity", String.class);

        System.out.println(entity.getStatusCode());
        System.out.println(entity.getHeaders());

//      如果需要发送get请求传递参数时，需要使用getForEntity的重载方法，把参数传递到第三个参数中，比如
//        String url = "http://02-EUREKA-CLIENT-PROVIDER/getForEntity?id={id}&name={name}&age={age}";
//        Map<String,Object> params = new HashMap<>();
//        params.put("id",1L);
//        params.put("name","zhangsan");
//        params.put("age",18);
//        restTemplate.getForEntity(url, User.class,params);

        return "from template provider 8086..." + entity.getBody();
    }
}

