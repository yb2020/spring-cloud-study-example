package com.example.cloud.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFristConsumerController {

	@Autowired
	private MyFristConsumer myFristConsumer ;
	
	@RequestMapping("/consumerHelloWorld")
	public String consumerHelloWorld(@RequestParam("name") String name) {
		return myFristConsumer.helloWorld(name) ;
	}
}
