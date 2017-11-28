package com.fuyi.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fuyi.config.FeignClient2Configuration;

@FeignClient(name="xxx", url="http://localhost:8761/", configuration=FeignClient2Configuration.class)
public interface FeignClient2 {

	@RequestMapping(value="/eureka/apps/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
