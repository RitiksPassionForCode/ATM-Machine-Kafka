package com.neosoft.atmservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class User {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String userName;
	
	@Column
	private int balance;
	
	@Column
	@ManyToOne(fetch = FetchType.LAZY)
	private volatile String accountNo;
	
	@Column
	private Date date;

}
