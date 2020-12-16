package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.revature.exceptions.AccountNotCreatedException;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.InternalErrorException;
import com.revature.models.Customer;
import com.revature.services.CustomerService;
import com.revature.services.CustomerServiceImplementation;

public class DAODebugger {

	public static void main(String[] args) throws AccountNotFoundException, InternalErrorException, AccountNotCreatedException {

		CustomerDAO cd = new CustomerPostgresDAO();
		
		EmployeeDAO ed = new EmployeePostgresDAO();
		
//		List<Customer> accounts = cl.printAllAccounts();
		
		int accountNumber = 10000 + new Random().nextInt(90000);
		
		Customer c = new Customer("jt", "password", "Justin Trudeau", 0, accountNumber);
		
		System.out.println(cd.findCustomerByAccountnameAndPassword("georgie", "password"));
		System.out.println(ed.findEmployeeByAccountnameAndPassword("aleks", "123"));
		System.out.println(cd.findAll());
		cd.createAccount(c);
		
	}
}
