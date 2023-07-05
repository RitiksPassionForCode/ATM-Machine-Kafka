package com.neosoft.atmservice.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountCreatedEvent {

	private String accountId;
    private Long userId;
    private int initialBalance;

}
