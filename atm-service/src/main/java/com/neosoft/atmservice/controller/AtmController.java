package com.neosoft.atmservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.atmservice.req.DepositReq;
import com.neosoft.atmservice.req.UserReq;
import com.neosoft.atmservice.req.WithdrawReq;
import com.neosoft.atmservice.service.DepositService;
import com.neosoft.atmservice.service.UserService;
import com.neosoft.atmservice.service.WithdrawalService;

@RestController
@RequestMapping("/ATM")
public class AtmController {
	
	@Autowired
	private DepositService depositService;
	
	@Autowired
	private WithdrawalService withdrawalService;
	
	@PostMapping("/deposit")
	public void deposit(@Valid DepositReq req) {
		depositService.deposit(req);
	}
	
	@PostMapping("/withdrawal")
	public void withdraw(@Valid WithdrawReq req) {
		withdrawalService.withdraw(req);
	}
	
	@GetMapping("/getBalance/{id}")
	public void getUser(@Valid int id) {
		withdrawalService.getBalance(id);
	}
}
