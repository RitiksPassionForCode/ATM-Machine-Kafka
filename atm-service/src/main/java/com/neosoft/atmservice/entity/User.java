package com.neosoft.atmservice.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity
@Data
public class User {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String userName;

	@Column
	private int balance;

	@Column
//	@ManyToOne(fetch = FetchType.LAZY)
	private String accountNumber;

	@Column(name="user_registered_date")
	private LocalDateTime date;

}
