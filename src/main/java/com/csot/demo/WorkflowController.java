package com.csot.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkflowController {
	@RequestMapping("/")
	public String hello() {
		return "Welcome to Spring Boot Application";
	}
}
