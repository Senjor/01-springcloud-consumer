/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: MyFallback
 * @Author: laosun
 * @Date: 2021/3/15 6:39 下午
 * @Description: TODO
 */
package com.test.feignconsumer.hystrix;

import com.test.feignconsumer.model.User;
import com.test.feignconsumer.service.TestService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyFallback implements TestService {
    @Override
    public String test() {
        return "test 熔断了";
    }

    @Override
    public String testParams1(String name, Integer age) {
        return "test 熔断了";
    }

    @Override
    public String testParams2(User user) {
        return "test 熔断了";
    }

    @Override
    public User testReturnUser() {
        return null;
    }

    @Override
    public List<User> testReturnList() {
        return null;
    }
}
