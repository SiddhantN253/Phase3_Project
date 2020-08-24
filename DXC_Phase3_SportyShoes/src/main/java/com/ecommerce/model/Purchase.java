package com.ecommerce.model;

import java.sql.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "purchase") 
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	private int purchase_id;
	private Date date_of_purchase;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "purchase_users",
	joinColumns = @JoinColumn(name="purchase_id"),
	inverseJoinColumns = @JoinColumn(name="user_id"))
	private User user_id;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	@JoinTable(name = "purchase_categories",
	joinColumns = @JoinColumn(name="purchase_id"),
	inverseJoinColumns = @JoinColumn(name="category_id"))
	List<Category> categories = new ArrayList<>();

	private long total_amount;
	
}
