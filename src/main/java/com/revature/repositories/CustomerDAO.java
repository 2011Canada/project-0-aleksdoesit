package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.InternalErrorException;
import com.revature.models.Customer;

public interface CustomerDAO {
	
//	Data behaviours
	
	public Customer findCustomerByAccountnameAndPassword(String account_name, String password) throws AccountNotFoundException, InternalErrorException;
	
	public List<Customer> findAll();
	
	public Customer createAccount(Customer c);
}