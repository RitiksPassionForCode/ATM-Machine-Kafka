package com.neosoft.atmservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.atmservice.dto.UserDTO;
import com.neosoft.atmservice.entity.User;
import com.neosoft.atmservice.req.UserReq;
import com.neosoft.atmservice.service.UserService;

@RestController
@RequestMapping("/MBank")
public class MbankController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public void createUser(@Valid @RequestBody UserReq req) {
		userService.addUser(req);
	}
	
	@DeleteMapping("/deleteUser/{accountNo}")
	public void deleteUser(@Valid @PathVariable String accountNo) {
		userService.deleteUser(accountNo);
	}
	
	@PutMapping("/updateUser/{accountNo}")
	public void updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable String accountNo) {
		userService.updateUser(userDTO, accountNo);
	}
	
	@GetMapping("/getUser/{id}")
	public User getUser(@Valid @PathVariable Long id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUser() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/deleteAllUsers")
	public void deleteAllUser() {
		userService.deleteAllUsers();
	}
	
	@GetMapping("/getBalance/{accountNo}")
	public int getBalance(@Valid @PathVariable String accountNo) {
		return userService.getBalance(accountNo);
	}
	
}
