package com.fuyi.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fuyi on 2018/1/15.
 */
@FeignClient(name = "eureka-client-provider", url = "http://localhost:1001/", configuration = CustomFeignClientConfiguration.class)
public interface DcClient2 {

    @RequestMapping("/eureka/apps/{serviceId}")
    String getInfoFromEureka(@PathVariable("serviceId") String serviceId);
}
