package com.example.microservice.Employeepayrollservice.Repository;

import com.example.microservice.Employeepayrollservice.Model.EmployeePayroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayRollRepo extends JpaRepository<EmployeePayroll, Long> {

}
