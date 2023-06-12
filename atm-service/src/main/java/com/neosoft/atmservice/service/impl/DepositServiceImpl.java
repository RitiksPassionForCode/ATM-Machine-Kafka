package com.neosoft.atmservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.atmservice.entity.Deposit;
import com.neosoft.atmservice.repository.DepositRepository;
import com.neosoft.atmservice.req.DepositReq;
import com.neosoft.atmservice.service.DepositService;

@Service
public class DepositServiceImpl implements DepositService{
	
	@Autowired
	private DepositRepository depositRepository;

	@Override
	public void deposit(DepositReq req) {
		
		ModelMapper modelMapper = new ModelMapper();
		Deposit deposit = modelMapper.map(req, Deposit.class);
		depositRepository.save(deposit);
	}

}
