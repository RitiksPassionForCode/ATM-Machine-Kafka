package com.neosoft.atmservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.neosoft.atmservice.entity.User;
import com.neosoft.atmservice.req.UserReq;

@Service
public interface UserService {

	void addUser(UserReq req);

	Optional<User> getUser(Long id);

	void deleteUser(Long id);

	List<User> getAllUsers();

	User updateUser(User user, Long id);

	void deleteAllUsers();
	
	int getBalance(int accountNo);

}
