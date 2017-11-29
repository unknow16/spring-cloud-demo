package com.fuyi.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fuyi.cloud.entity.User;

@FeignClient("microservice-provider-user")
//@FeignClient(name="microservice-provider-user", fallback="fallbackMethod")
public interface UserFeignClient {

	/**
	 * 坑
	 * 1.@GetMapping不支持
	 * 2.@PathVariable要设置value
	 */
	@RequestMapping(value="/simple/{id}", method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
	@RequestMapping(value="/testPost", method=RequestMethod.POST)
	public User postUser(@RequestBody User user);
}
