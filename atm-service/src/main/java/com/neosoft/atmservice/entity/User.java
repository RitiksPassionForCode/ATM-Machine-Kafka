package com.neosoft.atmservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class User {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String username;

	@Column
	private String bankName;

	@Column 
	private int accountNo;
	
	@Column
	private int balance;
}
