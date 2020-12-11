package com.reavture.repositories;

import java.util.List;

import com.reavture.exceptions.AccountNotFoundException;
import com.reavture.exceptions.InternalErrorException;
import com.revature.models.Customer;

public interface CustomerDAO {
	
	public Customer findCustomerByAccountnameAndPassword(String account_name, String password) throws AccountNotFoundException, InternalErrorException;
	
	public List<Customer> findAll();
}