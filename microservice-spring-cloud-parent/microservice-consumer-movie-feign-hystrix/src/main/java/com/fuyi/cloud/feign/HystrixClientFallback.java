package com.fuyi.cloud.feign;

import org.springframework.stereotype.Component;

import com.fuyi.cloud.entity.User;

@Component
public class HystrixClientFallback implements UserFeignClient {

	@Override
	public User findById(Long id) {
		User user = new User();
		user.setId(id);
		user.setName("feign-hystrix-default");
		return user;
	}
}
