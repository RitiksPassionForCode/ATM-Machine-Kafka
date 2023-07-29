package com.neosoft.atmservice.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.atmservice.dto.UserDTO;
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
		User user = new User();
		Optional<User> userByAccountNo = Optional.ofNullable(user);
		try {
			userByAccountNo = userRepository.findByAccountNumber(req.getAccountNumber());
			if (userByAccountNo.isPresent()) {
				log.info("User already exist for Account Number : {}.", req.getAccountNumber());
			} else {
				ModelMapper modelMapper = new ModelMapper();
				user = modelMapper.map(req, User.class);
				user.setDate(LocalDateTime.now());
				log.info("User: {}", user);
				userRepository.save(user);
			}
		} catch (Exception e) {
			log.error("Failed to add User: {} Cause: {}", req.getUserName(), e.getCause());
		}
		accountService.kafkaUserCreatedProducer(user.getAccountNumber(), user.getId(), 0);
	}

	@Override
	public User getUser(Long id) {
		Optional<User> findById = Optional.empty();
		User user = new User();
		try {
			findById = userRepository.findById(id);
			user = findById.isPresent() ? findById.get() : Optional.ofNullable(user).get();
		} catch (Exception e) {
			log.error("Failed to get User with Id: {} Cause: {}", id, e.getCause());
		}
		return user;
	}

	@Override
	public void deleteUser(String accountNo) {
		User user = new User();
		Optional<User> userByAccountNo = Optional.ofNullable(user);
		try {
			userByAccountNo = userRepository.findByAccountNumber(accountNo);
			if (userByAccountNo.isPresent()) {
				userRepository.deleteByAccountNumber(accountNo);
			} else {
				log.info("User not found for Account Number: {}", accountNo);
			}
		} catch (Exception e) {
			log.error("Failed to delete User with AccountNumber: {} Cause: {}", accountNo, e.getCause());
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> findAll = new ArrayList<>();
		try {
			findAll = userRepository.findAll();
		} catch (Exception e) {
			log.error("Failed to get all Users. Cause: {}", e.getCause());
		}
		return findAll;
	}

	@Override
	public void updateUser(UserDTO userDTO, String accountNumber) {
		User user = new User();
		Optional<User> userByAccountNo = Optional.ofNullable(user);
		try {
			userByAccountNo = userRepository.findByAccountNumber(accountNumber);
			if (userByAccountNo.isPresent()) {
				userByAccountNo.get().setUserName(userDTO.getUserName());
				userByAccountNo.get().setAccountNumber(userDTO.getAccountNo());
				userRepository.save(userByAccountNo.get());
			} else {
				log.info("User not present with Account Number: {} to update details.", accountNumber);
			}
		} catch (Exception e) {
			log.error("Failed to update User: {} Cause: {}.",
					userByAccountNo.isPresent() ? userByAccountNo.get().getUserName() : userByAccountNo, e.getCause());
		}
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
	public int getBalance(String accountNumber) {
		User user = new User();
		Optional<User> userByAccountNo = Optional.ofNullable(user);
		try {
			userByAccountNo = userRepository.findByAccountNumber(accountNumber);
		} catch (Exception e) {
			log.error("Failed to get balance of User: {} with AccountNo: {}.", user.getUserName(), accountNumber);
		}
		return userByAccountNo.isPresent() ? userByAccountNo.get().getBalance() : user.getBalance();
	}

}
