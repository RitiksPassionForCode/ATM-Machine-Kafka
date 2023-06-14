package com.neosoft.atmservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

	private String transactionId;
    private String accountNumber;
    private String transactionType;
    private double amount;
}
