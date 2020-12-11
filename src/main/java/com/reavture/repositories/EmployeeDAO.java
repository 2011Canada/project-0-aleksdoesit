package com.reavture.repositories;

import java.util.List;

import com.reavture.exceptions.AccountNotFoundException;
import com.reavture.exceptions.InternalErrorException;
import com.revature.models.Employee;

public interface EmployeeDAO {

	public Employee findEmployeeByAccountnameAndPassword(String account_name, String password) throws AccountNotFoundException, InternalErrorException;
	
	public List<Employee> findAll();	
	
}
