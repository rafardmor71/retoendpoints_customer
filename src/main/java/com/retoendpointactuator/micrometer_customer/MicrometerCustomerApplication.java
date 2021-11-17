package com.retoendpointactuator.micrometer_customer;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.retoendpointactuator.micrometer_customer.services.ChangeStatusService;

@SpringBootApplication
public class MicrometerCustomerApplication implements CommandLineRunner{

	@Autowired
	ChangeStatusService statusService;
	public static void main(String[] args) {
		SpringApplication.run(MicrometerCustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		for(int i=0;i<statusService.getAllStatus().size();i++) {
			
			statusService.setToOpen();
			
			System.out.println(statusService.getStatus());
			
			Thread.sleep(2000);
			
			statusService.setToClose();
			
			System.out.println(statusService.getStatus());
			
			Thread.sleep(2000);
			
			statusService.setToHalfClose();
			
			System.out.println(statusService.getStatus());
		
		}
		/*
			String newStatus = "Nuevo estado";
			
			//Peta, metodo no soportado, no puedo añadir nuevo estado
			/*
			RestTemplate addTemplate = new RestTemplate();
			String addTemplateString = "http://localhost:8080/actuator/estados/" + newStatus;
			ResponseEntity<String> responseAdd
			  = addTemplate.getForEntity(addTemplateString, String.class);
			System.out.println(responseAdd.getBody());
			//responseAdd.getBody();
			 */
			
			//System.out.println(status_open + status_halfClose + status_close);
			/*
			for(int i=0; i<statusList.size();i++) {
				System.out.println(statusList.get(i));
			}
			*/
		}
	
		
	}


