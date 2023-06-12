package com.neosoft.atmservice.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserReq {

	private String userName;
	
	private String bankName;
	
	private int accountNo;
}
