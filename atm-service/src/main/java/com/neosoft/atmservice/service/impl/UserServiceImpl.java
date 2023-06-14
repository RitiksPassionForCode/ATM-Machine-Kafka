package com.neosoft.atmservice.service.impl;

import java.util.List;
import java.util.Optional;

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
	
	@Override
	public Optional<User> getUser(Long id) {
		return repository.findById(id);
	}
	
	@Override
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}
	
	@Override
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	@Override
	public User updateUser(User user, Long id) {
		User updatedUser = new User();
		Optional<User> findById = repository.findById(id);
		if(findById.isPresent()) {
			updatedUser = repository.save(user);
		}
		return updatedUser;
	}
	
	@Override
	public void deleteAllUsers() {
		repository.deleteAll();
	}

}
