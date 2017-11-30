package com.fuyi.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fuyi.cloud.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	/**
	 * 默认hystrixCommand和fallbackMethod执行在两个线程中
	 * 配置SEMAPHORE,则两者在同一个线程中
	 * 为了 Propagating the Security Context or using Spring Scopes
	 * @param id
	 * @return
	 */
	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod="findByIdFallback")
	//@HystrixCommand(fallbackMethod="findByIdFallback", commandProperties = @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"))
	public User findById(@PathVariable Long id) {
		//http://localhost:1111
		//vip virtual IP   microservice-provider-user:1111
		ServiceInstance si = this.loadBalancerClient.choose("microservice-provider-user");
		System.out.println("aaaaaa  == " + si.getServiceId() + " : " + si.getHost() + " : " + si.getPort());

		return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	/**
	 * 参数和返回值跟原方法一致
	 * @param id  类型还Long
	 * @return 类型User.class
	 */
	public User findByIdFallback(Long id) {
		User user = new User();
		user.setId(id);
		user.setName("default_name");
		return user;
	}
	
	@GetMapping("/text")
	public String text() {
		ServiceInstance si = this.loadBalancerClient.choose("microservice-provider-user");
		System.out.println("aaaaaa  == " + si.getServiceId() + " : " + si.getHost() + " : " + si.getPort());
		
		ServiceInstance si2 = this.loadBalancerClient.choose("microservice-provider-user2");
		System.out.println("bbbbbb  == " + si2.getServiceId() + " : " + si2.getHost() + " : " + si2.getPort());
		
		return "1";
	}
}
