package com.fuyi.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2017/12/29 0029.
 */
//@FeignClient(name = "eureka-client-provider", fallback = HystrixClientFallback.class)
@FeignClient(name = "eureka-client-provider", fallbackFactory = HystrixClientFallbackFactory.class)
public interface DcClient {

    @GetMapping("/dc")
    String consumer();
}
