package com.manan.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {
	
	@GetMapping("/hello")
	public String greetTheWorld()
	{
		return "Hello World!";
	}

}
