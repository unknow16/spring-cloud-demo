package com.fuyi.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.fuyi.cloud.entity.User;
import com.fuyi.config.FeignCustomConfiguration;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user", configuration=FeignCustomConfiguration.class)
public interface UserFeignClient {

	@RequestLine("GET /simple/{id}")
	public User findById(@Param("id") Long id);
	
}
