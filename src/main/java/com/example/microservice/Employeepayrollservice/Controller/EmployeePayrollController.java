package com.example.microservice.Employeepayrollservice.Controller;

import com.example.microservice.Employeepayrollservice.Model.EmployeeDetails;
import com.example.microservice.Employeepayrollservice.Model.EmployeePayroll;
import com.example.microservice.Employeepayrollservice.Model.RoleDetails;
import com.example.microservice.Employeepayrollservice.Repository.EmployeePayRollRepo;
import com.example.microservice.Employeepayrollservice.ServiceClients.EmployeeServiceClient;
import com.example.microservice.Employeepayrollservice.ServiceClients.RoleServiceClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
public class EmployeePayrollController {

    @Autowired
    EmployeePayRollRepo employeePayRollRepo;

    @Autowired
    EmployeeServiceClient employeeServiceClient;

    @Autowired
    RoleServiceClients roleServiceClients;

    @PostMapping("/employee/{empId}/role/{roleName}")
    public EmployeePayroll insertEmployeePayRoleDetails(@PathVariable Long empId, @PathVariable String roleName){
        //TODO Insertion logic
        //EmployeePayroll employeePayroll = new EmployeePayroll(001l,002l,001l,"AAA","BB","Human Resource");
        EmployeePayroll employeePayroll = new EmployeePayroll();
        EmployeeDetails employeeDetails = employeeServiceClient.getEmployeeDetails(empId);
        RoleDetails roleDetails = roleServiceClients.getRoleDetails(roleName);

       if(employeeDetails != null){
            employeePayroll.setEmpId(employeeDetails.getEmpId());
            employeePayroll.setFirstName(employeeDetails.getFirstName());
            employeePayroll.setLastName(employeeDetails.getLastName());
           employeePayroll.setPort(employeeDetails.getPort());
        }
        if (roleDetails!=null)
        {
            employeePayroll.setRoleId(roleDetails.getRoleId());
            employeePayroll.setRoleDesc(roleDetails.getRoleDescription());
        }
        employeePayRollRepo.save(employeePayroll);
        return employeePayroll;
    }

    @GetMapping("/employee/{empId}")
    public EmployeePayroll getEmployeePayRoleDetails(@PathVariable Long empId){

        Optional<EmployeePayroll> employeePayroll = employeePayRollRepo.findById(empId);

        if(employeePayroll.isPresent())
            return employeePayroll.get();
        else
            return null;

    }
}
