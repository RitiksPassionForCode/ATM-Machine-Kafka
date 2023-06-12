package com.neosoft.atmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.atmservice.entity.Withdrawal;

@Repository
public interface WithrawalRepository extends JpaRepository<Withdrawal, Long>{

}
