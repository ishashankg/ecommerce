package com.shashank.ecommerce.model.database;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.shashank.ecommerce.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert
@DynamicUpdate
@Table(name = "orders")
@XmlRootElement
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "order_id")
	private Long orderId;

	@Basic(optional = false)
	@Column(name = "user_id")
	private String userId;
	
	@Basic(optional = false)
	@Column(name = "address_id")
	private Long addressId;

	@Basic(optional = false)
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Column(name = "items_count")
	private Integer itemsCount;

	@Column(name = "items_quantity")
	private BigDecimal itemsQuantity;

	@Column(name = "grand_total")
	private BigDecimal grandTotal;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private OrderStatus orderStatus;
}
