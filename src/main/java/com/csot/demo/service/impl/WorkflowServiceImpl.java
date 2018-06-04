package com.csot.demo.service.impl;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csot.demo.service.WorkflowService;

@Service
public class WorkflowServiceImpl implements WorkflowService {
	
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

	@Override
	public String start() {
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");
		return processInstance.getActivityId();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Map> getTasksByAssignee(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list().stream()
				.map(task -> {
					Map<String, Object> map = new HashMap<>();
					map.put("id", task.getId());
					map.put("taskDefinitionKey", task.getTaskDefinitionKey());
			        map.put("taskName", task.getName());
			        return map;
				})
				.collect(Collectors.toList());
	}

}
