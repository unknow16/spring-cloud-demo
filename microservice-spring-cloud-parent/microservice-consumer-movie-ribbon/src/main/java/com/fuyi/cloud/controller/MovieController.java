package com.fuyi.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fuyi.cloud.entity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		//http://localhost:1111
		//vip virtual IP   microservice-provider-user:1111
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
	}
	
	@GetMapping("/text")
	public String text() {
		ServiceInstance si = this.loadBalancerClient.choose("microservice-provider-user");
		System.out.println("aaaaaa  == " + si.getServiceId() + " : " + si.getHost() + " : " + si.getPort());
		
		ServiceInstance si2 = this.loadBalancerClient.choose("microservice-provider-user2");
		System.out.println("bbbbbb  == " + si2.getServiceId() + " : " + si2.getHost() + " : " + si2.getPort());
		
		return "1";
	}
	
	@GetMapping("/sidecar")
	public String sidecar() {
		return restTemplate.getForObject("http://microservice-sidecar/", String.class);
	}
}
