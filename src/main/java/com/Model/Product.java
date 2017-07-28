package com.Model;


import java.io.Serializable;
import java.util.*;

import javax.persistence.*;
import javax.validation.*;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
@Table(name="Product")
public class Product implements Serializable {
	
	
	private static final long serialVersionUID=1L;
	
	@Id
	private int id;
	private String name;
	private String description;
	private Float price;
	private int stock;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cid")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="sid")
	private Supplier supplier;
	
	public Supplier getSupplier() {
		return supplier;
	}



	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}



	@Transient
	MultipartFile pimg;
	public String imgname;
	
	
	
	public String getImgname() {
		return imgname;
	}



	public void setImgname(String imgname) {
		this.imgname = imgname;
	}



	public MultipartFile getPimg() {
		return pimg;
	}



	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}



	public Category getCat() {
		return category;
	}



	public void setCat(Category category) {
		this.category = category;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Float getPrice() {
		return price;
	}



	public void setPrice(Float price) {
		this.price = price;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}


}
