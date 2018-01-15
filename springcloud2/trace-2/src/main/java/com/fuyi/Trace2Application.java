package com.fuyi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace2Application {

	private Logger logger = LoggerFactory.getLogger(Trace2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Trace2Application.class, args);
	}

	@RequestMapping("/trace-2")
	public String trace(HttpServletRequest request) {
		logger.info("trace {} called, trace Id = {}, span Id = {}.", 2,
				request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
		return "trace";
	}
}
