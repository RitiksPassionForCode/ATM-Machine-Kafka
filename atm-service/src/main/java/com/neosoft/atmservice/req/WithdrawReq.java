package com.neosoft.atmservice.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WithdrawReq {

	int widthrawAmount;
	
	int balance;
	
	int withdrawLimit;
	
}
