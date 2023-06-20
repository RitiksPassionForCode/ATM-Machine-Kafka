package com.neosoft.atmservice.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyDepositedEvent {

	private String accountId;
    private int amount;
}
