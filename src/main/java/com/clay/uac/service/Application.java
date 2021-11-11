package com.clay.uac.service;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lei
 * @date 10.11.21 4:31 下午
 */
@SpringBootApplication
@NacosPropertySource(dataId = "uac-service", autoRefreshed = true)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
