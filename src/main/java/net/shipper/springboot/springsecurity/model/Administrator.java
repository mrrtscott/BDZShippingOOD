package net.shipper.springboot.springsecurity.model;

import java.util.Date;

public class Administrator extends Employee{
    private Permission permission;

    public Administrator() {}

    public Administrator(String firstName, String lastName, String emailAddress, String password, Date dateOfBirth, EmploymentStatus empstat, Sex sex, Permission permission) {
        super(firstName, lastName, emailAddress, password, dateOfBirth, empstat, sex);
        this.permission = permission;
    }

    /**
     * @return the permission
     */
    public Permission getPermission() {
        return permission;
    }

    /**
     * @param permission the permission to set
     */
    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}