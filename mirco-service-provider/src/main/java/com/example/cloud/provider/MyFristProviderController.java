package com.example.cloud.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFristProviderController {

	@RequestMapping(value="/helloWorld", method=RequestMethod.GET)
	public String helloWorld(@RequestParam("name") String name) {
		return "Hello," + name + ", this is your world" ;
	}
}
