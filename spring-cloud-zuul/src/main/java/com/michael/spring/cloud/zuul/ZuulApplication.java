package com.michael.spring.cloud.zuul;

import com.michael.spring.cloud.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * @author Michael
 * @date 2018/9/17.
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {

        SpringApplication.run(ZuulApplication.class, args);
    }

    /**
     * Token合法性验证过滤器
     */
    @Bean
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    /**
     * 如果请求有冲突，需要安排顺序，需要在这里处理
     *
     */
//    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper("", "");
    }
}
