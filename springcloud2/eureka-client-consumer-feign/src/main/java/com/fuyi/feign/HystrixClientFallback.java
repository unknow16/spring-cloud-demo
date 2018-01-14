package com.fuyi.feign;

import org.springframework.stereotype.Component;

/**
 * Created by fuyi on 2018/1/14.
 */
@Component
public class HystrixClientFallback implements DcClient {

    @Override
    public String consumer() {
        return "default-provider";
    }
}
