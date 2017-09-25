package com.Model;
import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.*;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Entity
@Component
@Table(name="Orders")

public class Order {
	@Id
	@GeneratedValue
	private int orderId;
	@ManyToOne
	@JoinColumn(name="email")
	private User user;
	private String payment;
	private double total;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	

}
