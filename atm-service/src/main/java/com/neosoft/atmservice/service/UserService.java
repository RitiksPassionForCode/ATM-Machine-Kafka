package com.neosoft.atmservice.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.neosoft.atmservice.req.UserReq;

@Service
public interface UserService {

	public void addUser(UserReq req);
}
