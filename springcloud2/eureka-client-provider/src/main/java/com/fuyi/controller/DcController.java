package com.fuyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/29 0029.
 */
@RestController
public class DcController {

/*    @Autowired
    DiscoveryClient discoveryClient;*/

    @GetMapping("/dc")
    public String dc() {
        //String services = "Services: " + discoveryClient.getServices();
        System.out.println("provider");
        return "provider-v2";
    }

}
