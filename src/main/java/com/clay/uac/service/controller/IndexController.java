package com.clay.uac.service.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author lei
 * @date 10.11.21 4:34 下午
 */
@RestController
public class IndexController {

    @NacosValue(value = "${useLocalCache:true}", autoRefreshed = true)
    private Boolean useLocalCache;

    @NacosInjected
    private NamingService namingService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/config")
    public Boolean config() {
        return useLocalCache;
    }

    @GetMapping("/instances")
    public List<Instance> instances(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }
}
