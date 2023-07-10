package com.neosoft.atmservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.atmservice.dto.Account;
import com.neosoft.atmservice.entity.Withdrawal;
import com.neosoft.atmservice.processor.AccountService;
import com.neosoft.atmservice.repository.WithdrawalRepository;
import com.neosoft.atmservice.req.WithdrawReq;
import com.neosoft.atmservice.service.UserService;
import com.neosoft.atmservice.service.WithdrawalService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WithdrawalServiceImpl implements WithdrawalService {
	
	@Autowired
	private WithdrawalRepository withdarawalRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;	

	@Override
	public void withdraw(WithdrawReq req) {
		try {
		ModelMapper modelMapper = new ModelMapper();
		Withdrawal withdrawal = modelMapper.map(req, Withdrawal.class);
		withdarawalRepository.save(withdrawal);
		Account account = new Account(withdrawal.getAccountNo(),
				userService.getBalance(withdrawal.getAccountNo()));
		account.withdraw(withdrawal.getWithdrawAmount());
		accountService.kafkaAmountWithdranProducer(withdrawal.getAccountNo(), withdrawal.getWithdrawAmount());
		} catch (Exception e) {
			log.error("Failed to withdraw amount {} in account: {}.", req.getWidthrawAmount(), req.getAccountNo());
		}
	}
	
}
