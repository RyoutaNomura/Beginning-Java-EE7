package org.agoncal.book.javaee7.chapter03.bean;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.agoncal.book.javaee7.chapter03.annotation.Email;
import org.agoncal.book.javaee7.chapter03.annotation.Validatable;

@Validatable
public class Customer {
	@NotNull @Size(min=2)
	private String firstName;
	private String lastName;
	@Email
	private String email;
	private String phoneNumber;
	@Past
	private Date dateOfBirth;
	private Address deliveryAddress;

	public Customer(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public Customer() {}

	public String getFirstName() {
		return this.firstName;
	}
	@Validatable
	public void setFirstName(@NotNull String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getDeliveryAddress() {
		return this.deliveryAddress;
	}
	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
}
