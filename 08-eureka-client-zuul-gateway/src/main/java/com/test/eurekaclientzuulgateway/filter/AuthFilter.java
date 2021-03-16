/**
 * @Copyright (C), 2013-2021 德一集团
 * @FileName: AuthFilter
 * @Author: laosun
 * @Date: 2021/3/16 4:48 下午
 * @Description: TODO
 */
package com.test.eurekaclientzuulgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义网关过滤器类 继承父类
 */
@Component
public class AuthFilter extends ZuulFilter {

//    决定过滤器类型
//    执行时机
//    pre 代表前置过滤器  通常做身份认证
    @Override
    public String filterType() {
        return "pre";
    }

//  过滤器序号  如果有多个过滤器，根据此返回值，决定执行顺序
    @Override
    public int filterOrder() {
        return 0;
    }
//  是否启用  true代表启用
    @Override
    public boolean shouldFilter() {
        return true;
    }

//   具体执行方法，返回值目前版本没有作用
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        String token = request.getParameter("token");

//       实际要从数据库中验证 合法性
        if (token == null || !"123".equals(token)){
//           请求不继续执行，不转发给服务提供者
            context.setSendZuulResponse(false);

//            401 或500代表权限不足
            context.setResponseStatusCode(401);
//            设置相应类型以及编码格式
            context.addZuulResponseHeader("content-type","text/html;charset=utf-8");

            context.setResponseBody("非法请求");
        }else {
            System.out.println("请求合法，继续执行请求，准备进入服务或下一个过滤器");
        }

        return null;
    }
}
