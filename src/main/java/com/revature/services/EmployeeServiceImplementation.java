package com.revature.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.InternalErrorException;
import com.revature.launcher.NTCLauncher;
import com.revature.models.Displayable;
import com.revature.models.Employee;
import com.revature.repositories.EmployeeDAO;

public class EmployeeServiceImplementation implements EmployeeService {
	
	private EmployeeDAO ed;
	
	BufferedReader reader;
	
	public EmployeeServiceImplementation(EmployeeDAO ed) {
		this.ed = ed;
	}
	

	@Override
	public Displayable login(String account_name, String password) {
		
		try {
			
			Employee e = ed.findEmployeeByAccountnameAndPassword(account_name, password);
			NTCLauncher.setCurrentEmployee(e);
			return e;
			
		} catch (AccountNotFoundException | InternalErrorException e) {
			return ()->e.getMessage();
		}
	}

	@Override
	public List<Employee> printAllAccounts() {
		// TODO Auto-generated method stub
		return ed.findAll();
	}
	
	public void customerTransactionPrint() {
		
		try {
			
			reader = new BufferedReader(new FileReader ("/Users/nikol/Desktop/Code/Revature/RevatureProjects/project-0-aleksdoesit/trace.log"));
			
			String line = reader.readLine();
			
			while (line != null) {
				
				System.out.println(line);
				
				line = reader.readLine();
				
			}
			
			reader.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
