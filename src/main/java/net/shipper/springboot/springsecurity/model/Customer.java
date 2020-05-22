package net.shipper.springboot.springsecurity.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
 

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "emailAddress"))
public class Customer {
    // private static int idCounter = 10000;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // private String customerID;
    private Long customerID;

    private String firstName, lastName, emailAddress, password;
    private Date signupDate, dateOfBirth;
    private int sex;
    
     
    private ArrayList<Shipment> shipments;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "customers_roles",
            joinColumns = @JoinColumn(
                    name = "customer_id", referencedColumnName = "customerid"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;
    
    
    private String newAccountID;
    private BillingMethod newBillingMethod;
    private double newAccountBalance;
    
    public Customer() {
    	// this.customerID = "CUS" + idCounter;
    	this.signupDate = new Date();
    	// idCounter++;
    }

	public Customer(String firstName, String lastName, String emailAddress, String password, Date dateOfBirth, int sex) {
        // this.customerID = "CUS" + idCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.signupDate = new Date(); //now has current date
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
       // this.customerAccount = new CustomerAccount(this.customerID);
        // idCounter++;
    }
    
	public Customer(String firstName, String lastName, String emailAddress, String password, Date dateOfBirth, int sex, Collection<Role> roles) {
        // this.customerID = "CUS" + idCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        // this.confirmEmailAddress = confirmEmailAddress;
        this.password = password;
        // this.confirmPassword = confirmPassword;
        this.signupDate = new Date(); //now has current date
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        //this.customerAccount = new CustomerAccount(this.customerID);
        this.roles = roles;
        // idCounter++;
    }

	/**
     * @param customerID the customerID to set
     */
    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }
    
    /**
     * @return the customerID
     */
    public Long getCustomerID() {
        return customerID;
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
     * @return the signupDate
     */
    public Date getSignUpDate() {
        return signupDate;
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
     * @return the sex
     */
    public int getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(int sex) {
        this.sex = sex;
    }

  
    /**
     * @return the shipments
     */
    public ArrayList<Shipment> getShipments() {
        return shipments;
    }

    /**
     * @param shipment the shipment to add
     */
    public void addShipment(Shipment shipment) {
        this.shipments.add(shipment);
    }
    
    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
    
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + "*********" + '\'' +
                ", roles=" + roles +
                '}';
    }

	public Date getSignupDate() {
		return signupDate;
	}

	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
	}

	public String getNewAccountID() {
		return newAccountID;
	}

	public void setNewAccountID(String newAccountID) {
		this.newAccountID = newAccountID;
	}

	public BillingMethod getNewBillingMethod() {
		return newBillingMethod;
	}

	public void setNewBillingMethod(BillingMethod newBillingMethod) {
		this.newBillingMethod = newBillingMethod;
	}

	public double getNewAccountBalance() {
		return newAccountBalance;
	}

	public void setNewAccountBalance(double newAccountBalance) {
		this.newAccountBalance = newAccountBalance;
	}

	 
	public void setShipments(ArrayList<Shipment> shipments) {
		this.shipments = shipments;
	}
    
    
    

}