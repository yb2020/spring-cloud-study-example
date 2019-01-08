package com.example.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MircoServiceEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MircoServiceEurekaApplication.class, args);
	}

}

