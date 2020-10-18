package com.shashank.ecommerce.model.database;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shashank.ecommerce.enums.PaymentStatus;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_payment")
public class OrderPayment implements Serializable{
	private static final long serialVersionUID = 8354821001351356446L;

	@Id
	@Basic(optional = false)
	@Column(name = "order_id")
	private Long orderId;

	@Id
	@Basic(optional = false)
	@Column(name = "payment_id")
	private Long paymentId;

	@Basic(optional = false)
	@Column(name = "transaction_id")
	private String transactionId;

	@Basic(optional = false)
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private PaymentStatus status;

}