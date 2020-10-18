package com.shashank.ecommerce.model.database;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_addresses")
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "address_id")
	private Long addressId;

	@Basic(optional = false)
	@Column(name = "user_id")
	private String userId;

	@Basic(optional = false)
	@Column(name = "address")
	private String address;

	@Basic(optional = false)
	@Column(name = "phone")
	private String phone;

	@Basic(optional = false)
	@Column(name = "city")
	private String city;

	@Basic(optional = false)
	@Column(name = "country")
	private String country;

	@Basic(optional = false)
	@Column(name = "status")
	private Boolean status;
}