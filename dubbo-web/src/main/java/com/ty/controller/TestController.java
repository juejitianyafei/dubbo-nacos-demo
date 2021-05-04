package com.ty.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.ty.api.RemoteService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class TestController {

    //dubbo最新注解
    @DubboReference(version = "1.0.0", timeout = 30000)
    private RemoteService remoteService;

    @NacosValue(value = "${nacos.ty.config.boolean:false}", autoRefreshed = true)
    private boolean useNacosConfig;

    @NacosValue(value = "${nacos.ty.config.string}", autoRefreshed = true)
    private String useNacosStringConfig;


    @GetMapping("/hello")
    public Object hello(String hi) {
        return remoteService.sayHello(hi);
    }

    @GetMapping("/config")
    public Object config() {
    	remoteService.sayHello("张三");
        System.out.println("nacos config boolean value is :" + useNacosConfig);
        System.out.println("nacos config string value is :" + useNacosStringConfig);
        return useNacosConfig;
    }


}
