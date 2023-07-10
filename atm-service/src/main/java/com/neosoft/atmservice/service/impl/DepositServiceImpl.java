package com.neosoft.atmservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.atmservice.dto.Account;
import com.neosoft.atmservice.entity.Deposit;
import com.neosoft.atmservice.processor.AccountService;
import com.neosoft.atmservice.repository.DepositRepository;
import com.neosoft.atmservice.req.DepositReq;
import com.neosoft.atmservice.service.DepositService;
import com.neosoft.atmservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepositServiceImpl implements DepositService {

	@Autowired
	private DepositRepository depositRepository;

	@Autowired
	private AccountService accountService;

	@Autowired
	private UserService userService;

	@Override
	public void deposit(DepositReq req) {
		try {
			ModelMapper modelMapper = new ModelMapper();
			Deposit deposit = modelMapper.map(req, Deposit.class);
			depositRepository.save(deposit);
			Account account = new Account(deposit.getAccountNo(), userService.getBalance(deposit.getAccountNo()));
			account.deposit(deposit.getDepositAmount());
			accountService.kafkaAmountDepositProducer(deposit.getAccountNo(), deposit.getDepositAmount());
		} catch (Exception e) {
			log.error("Failed to deposit amount {} in account: {}.", req.getDepositAmount(), req.getAccountNo());
		}
	}

}
