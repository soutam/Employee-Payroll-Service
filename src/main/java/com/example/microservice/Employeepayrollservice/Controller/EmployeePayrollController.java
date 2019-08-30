package com.example.microservice.Employeepayrollservice.Controller;

import com.example.microservice.Employeepayrollservice.Model.EmployeeDetails;
import com.example.microservice.Employeepayrollservice.Model.EmployeePayroll;
import com.example.microservice.Employeepayrollservice.Model.RoleDetails;
import com.example.microservice.Employeepayrollservice.Repository.EmployeePayRollRepo;
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


    @PostMapping("/employee/{empId}/role/{roleName}")
    public void insertEmployeePayRoleDetails(@PathVariable Long empId, @PathVariable String roleName){
        //TODO Insertion logic
        //EmployeePayroll employeePayroll = new EmployeePayroll(001l,002l,001l,"AAA","BB","Human Resource");
        ResponseEntity<EmployeeDetails> employeeResponse =
                new RestTemplate().getForEntity("http://localhost:8080/employee/{empId}", EmployeeDetails.class, empId);
        ResponseEntity<RoleDetails> roleResponse =
                new RestTemplate().getForEntity("http://localhost:8101/role/{roleName}", RoleDetails.class, roleName);
        EmployeePayroll employeePayroll = new EmployeePayroll();

        if(employeeResponse.getBody() != null){
            employeePayroll.setEmpId(employeeResponse.getBody().getEmpId());
            employeePayroll.setFirstName(employeeResponse.getBody().getFirstName());
            employeePayroll.setLastName(employeeResponse.getBody().getLastName());
        }
        if (roleResponse.getBody()!=null)
        {
            employeePayroll.setRoleId(roleResponse.getBody().getRoleId());
            employeePayroll.setRoleDesc(roleResponse.getBody().getRoleDescription());
        }
        employeePayRollRepo.save(employeePayroll);
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
