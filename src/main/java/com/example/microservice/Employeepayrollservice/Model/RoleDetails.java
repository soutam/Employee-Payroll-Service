package com.example.microservice.Employeepayrollservice.Model;

public class RoleDetails {

    private Long roleId;

    private String roleName;

    private String roleDescription;

    public RoleDetails(Long roleId, String roleName, String roleDescription) {
        super();
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }
    public RoleDetails(){}

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
