package com.fuyi.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fuyi.cloud.entity.User;
import com.fuyi.cloud.feign.FeignClient2;
import com.fuyi.cloud.feign.UserFeignClient;

@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private FeignClient2 feignClient2;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return userFeignClient.findById(id);
	}
	
	@GetMapping("/test/{serviceName}")
	public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName){
		return feignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
	}
}
