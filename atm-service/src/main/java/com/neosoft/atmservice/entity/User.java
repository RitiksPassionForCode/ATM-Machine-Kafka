package com.neosoft.atmservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class User {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String username;
	
	@Column
	private int balance;
	
	@Column
	@ManyToOne(fetch = FetchType.LAZY)
	private volatile int accountNo;

}
