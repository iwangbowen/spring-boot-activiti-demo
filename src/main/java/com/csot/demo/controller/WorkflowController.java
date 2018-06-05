package com.csot.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csot.demo.service.WorkflowService;

@RestController
public class WorkflowController {
	@Autowired
	private WorkflowService workflowService;

	@RequestMapping("/start/{processKey}")
	public String start(@RequestParam Map<String, Object> allRequestParams, @PathVariable String processKey) {
		return workflowService.start(processKey, allRequestParams);
	}
	
	@RequestMapping("/user/{assignee}")
	public List<Map<String, Object>> getTasks(@PathVariable String assignee) {
		return workflowService.getTasksByAssignee(assignee);
	}

	@RequestMapping(value = "/complete/{taskId}", method = RequestMethod.POST)
	public void completeTask(@PathVariable String taskId, @RequestBody Map<String, Object> variables) {
		workflowService.completeTask(taskId, variables);
	}
}
