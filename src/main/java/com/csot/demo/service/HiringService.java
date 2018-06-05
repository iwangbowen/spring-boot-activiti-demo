package com.csot.demo.service;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface HiringService {
	Map<String, Object> storeResume();
	
	void sendRejectionEmail();
	
	void sendWelcomeEmail();
}
