package com.fuyi.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by fuyi on 2018/1/14.
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<DcClient> {
    @Override
    public DcClient create(Throwable throwable) {
        return new DcClient() {
            @Override
            public String consumer() {
                return "fallback cause: == " + throwable.getMessage();
            }
        };
    }
}
