package com.revature.services;

import com.revature.models.Displayable;

public interface CustomerService {
	
	public Displayable login(String account_name, String password);
	
}
