package com.example.microservice.Employeepayrollservice.Model;

public class EmployeeDetails {

    private String firstName;
    private String lastName;
    private Long empId;

    public EmployeeDetails (String firstName, String lastName, Long empId ){
        super();
        this.empId=empId;
        this.firstName=firstName;
        this.lastName =lastName;
    }

    public EmployeeDetails(){ }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }
}
