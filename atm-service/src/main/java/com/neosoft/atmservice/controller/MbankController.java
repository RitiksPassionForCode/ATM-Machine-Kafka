package com.neosoft.atmservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.atmservice.entity.User;
import com.neosoft.atmservice.req.UserReq;
import com.neosoft.atmservice.service.UserService;

@RestController
@RequestMapping("/MBank")
public class MbankController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/createUser")
	public void createUser(@Valid UserReq req) {
		userService.addUser(req);
	}
	
	@PostMapping("/deleteUser/{id}")
	public void createUser(@Valid @PathVariable Long id) {
		userService.deleteUser(id);
	}
	
	@PutMapping("/updateUser/{id}")
	public void updateUser(@Valid User user, @PathVariable Long id) {
		userService.updateUser(user, id);
	}
	
	@GetMapping("/getUser/{id}")
	public void getUser(@Valid @PathVariable Long id) {
		userService.getUser(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUser() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/deleteAllUsers")
	public void createUser() {
		userService.deleteAllUsers();
	}
	
	@GetMapping("/getBalance/{accountNo}")
	public int getBalance(@Valid int accountNo) {
		return userService.getBalance(accountNo);
	}
	
}
