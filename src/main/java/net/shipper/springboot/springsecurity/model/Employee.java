package net.shipper.springboot.springsecurity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    private static int idCounter = 10000;

    @Id
    private String employeeID;

    private String firstName, lastName, emailAddress, password;
    private Date dateJoined, dateOfBirth;
    private EmploymentStatus empstat;
    private Sex sex;

    public Employee() {

    }

    public Employee(String firstName, String lastName, String emailAddress, String password, Date dateOfBirth, EmploymentStatus empstat, Sex sex) {
        this.employeeID = "EMP" + idCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.dateJoined = new Date(); //now has current date
        this.dateOfBirth = dateOfBirth;
        this.empstat = empstat;
        this.sex = sex;
        idCounter++; 
    }

    /**
     * @return the employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the dateJoined
     */
    public Date getDateJoined() {
        return dateJoined;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the empstat
     */
    public EmploymentStatus getEmpstat() {
        return empstat;
    }

    /**
     * @param empstat the empstat to set
     */
    public void setEmpstat(EmploymentStatus empstat) {
        this.empstat = empstat;
    }

    /**
     * @return the sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }
    

}