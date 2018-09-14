package com.michael.spring.cloud.client.feign.web;

import com.michael.spring.cloud.client.feign.web.feign.Service1TestFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * 微服务调用类
 * 如果直接由Controller调用，建议次 API 接口中定义的公用请求路径遵循一定的规则配置到类的 @RequestMapping 上
 * </pre>
 *
 * @author Michael
 * @date 2018/9/14.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private Service1TestFeignClient service1TestFeignClient;

    @GetMapping("/add/{a}/{b}")
    public String add(
            @PathVariable Integer a,
            @PathVariable Integer b
    ) {
        return "Feign Client Result : " + service1TestFeignClient.add(a, b);
    }
}
