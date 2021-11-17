package com.retoendpointactuator.micrometer_customer.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
public class ClienteController {
	
	@RequestMapping(path = "/verAllStatus", method = RequestMethod.GET)
	public String verStatus() {
		RestTemplate verTemplate = new RestTemplate();
		String template = "http://localhost:8080/actuator/estados";
		ResponseEntity<String> responseOpen
		  = verTemplate.getForEntity(template, String.class);
		System.out.println(responseOpen);
		return responseOpen.getBody();
	}
	
	@RequestMapping(path = "/statusAdd", method = RequestMethod.POST)
	public String añadirStatus(@RequestParam String estado) {
		RestTemplate verTemplate = new RestTemplate();
		String template = "http://localhost:8080/actuator/estados/" + estado ;
		ResponseEntity<String> responseOpen
		  = verTemplate.getForEntity(template, String.class);
		System.out.println(responseOpen);
		return responseOpen.getBody();
	}
	
}
