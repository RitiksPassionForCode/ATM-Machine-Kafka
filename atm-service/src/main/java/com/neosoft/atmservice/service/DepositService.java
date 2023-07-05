package com.neosoft.atmservice.service;

import org.springframework.stereotype.Service;

import com.neosoft.atmservice.req.DepositReq;

@Service
public interface DepositService {

	void deposit(DepositReq req);
}
