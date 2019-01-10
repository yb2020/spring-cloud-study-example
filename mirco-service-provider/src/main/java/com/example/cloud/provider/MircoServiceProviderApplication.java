package com.example.cloud.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MircoServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoServiceProviderApplication.class, args);
	}

}

