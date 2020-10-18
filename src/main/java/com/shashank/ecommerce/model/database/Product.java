package com.shashank.ecommerce.model.database;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "product_id")
	private Long productId;

	@Basic(optional = false)
	@Column(name = "name")
	private String name;

	@Basic(optional = false)
	@Column(name = "sale_price")
	private double salePrice;

	@Basic(optional = false)
	@Column(name = "list_price")
	private double listPrice;

	@Basic(optional = false)
	@Column(name = "image")
	private String image;

	@Basic(optional = false)
	@Column(name = "quantity")
	private int quantity;

	@Basic(optional = false)
	@Column(name = "status")
	private Boolean status;

	@Column(name = "description")
	private String description;

	@Basic(optional = false)
	@Column(name = "created_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "updated_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

}