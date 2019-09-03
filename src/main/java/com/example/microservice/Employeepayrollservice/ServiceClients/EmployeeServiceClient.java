package com.example.microservice.Employeepayrollservice.ServiceClients;

import com.example.microservice.Employeepayrollservice.Model.EmployeeDetails;
import com.example.microservice.Employeepayrollservice.Model.EmployeePayroll;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "employee-service",url = "localhost:8080")
public interface EmployeeServiceClient {

    @GetMapping("/employee/{empId}")
    public EmployeeDetails getEmployeeDetails(@PathVariable Long empId);
}
