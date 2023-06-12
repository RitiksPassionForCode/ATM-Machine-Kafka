package com.neosoft.atmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.atmservice.entity.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long>{

}
