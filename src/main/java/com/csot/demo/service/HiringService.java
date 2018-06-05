package com.csot.demo.service;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component("hiringService")
public class HiringService {

	public Map<String, Object> storeResume() {
		System.out.println("Store resume successfully=========================================");
		return null;
	}

	public void sendRejectionEmail() {
		System.out.println("Send rejection email successfully=========================================");
	}

	public void sendWelcomeEmail() {
		System.out.println("Send welcome email successfully=========================================");
	}
}
