package com.fuyi.controller;

import com.fuyi.feign.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/29 0029.
 */
@RestController
public class WebController {

    @Autowired
    private DcClient dcClient;

    @GetMapping("/feign-consumer")
    public String consumer() {
        return dcClient.consumer();
    }

}
