package com.michael.spring.cloud.client.feign.web.feign;

import com.michael.spring.cloud.api.TestApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

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
@FeignClient("spring-cloud-service-1")
public interface Service1TestFeignClient extends TestApi {
}
