package com.ty;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
@NacosPropertySource(dataId = "dubbo-web.properties", autoRefreshed = true)
//不指定的话默认取spring.application.name
public class DubboWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboWebApplication.class, args);
    }
}
