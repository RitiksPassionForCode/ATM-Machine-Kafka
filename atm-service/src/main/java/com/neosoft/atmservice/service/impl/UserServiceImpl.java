package com.neosoft.atmservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.atmservice.entity.User;
import com.neosoft.atmservice.processor.AccountService;
import com.neosoft.atmservice.repository.UserRepository;
import com.neosoft.atmservice.req.UserReq;
import com.neosoft.atmservice.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountService accountService;

	@Override
	public void addUser(UserReq req) {
		try {
			ModelMapper modelMapper = new ModelMapper();
			User user = modelMapper.map(req, User.class);
			userRepository.save(user);
			accountService.kafkaUserCreatedProducer(user.getAccountNumber(), user.getId(), 0);
		} catch (Exception e) {
			log.error("Failed to add User: {}", req.getUserName());
		}
	}

	@Override
	public Optional<User> getUser(Long id) {
		Optional<User> findById = Optional.ofNullable(null);
		try {
			findById = userRepository.findById(id);
		} catch (Exception e) {
			log.error("Failed to get User with Id: {}", id);
		}
		return findById;
	}

	@Override
	public void deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			log.error("Failed to delete User with Id: {}", id);
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> findAll = new ArrayList<>();
		try {
			findAll = userRepository.findAll();
		} catch (Exception e) {
			log.error("Failed to get all Users.");
		}
		return findAll;
	}

	@Override
	public User updateUser(User user, Long id) {
		Optional<User> findById = Optional.ofNullable(user);
		User updatedUser = new User();
		try {
			findById = userRepository.findById(id);
			if (findById.isPresent()) {
				updatedUser = userRepository.save(user);
			}
		} catch (Exception e) {
			log.error("Failed to update User {}.", updatedUser.getUserName());
		}
		return updatedUser;
	}

	@Override
	public void deleteAllUsers() {
		try {
			userRepository.deleteAll();
		} catch (Exception e) {
			log.error("Failed to delete all Users.");
		}
	}

	@Override
	public int getBalance(int accountNumber) {
		User user = new User();
		try {
			user = userRepository.getByAccountNumber(accountNumber);
		} catch(Exception e) {
			log.error("Failed to get balance of User: {} with AccountNo: {}.", user.getUserName(), accountNumber);
		}	
		return user.getBalance();
	}

}
