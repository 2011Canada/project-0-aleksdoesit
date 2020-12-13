package com.revature.services;

import java.util.List;

import com.revature.models.Displayable;
import com.revature.models.Employee;

public interface EmployeeService {

	
	public Displayable login(String account_name, String password);
	
	public List<Employee> printAllAccounts();
	
}
