package com.neosoft.atmservice.service;

import org.springframework.stereotype.Service;

import com.neosoft.atmservice.req.WithdrawReq;

@Service
public interface WithdrawalService {

	void withdraw(WithdrawReq req);
	
}
