package com.neosoft.atmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.atmservice.dto.Account;
import com.neosoft.atmservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Account findByAccountNumber(String accountNumber);

}
