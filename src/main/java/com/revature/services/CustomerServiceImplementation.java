package com.revature.services;

import java.util.List;

import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.InternalErrorException;
import com.revature.launcher.NTCLauncher;
import com.revature.models.Customer;
import com.revature.models.Displayable;
import com.revature.repositories.CustomerDAO;

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


	@Override
	public List<Customer> printAllAccounts() {
		// TODO Auto-generated method stub
		return cd.findAll();
	}
	
}
