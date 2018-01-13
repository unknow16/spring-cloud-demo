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
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/consumer")
    public String dc() {

        String url = "http://eureka-client-provider/dc";

        //使用restTemplate请求数据
        return restTemplate.getForObject(url, String.class);
    }


    @GetMapping("/loadBal")
    public void loadBal() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-provider");
        System.out.println("serviceId : " + serviceInstance.getServiceId() + "，port : " + serviceInstance.getPort() + "，Uri : " + serviceInstance.getUri());

        ServiceInstance serviceInstance2 = loadBalancerClient.choose("eureka-client-provider2");
        System.out.println("serviceId : " + serviceInstance2.getServiceId() + "，port : " + serviceInstance2.getPort() + "，Uri : " + serviceInstance2.getUri());

    }
}
