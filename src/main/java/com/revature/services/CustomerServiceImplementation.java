package com.revature.services;

import com.reavture.exceptions.AccountNotFoundException;
import com.reavture.exceptions.InternalErrorException;
import com.reavture.repositories.CustomerDAO;
import com.revature.launcher.NTCLauncher;
import com.revature.models.Customer;
import com.revature.models.Displayable;

public class CustomerServiceImplementation implements CustomerService {

	private CustomerDAO cd;
	
	public CustomerServiceImplementation(CustomerDAO cd) {
		this.cd = cd;
	}

	
	@Override
	public Displayable login(String account_name, String password) {
		
		try {
			
			Customer c = cd.findCustomerByAccountnameAndPassword(account_name, password);
			NTCLauncher.setCurrentCustomer(c);
			return c;
			
			
		} catch (AccountNotFoundException | InternalErrorException e) {
			return ()->e.getMessage();
		}
	}
	
}
