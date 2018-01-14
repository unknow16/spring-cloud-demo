package com.fuyi;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fuyi on 2018/1/13.
 */

@ExculdeFromComponentScan
@Configuration
public class CustomRibbonClientConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
