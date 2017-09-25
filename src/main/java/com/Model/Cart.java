package com.Model;
import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.*;

import org.springframework.stereotype.Component;

@SuppressWarnings("unused")
@Entity
@Component
@Table(name="CartDetails")

public class Cart implements Serializable{
	@Id
	@GeneratedValue
	private int cartId;
	private int cartProductId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userMailId")
	
	private User cartUserDetails;
	private Double cartPrice;
	public Double getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}
	private String cartImage;
	private String cartProductName;
	private int cartQuantity;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}
	public User getCartUserDetails() {
		return cartUserDetails;
	}
	public void setCartUserDetails(User cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}
	
	public int getCartQuantity() {
		return cartQuantity;
	}
	public void setCartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public String getCartImage() {
		return cartImage;
	}
	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}
	public String getCartProductName() {
		return cartProductName;
	}
	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}
	
	public Cart (int cartId,int cartProductId,User cartUserDetails,double cartPrice,int cartQuantity,String cartImage,String cartProductName){
		this.cartId=cartId;
		this.cartProductId=cartProductId;
		this.cartUserDetails=cartUserDetails;
		this.cartPrice=cartPrice;
		this.cartQuantity=cartQuantity;
		this.cartImage=cartImage;
		this.cartProductName=cartProductName;
	}
	public Cart()
	{
		
	}

}
