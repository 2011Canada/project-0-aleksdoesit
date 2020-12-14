package com.revature.services;

import java.util.List;

import com.revature.models.Customer;
import com.revature.models.Displayable;

public interface CustomerService {
	
	public Displayable login(String account_name, String password);
	
	public List<Customer> printAllAccounts();

	public void makeDepositOrWithdrawl(double newBalance, int customerId);
	
}
