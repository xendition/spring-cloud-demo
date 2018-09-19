# spring-cloud-demo
Spring Cloud 学习用 Demo

## 模块说明
  1. spring-cloud-erueka  Eureka  服务器 (包含单机与集群模式)
  2. spring-cloud-api-1 定义了一组简单的微服务接口,用于微服务提供者、FeignClient继承用
  3. spring-cloud-service-1 简单的服务提供者，可配置不同端口运行多个节点
  4. spring-cloud-client-feign 使用feign的服务消费者，简单使用
  5. spring-cloud-client-feign-hystrix 使用feign的服务消费者，简单使用,增加熔断机制
  6. spring-cloud-admin-server spring-boot-admin 可视化管理,暂时感觉没什么鸟用。
  7. spring-cloud-zuul 网关,用于后台负载均衡、权限控制等
  8. spring-cloud-config-server 配置管理中心,用于集中管理各微服务节点的配置信息，如数据库配置。可以按不同的profile/git分支进行区分。
  9. spring-cloud-config-client 使用config-server作为配置管理的客户端示例(手动刷新方式)
  10. spring-cloud-nacos 阿里开发的中间件,集成了 eureka + config-server 的功能