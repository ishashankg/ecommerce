package com.shashank.ecommerce.model.database;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

	@Id
	@Basic(optional = false)
	@Column(name = "user_id")
	private String userId;

	@Basic(optional = false)
	@Column(name = "role_id")
	private int roleId;

	@Basic(optional = false)
	@Column(name = "email")
	private String email;

	@Basic(optional = false)
	@Column(name = "password")
	private String password;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Basic(optional = false)
	@Column(name = "status")
	private Boolean status;

	@Basic(optional = false)
	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

}