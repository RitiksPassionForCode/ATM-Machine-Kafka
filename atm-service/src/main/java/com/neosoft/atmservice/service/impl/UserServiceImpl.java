package com.neosoft.atmservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.atmservice.entity.User;
import com.neosoft.atmservice.repository.UserRepository;
import com.neosoft.atmservice.req.UserReq;
import com.neosoft.atmservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public void addUser(UserReq req) {	
		ModelMapper modelMapper = new ModelMapper();
		User user = modelMapper.map(req, User.class);
		repository.save(user);
	}

}
