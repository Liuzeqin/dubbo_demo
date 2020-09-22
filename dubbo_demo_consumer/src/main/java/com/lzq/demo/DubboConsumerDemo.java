package com.lzq.demo;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lzq.demo.service.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Method;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DubboConsumerDemo {
    //这里改为打印，不记录日志
//    private final Logger logger = LoggerFactory.getLogger(getClass());

    @DubboReference(
            version = "1.0.0",
            url = "dubbo://127.0.0.1:12345",
            timeout = 100,
            methods = {
                    @Method(name = "Hello", timeout = 300)
            })
    private DemoService demoService;

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerDemo.class).close();
    }

    @Bean
    public ApplicationRunner runner() {
        String res = demoService.Hello("lzq");
        return args -> {
            System.out.println(res);
        };
    }
}
