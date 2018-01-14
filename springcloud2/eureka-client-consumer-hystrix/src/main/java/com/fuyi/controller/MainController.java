package com.fuyi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by fuyi on 2018/1/13.
 */
@RestController
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "defaultAction",
            commandKey = "getUserById", groupKey = "UserGroup", threadPoolKey = "getUserByIdThread")
    @GetMapping("getUserById")
    public String getUserById() {
        String url = "http://eureka-client-provider/dc";

        //使用restTemplate请求数据
        return restTemplate.getForObject(url, String.class);
    }

    public String defaultAction() {
        return "fallback default";
    }
}


