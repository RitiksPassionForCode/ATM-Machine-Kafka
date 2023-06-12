package com.neosoft.atmservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public void createUser(@Valid int id) {
		userService.deleteUser(id);
	}
	
	@PostMapping("/updateUser/{id}")
	public void updateUser(@Valid int id) {
		userService.updateUser(id);
	}
	
	@GetMapping("/getUser/{id}")
	public void getUser(@Valid int id) {
		userService.getUser(id);
	}
	
}
