package com.example.cloud.consumer;

import org.springframework.stereotype.Component;

@Component
public class MyFristConsumerHystrix implements MyFristConsumer{

	@Override
	public String helloWorld(String name) {
		return "your message send failed!";
	}
	
}
