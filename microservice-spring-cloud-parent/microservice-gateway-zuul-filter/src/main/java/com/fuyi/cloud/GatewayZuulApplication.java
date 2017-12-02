package com.fuyi.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.fuyi.cloud.filter.PreZuulFilter;

@SpringBootApplication
@EnableZuulProxy
public class GatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayZuulApplication.class, args);
	}
	
	@Bean
	public PreZuulFilter prezuulFilter() {
		return new PreZuulFilter();
	}
}
 