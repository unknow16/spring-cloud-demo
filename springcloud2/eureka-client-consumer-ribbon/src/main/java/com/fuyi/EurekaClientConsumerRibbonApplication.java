package com.fuyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
//@RibbonClient(name = "eureka-client-provider", configuration = CustomRibbonClientConfiguration.class)
@RibbonClients(defaultConfiguration = CustomRibbonClientConfiguration.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExculdeFromComponentScan.class)})
public class EurekaClientConsumerRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientConsumerRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
