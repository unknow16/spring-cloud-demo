package com.fuyi;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@EnableFeignClients
@SpringCloudApplication
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExculdeFromComponentScan.class)})
public class EurekaClientConsumerFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientConsumerFeignApplication.class, args);
	}
}
