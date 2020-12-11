package com.revature.repositories;

import com.reavture.exceptions.AccountNotFoundException;
import com.reavture.exceptions.InternalErrorException;
import com.reavture.repositories.CustomerDAO;
import com.reavture.repositories.CustomerPostgresDAO;
import com.reavture.repositories.EmployeeDAO;
import com.reavture.repositories.EmployeePostgresDAO;

public class CustomerDAODebugger {

	public static void main(String[] args) throws AccountNotFoundException, InternalErrorException {
		// TODO Auto-generated method stub

		CustomerDAO cd = new CustomerPostgresDAO();
		
		EmployeeDAO ed = new EmployeePostgresDAO();
	
		
		System.out.println(cd.findCustomerByAccountnameAndPassword("georgie", "password"));
		System.out.println(ed.findEmployeeByAccountnameAndPassword("aleks", "123"));
	}
}
