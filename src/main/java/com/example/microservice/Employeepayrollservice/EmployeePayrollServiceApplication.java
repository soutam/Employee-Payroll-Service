package com.example.microservice.Employeepayrollservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.microservice.Employeepayrollservice")
public class EmployeePayrollServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePayrollServiceApplication.class, args);
	}

}
