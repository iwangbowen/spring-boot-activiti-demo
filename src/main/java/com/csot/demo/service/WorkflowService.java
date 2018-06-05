package com.csot.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class WorkflowService {

	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private ProcessEngineConfigurationImpl processEngineConfiguration;

	public String start(String processKey, Map<String, Object> variables) {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processKey, variables);
		return processInstance.getActivityId();
	}

	public List<Map<String, Object>> getTasksByAssignee(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list().stream()
				.map(this::transformTask)
				.collect(Collectors.toList());
	}

	public void completeTask(String taskId, Map<String, Object> variables) {
		taskService.complete(taskId, variables);
	}
	
	private Map<String, Object> transformTask(Task task) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", task.getId());
		map.put("taskDefinitionKey", task.getTaskDefinitionKey());
		map.put("taskName", task.getName());
		map.put("createTime", task.getCreateTime());
		return map;
	}

}
