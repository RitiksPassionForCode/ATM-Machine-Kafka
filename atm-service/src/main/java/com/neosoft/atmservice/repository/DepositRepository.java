package com.neosoft.atmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.atmservice.entity.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long>{

}
