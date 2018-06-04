package com.csot.demo.controller;

import java.util.List;
import java.util.Map;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csot.demo.service.WorkflowService;

@RestController
public class WorkflowController {
	@Autowired
	private WorkflowService workflowService;
	
	@RequestMapping("/")
	public String hello() {
		return "Welcome to Spring Boot Application";
	}
	
	@RequestMapping("/start")
	public String start() {
		return workflowService.start();
	}
	
	@RequestMapping("/user/{assignee}")
	public List<Map> getTasks(@PathVariable String assignee) {
		return workflowService.getTasksByAssignee(assignee);
	}
}
