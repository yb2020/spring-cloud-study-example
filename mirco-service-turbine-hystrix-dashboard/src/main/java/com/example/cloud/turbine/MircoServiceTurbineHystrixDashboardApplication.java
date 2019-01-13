package com.example.cloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Bean;

import com.netflix.turbine.streaming.servlet.TurbineStreamServlet;

@EnableHystrixDashboard
@EnableTurbine
@EnableDiscoveryClient
@SpringBootApplication
public class MircoServiceTurbineHystrixDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoServiceTurbineHystrixDashboardApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<TurbineStreamServlet> getServlet() {
		TurbineStreamServlet streamServlet = new TurbineStreamServlet();
		ServletRegistrationBean<TurbineStreamServlet> registrationBean = new ServletRegistrationBean<TurbineStreamServlet>(
				streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/turbine.stream");
		registrationBean.setName("TurbineStreamServlet");
		return registrationBean;
	}
}
