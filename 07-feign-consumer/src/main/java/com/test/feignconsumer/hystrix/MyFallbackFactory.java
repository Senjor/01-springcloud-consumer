/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: MyFallbackFactory
 * @Author: laosun
 * @Date: 2021/3/15 6:54 下午
 * @Description: TODO
 */
package com.test.feignconsumer.hystrix;

import com.test.feignconsumer.model.User;
import com.test.feignconsumer.service.TestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

//自定义异常熔断器类，实现降级回调接口，泛型指定为哪个接口实现熔断
@Component
public class MyFallbackFactory implements FallbackFactory<TestService> {
    @Override
    public TestService create(Throwable cause) {


        return new TestService() {
            @Override
            public String test() {
                System.out.println(cause.getMessage());
                System.out.println(cause.getClass());
                return "自定义异常熔断器  服务熔断了";
            }

            @Override
            public String testParams1(String name, Integer age) {
                return "自定义异常熔断器  服务熔断了";
            }

            @Override
            public String testParams2(User user) {
                return "自定义异常熔断器  服务熔断了";
            }

            @Override
            public User testReturnUser() {
                return null;
            }

            @Override
            public List<User> testReturnList() {
                return null;
            }
        };
    }
}
