package net.shipper.springboot.springsecurity.web.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import net.shipper.springboot.springsecurity.model.BillingMethod;

public class CustomerAccountDto {

	 
	private long id; 
    private String accountID;
    private BillingMethod billingMethod;
    private double accountBalance;
    private long customerid;
    
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public long getCustomerid() {
			return customerid;
		}
		public void setCustomerid(long customerid) {
			this.customerid = customerid;
		}
		public String getAccountID() {
			return accountID;
		}
		public void setAccountID(String accountID) {
			this.accountID = accountID;
		}
		public BillingMethod getBillingMethod() {
			return billingMethod;
		}
		public void setBillingMethod(BillingMethod billingMethod) {
			this.billingMethod = billingMethod;
		}
		public double getAccountBalance() {
			return accountBalance;
		}
		public void setAccountBalance(double accountBalance) {
			this.accountBalance = accountBalance;
		}
		 
	 
}
