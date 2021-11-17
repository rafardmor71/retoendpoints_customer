package com.retoendpointactuator.micrometer_customer.model;

import org.springframework.stereotype.Component;

@Component
public class Status {
	private String status;
	
	public Status() {
		// TODO Auto-generated constructor stub
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
