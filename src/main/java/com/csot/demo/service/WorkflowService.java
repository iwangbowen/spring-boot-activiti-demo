package com.csot.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface WorkflowService {
	String start(String processKey, Map<String, Object> variables);
	
	List<Map<String, Object>> getTasksByAssignee(String assignee);
	
	void completeTask(String taskId, Map<String, Object> variables);
}
