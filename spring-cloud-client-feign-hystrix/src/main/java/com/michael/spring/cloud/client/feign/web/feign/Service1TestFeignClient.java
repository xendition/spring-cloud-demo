package com.michael.spring.cloud.client.feign.web.feign;

import com.michael.spring.cloud.api.TestApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 用于http请求服务的客户端
 * FeignClient 参数说明 {
 *     name : 注册到 Eureka 服务上的模块名称(微服务名称)
 * }
 * 命名规范说明：微服务名称简写+调用服务名+FeignClient
 * FeignClient 只需要继承API接口、配置好对应微服务的appName即可
 * </pre>
 *
 * @author Michael
 * @version 1.0.0
 * @date 2018/9/14
 */
@FeignClient(name = "spring-cloud-service-1", fallback = Service1TestHystrixClientFallback.class)
public interface Service1TestFeignClient extends TestApi {
}

@Component
class Service1TestHystrixClientFallback implements Service1TestFeignClient {

    private static Logger logger = LoggerFactory.getLogger(Service1TestHystrixClientFallback.class);

    @Override
    public String add(Integer a, Integer b) {
        logger.error("请求异常,进入 {}.{},请求参数 - {},{}", "Service1TestHystrixClientFallback", "add", a, b);
        return "请求异常！";
    }
}