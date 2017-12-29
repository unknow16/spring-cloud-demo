package com.fuyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/12/29 0029.
 */
@RestController
public class DcController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc() {

        //choose会负载均衡的选出一个实例
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-provider");

        //拼接访问url
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";

        //使用restTemplate请求数据
        return restTemplate.getForObject(url, String.class);
    }
}
