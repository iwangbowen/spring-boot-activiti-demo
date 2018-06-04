package com.csot.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface WorkflowService {
	String start();
	
	@SuppressWarnings("rawtypes")
	List<Map> getTasksByAssignee(String assignee);
	
	void completeTask(String taskId);
}
