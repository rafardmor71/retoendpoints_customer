package com.retoendpointactuator.micrometer_customer.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.retoendpointactuator.micrometer_customer.model.Status;

@Service
public class ChangeStatusService {
	private RestTemplate template = new RestTemplate();
	private String url = "http://localhost:8080/"; 
	
	Status status = new Status();
	public void setToOpen() {
		String urlTemplate = url + "actuator/estados";
		ResponseEntity<String[]> responseEntity = template.getForEntity(urlTemplate, String[].class);
		List<String> statusList = Arrays.asList(responseEntity.getBody());
		String status_open = statusList.get(0);
		status.setStatus(status_open);
	}
	
	public void setToClose() {
		String urlTemplate = url + "actuator/estados";
		ResponseEntity<String[]> responseEntity = template.getForEntity(urlTemplate, String[].class);
		List<String> statusList = Arrays.asList(responseEntity.getBody());
		String status_close = statusList.get(1);
		status.setStatus(status_close);
	}
	
	public void setToHalfClose() {
		String urlTemplate = url + "actuator/estados";
		ResponseEntity<String[]> responseEntity = template.getForEntity(urlTemplate, String[].class);
		List<String> statusList = Arrays.asList(responseEntity.getBody());
		String status_HalfClose = statusList.get(2);
		status.setStatus(status_HalfClose);
	}
	
	public List<String> getAllStatus() {
		String urlTemplate = url + "actuator/estados";
		ResponseEntity<String[]> responseEntity = template.getForEntity(urlTemplate, String[].class);
		List<String> statusList = Arrays.asList(responseEntity.getBody());
		return statusList;
	}
	
	public String getStatus() {
		return status.getStatus();
	}
}
