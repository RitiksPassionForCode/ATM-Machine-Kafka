package com.neosoft.atmservice.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.atmservice.entity.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByAccountNumber(String accountNumber);
	
	void deleteByAccountNumber(String accountNumber);

}
