package com.Model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.*;

@Entity
@Table(name="Supplier")
public class Supplier {
	
	@Id
	private int sid;
	
	private String sname;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	//for listing product
	@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER)//,mappedBy=("Supplier"))
	private Set<Product> products= new HashSet<Product>(0);

}
