package com.neosoft.atmservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.atmservice.dto.Account;
import com.neosoft.atmservice.entity.Withdrawal;
import com.neosoft.atmservice.processor.AccountService;
import com.neosoft.atmservice.repository.WithdrawalRepository;
import com.neosoft.atmservice.req.WithdrawReq;
import com.neosoft.atmservice.service.WithdrawalService;

@Service
public class WithdrawalServiceImpl implements WithdrawalService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private WithdrawalRepository withdarawalRepository;
	
	@Autowired
	private Account account;
	
	@Autowired
	private AccountService accountService;
	

	@Override
	public void withdraw(WithdrawReq req) {
		Withdrawal withdrawal = modelMapper.map(req, Withdrawal.class);
		withdarawalRepository.save(withdrawal);
		account.withdraw(withdrawal.getWithdrawAmount());
		accountService.kafkaAmountWithdranProducer(withdrawal.getAccountNo(), withdrawal.getWithdrawAmount());
	}
	

}
