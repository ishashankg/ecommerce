package com.shashank.ecommerce.model.database;

import java.io.Serializable;
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
@Table(name = "order_details")
public class OrderDetail implements Serializable{

	private static final long serialVersionUID = -928369864146981L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "order_detail_id")
	private Long orderDetailId;

	@Basic(optional = false)
	@Column(name = "order_id")
	private Long orderId;

	@Basic(optional = false)
	@Column(name = "product_id")
	private Long productId;

	@Basic(optional = false)
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private double price;

}
