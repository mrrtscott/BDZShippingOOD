package net.shipper.springboot.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerAccount {
	 
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountID;
    private BillingMethod billingMethod;
    private double accountBalance;
    private long customerid;

    public CustomerAccount() { 
        this.accountBalance = 0;
    }

    public CustomerAccount(Long id) {
        this.id = id; 
        this.accountBalance = 0;
    }

    /**
     * @return the accountID
     */
    public String getAccountID() {
        return accountID;
    }

  

    /**
     * @return the billingMethod
     */
    public BillingMethod getBillingMethod() {
        return billingMethod;
    }

    /**
     * @param billingMethod the billingMethod to set
     */
    public void setBillingMethod(BillingMethod billingMethod) {
        this.billingMethod = billingMethod;
    }

    /**
     * @return the accountBalance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * @param accountBalance the accountBalance to set
     */
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

	 

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	 

    
	
    
}