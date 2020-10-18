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
@Table(name = "sellers")
public class Seller implements Serializable{

	private static final long serialVersionUID = -9040115932866051096L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "seller_id")
	private Integer sellerId;

	@Basic(optional = false)
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Basic(optional = false)
	@Column(name = "status")
	private Boolean status;

	@Basic(optional = false)
	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

}