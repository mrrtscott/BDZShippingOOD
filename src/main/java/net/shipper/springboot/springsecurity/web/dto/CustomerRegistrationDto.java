package net.shipper.springboot.springsecurity.web.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import net.shipper.springboot.springsecurity.constraint.FieldMatch;

@FieldMatch.List({
		@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
		@FieldMatch(first = "emailAddress", second = "confirmEmailAddress", message = "The email fields must match") })

public class CustomerRegistrationDto {
	@NotEmpty
	private String firstName;

	@NotEmpty
	private String lastName;

	@NotEmpty private String sex;

	@NotEmpty
	private String birth; 

	@NotEmpty
	private String password;

	@NotEmpty
	private String confirmPassword;

	@Email
	@NotEmpty
	private String emailAddress;

	@Email
	@NotEmpty
	private String confirmEmailAddress;

	@AssertTrue
	private Boolean terms;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getConfirmEmailAddress() {
		return confirmEmailAddress;
	}

	public void setConfirmEmailAddress(String confirmEmailAddress) {
		this.confirmEmailAddress = confirmEmailAddress;
	}

	public String getSex() { return sex; }

	public void setSex(String sex) { this.sex = sex; }

	public String getBirth() { 
		return birth; 
	}
	public void setBirth(String birth) {
		this.birth = birth; 
	}
	 
	public Boolean getTerms() { return terms; } 
	public void setTerms(Boolean terms) { this.terms = terms; }
	

}
