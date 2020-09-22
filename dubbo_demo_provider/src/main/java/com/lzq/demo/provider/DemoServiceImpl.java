package com.lzq.demo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.lzq.demo.service.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0")
public class DemoServiceImpl implements DemoService {

    private final String serviceName = "dubbo_demo";

    public String Hello(String name) {
        return String.format("[%s]: Hello, %s", serviceName, name);
    }
}
