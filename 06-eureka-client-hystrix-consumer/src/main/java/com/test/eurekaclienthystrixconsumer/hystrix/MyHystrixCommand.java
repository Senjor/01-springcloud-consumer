/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: MyHystrixCommand
 * @Author: laosun
 * @Date: 2021/3/13 2:14 下午
 * @Description: TODO
 */
package com.test.eurekaclienthystrixconsumer.hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;

/**
 * 自定义熔断器类
 */
public class MyHystrixCommand extends HystrixCommand {

    private RestTemplate restTemplate;
    private String url;

    public MyHystrixCommand(Setter setter,RestTemplate restTemplate,String url) {
        super(setter);
        this.restTemplate = restTemplate;
        this.url = url;
    }

//    spring会自动调用来访问我们的服务提供者
    @Override
    protected Object run() throws Exception {

        return restTemplate.getForObject(url,Object.class);
    }

//    服务降级方法
    @Override
    protected Object getFallback() {

        System.out.println(super.getFailedExecutionException().getClass());

        System.out.println(super.getFailedExecutionException().getMessage());

        return "自定义熔断器，熔断了服务";
    }
}
