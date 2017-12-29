package com.fuyi.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2017/12/29 0029.
 */
@FeignClient("eureka-client-provider")
public interface DcClient {

    @GetMapping("/dc")
    String consumer();
}
