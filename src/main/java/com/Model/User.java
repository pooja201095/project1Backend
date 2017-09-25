package com.Model;
import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name="User")
public class User implements Serializable{
	
	@Id
	@Email(message="Enter valid email")
	@NotEmpty(message="Enter the email")
	private String email;
	
	
	
	@NotEmpty(message="Enter the name")
	@Column(name="name")
	private String name;
	
	@NotNull(message="Password is null")
	private String password;
	
	@NotNull(message="Confirm Password is null")
	private String cpassword;
	
	
	
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	private String role;
	
	@NotNull(message="Address is null")
	private String address;
	
	@Pattern(regexp="[\\d]{10}",message="Please enter digits")
	@NotNull
	@Size(min=8,max=10,message="Enter correct Phone Number")
	private String phone;
	
	private boolean enabled;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
