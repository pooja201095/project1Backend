package com.Model;


import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.*;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	private int cid;
	
	private String name;
	//for listing product
	@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER)//,mappedBy=("Category"))
	private Set<Product> products= new HashSet<Product>(0);
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	

}
