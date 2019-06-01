package com.ty.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ty.api.RemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Service(version = "1.0.0",
        interfaceClass = RemoteService.class,
        retries = -1,
        timeout = 30000)
@Component
@Slf4j
public class RemoteServiceImpl implements RemoteService {


    @Override
    public String sayHello(String name) {
        return "to say hi:" + name;
    }
}
