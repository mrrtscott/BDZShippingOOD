package net.shipper.springboot.springsecurity.model;

import java.util.Date;

public class Staff extends Employee{
    private Role role;

    public Staff() {}

    public Staff(String firstName, String lastName, String emailAddress, String password, Date dateOfBirth, EmploymentStatus empstat, Sex sex, Role role) {
        super(firstName, lastName, emailAddress, password, dateOfBirth, empstat, sex);
        this.role = role;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }
}