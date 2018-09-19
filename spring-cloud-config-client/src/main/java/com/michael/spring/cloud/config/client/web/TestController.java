package com.michael.spring.cloud.config.client.web;

import com.michael.spring.cloud.api.TestApi;
import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * 简单服务提供者，此处不需要添加 @RequestMapping ,由接口统一处理
 * 注解 @RefreshScope 需要放置 @RestController 下面
 * 配置文件更新(git方式)分2步：
 *      1. 提交最新的配置文件至git远程仓库
 *      2. 访问ConfigServer 的请求/actuator/refresh(POST方式)
 * </pre>
 *
 * @author Michael
 * @date 2018/9/13.
 */
@RestController
@RefreshScope
public class TestController implements TestApi {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * Eureka 相关的配置数据都可以在 EurekaInstanceConfig 中找到结果,比 DiscoveryClient 数据更全
     */
    @Autowired
    private EurekaInstanceConfig config;

    @Value("${client.value}")
    private String value;

    @Override
    public String add(
            @PathVariable Integer a,
            @PathVariable Integer b
    ) {

        Integer r = a + b;

        Integer port = config.getNonSecurePort();
        String host = config.getHostName(true);

        // serverId 就是 appName
        String serverId = config.getAppname();

        logger.info("/add, host:{}, service_id:{}, port:{}, result:{}", host, serverId, port, r);
        return "From spring-cloud-config-client:" + port + ", Result is " + r + " value:" + value;
    }
}
