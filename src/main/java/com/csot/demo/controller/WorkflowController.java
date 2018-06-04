package com.csot.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csot.demo.service.WorkflowService;

@RestController
public class WorkflowController {
	@Autowired
	private WorkflowService workflowService;

	@RequestMapping("/start")
	public String start() {
		return workflowService.start();
	}

	@RequestMapping("/user/{assignee}")
	public List<Map<String, Object>> getTasks(@PathVariable String assignee) {
		return workflowService.getTasksByAssignee(assignee);
	}

	@RequestMapping("/complete/{taskId}")
	public void completeTask(@PathVariable String taskId) {
		workflowService.completeTask(taskId);
	}
}
