
package com.ecommerce.model;

import java.util.ArrayList;
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
public class Category {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private int Category_id;
	
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinTable(name = "category_products",
	joinColumns = @JoinColumn(name="category_id"),
	inverseJoinColumns = @JoinColumn(name="product_id"))
	List<Product> products = new ArrayList<>(); 
}