package com.example.cloud.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MyFristConsumerController {

	@Value("${server.port}")
	private String port ;
	
	@Autowired
	private MyFristConsumer myFristConsumer ;
	
	@RequestMapping("/consumerHelloWorld")
	public String consumerHelloWorld(@RequestParam("name") String name) {
		return myFristConsumer.helloWorld(name) + "Your port is " + port;
	}
}
