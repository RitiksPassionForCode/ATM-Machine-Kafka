package com.neosoft.atmservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Withdrawal {


	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private int withdrawAmount;
	
	@Column
	private Date date;
	
}
