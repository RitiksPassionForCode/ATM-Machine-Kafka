package com.neosoft.atmservice.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyWithdrawnEvent {

	private String accountNo;
    private double amount;
}
