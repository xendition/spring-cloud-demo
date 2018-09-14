package com.michael.spring.cloud.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * API设计
 * 接口类上不要加 @RequestMapping,把需要加的请求路径放置到方法注解的 @RequestMapping
 *
 * @author Michael
 * @date 2018/9/14.
 */
public interface TestApi {

    /**
     * 整数相加运算
     *
     * @param a 加数
     * @param b 被加数
     * @return 运算结果
     */
    @RequestMapping(value = "/test/add/{a}/{b}", method = RequestMethod.GET)
    String add(@PathVariable("a") Integer a, @PathVariable("b") Integer b);
}
