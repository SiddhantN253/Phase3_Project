package com.ecommerce.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;
	private String product_name;
	private long price;
	private Date dateAdded;
	private String brand;
	private String color;
	
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(name = "product_carts",
	joinColumns = @JoinColumn(name="product_id"),
	inverseJoinColumns = @JoinColumn(name="cart_id"))
	List<Cart> cart=new ArrayList<>();
	
	
}