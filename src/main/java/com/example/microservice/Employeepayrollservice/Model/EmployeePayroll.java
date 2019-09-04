package com.example.microservice.Employeepayrollservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EmployeePayroll {

    @Id
    @Column(name = "payroll_id")
    @GeneratedValue
    private Long payrollId;

    @Column(name = "emp_id")
    private Long empId;

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role_desc")
    private String roleDesc;

    private String port;
    public EmployeePayroll() {
    }

    public EmployeePayroll(Long payrollId, Long empId, Long roleId, String firstName, String lastName, String roleDesc) {
        this.payrollId = payrollId;
        this.empId = empId;
        this.roleId = roleId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleDesc = roleDesc;
    }

    public Long getPayrollId() {  return payrollId; }

    public void setPayrollId(Long payrollId) { this.payrollId = payrollId;  }

    public Long getEmpId() { return empId; }

    public void setEmpId(Long empId) {  this.empId = empId; }

    public Long getRoleId() { return roleId; }

    public void setRoleId(Long roleId) { this.roleId = roleId; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getRoleDesc() { return roleDesc; }

    public void setRoleDesc(String roleDesc) { this.roleDesc = roleDesc; }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
