package com.csot.demo.service.impl;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.csot.demo.service.HiringService;

@Component("hiringService")
public class HiringServiceImpl implements HiringService {

	@Override
	public Map<String, Object> storeResume() {
		System.out.println("Store resume successfully=========================================");
		return null;
	}

	@Override
	public void sendRejectionEmail() {
		System.out.println("Send rejection email successfully=========================================");
	}

	@Override
	public void sendWelcomeEmail() {
		System.out.println("Send welcome email successfully=========================================");
	}

}
