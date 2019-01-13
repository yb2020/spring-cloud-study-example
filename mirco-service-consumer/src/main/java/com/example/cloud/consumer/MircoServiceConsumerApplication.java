package com.example.cloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class MircoServiceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoServiceConsumerApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
		HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet() ;
		ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>() ;
		servletRegistrationBean.setServlet(hystrixMetricsStreamServlet);
		servletRegistrationBean.setLoadOnStartup(10);
		servletRegistrationBean.addUrlMappings("/hystrix.stream");
		servletRegistrationBean.setName("HystrixMetricsStreamServlet");
		return servletRegistrationBean ;
	}

}

