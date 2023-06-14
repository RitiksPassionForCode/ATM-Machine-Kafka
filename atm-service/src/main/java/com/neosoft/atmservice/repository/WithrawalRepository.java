package com.neosoft.atmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.atmservice.entity.Withdrawal;

public interface WithrawalRepository extends JpaRepository<Withdrawal, Long>{

}
