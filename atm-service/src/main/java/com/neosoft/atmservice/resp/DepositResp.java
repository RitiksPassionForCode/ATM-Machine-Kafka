package com.neosoft.atmservice.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositResp {

	private boolean status;
	
	private String message;
}
