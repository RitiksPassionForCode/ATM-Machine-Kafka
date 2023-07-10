package com.neosoft.atmservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neosoft.atmservice.dto.UserDTO;
import com.neosoft.atmservice.entity.User;
import com.neosoft.atmservice.req.UserReq;

@Service
public interface UserService {

	void addUser(UserReq req);

	User getUser(Long id);

	void deleteUser(String acccountNo);

	List<User> getAllUsers();

	void updateUser(UserDTO userDTO, String accountNumber);

	void deleteAllUsers();
	
	int getBalance(String accountNo);


}
