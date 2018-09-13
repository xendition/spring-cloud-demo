package com.michael.spring.cloud.service1.web;

import com.netflix.appinfo.EurekaInstanceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 简单服务
 *
 * @author Michael
 * @date 2018/9/13.
 */

@RestController
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private EurekaInstanceConfig config;

//    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @GetMapping("/add")
    public String add(@RequestParam Integer a, @RequestParam Integer b) {

        Integer r = a + b;

        Integer port = config.getNonSecurePort();
        String host = config.getHostName(true);

        // serverId 就是 appName
        String serverId = config.getAppname();

        logger.info("/add, host:{}, service_id:{}, port:{}, result:{}", host, serverId,port, r);
        return "From spring-cloud-service-1, Result is " + r;
    }
}
