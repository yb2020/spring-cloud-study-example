package com.example.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class MircoServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoServiceProviderApplication.class, args);
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

