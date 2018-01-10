package com.fuyi;

import com.fuyi.fallback.MyFallbackProvider;
import com.fuyi.filter.AccessFilter;
import com.fuyi.filter.ThrowErrorFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class GatewayZuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(GatewayZuulApplication.class).web(true).run(args);
	}

	@Bean
	public ThrowErrorFilter throwErrorFilter() {
		return new ThrowErrorFilter();
	}

/*	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}*/

/*	@Bean
	public PatternServiceRouteMapper serviceRouteMapper() {
		return new PatternServiceRouteMapper(
				"(?<name>^.+)-(?<version>v.+$)",
				"${version}/${name}");
	}*/

	@Bean
	public ZuulFallbackProvider zuulFallbackProvider() {
		return new MyFallbackProvider();
	}
}
