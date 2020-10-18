package com.shashank.ecommerce.model.database;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "seller_products")
public class SellerProduct implements Serializable{

	private static final long serialVersionUID = -7823319012267706951L;

	@Id
	@Basic(optional = false)
	@Column(name = "product_id")
	private int productId;

	@Id
	@Basic(optional = false)
	@Column(name = "supplier_id")
	private int supplierId;

}
