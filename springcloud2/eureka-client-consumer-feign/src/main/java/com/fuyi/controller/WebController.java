package com.fuyi.controller;

import com.fuyi.feign.DcClient;
import com.fuyi.feign.DcClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/29 0029.
 */
@RestController
public class WebController {

    @Autowired
    private DcClient dcClient;

    @Autowired
    private DcClient2 dcClient2;

    @GetMapping("/feign-consumer")
    public String consumer() {
        return dcClient.consumer();
    }

    @GetMapping("/test/{serviceId}")
    public String getInfoFromEureka(@PathVariable String serviceId) {
        return dcClient2.getInfoFromEureka(serviceId);
    }
}
