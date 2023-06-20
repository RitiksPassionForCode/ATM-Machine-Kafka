package com.neosoft.atmservice.service;

import org.springframework.stereotype.Service;

import com.neosoft.atmservice.req.WithdrawReq;

@Service
public interface WithdrawalService {

	public void withdraw(WithdrawReq req);
}
