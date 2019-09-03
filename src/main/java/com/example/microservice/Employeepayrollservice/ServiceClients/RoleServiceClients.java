package com.example.microservice.Employeepayrollservice.ServiceClients;

import com.example.microservice.Employeepayrollservice.Model.RoleDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "roll-service", url = "localhost:8101" )
public interface RoleServiceClients {

    @GetMapping("role/{roleName}")
    public RoleDetails getRoleDetails(@PathVariable String roleName);
}
