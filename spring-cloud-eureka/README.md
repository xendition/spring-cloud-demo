##Eureka 服务注册与发现(AP架构)
### 1. 单机版，直接运行
### 2. 群集版，添加启动参数 --spring.profiles.active=peer1/peer2/peer3 执行多次
### 3. 注意事项：群集需要配置hosts
```text
    127.0.0.1   peer1
    127.0.0.1   peer2
    127.0.0.1   peer3
```
