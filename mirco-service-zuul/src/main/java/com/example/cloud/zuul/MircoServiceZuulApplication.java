package com.example.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.example.cloud.zuul.filter.ValidateTokenFilter;
import com.netflix.zuul.ZuulFilter;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class MircoServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoServiceZuulApplication.class, args);
	}

	@Bean
	public ZuulFilter getFilter() {
		return new ValidateTokenFilter() ;
	}
}

