package com.neosoft.atmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.atmservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
