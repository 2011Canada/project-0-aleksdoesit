package com.revature.launcher;

import java.sql.Connection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Customer;
import com.revature.models.Employee;

public class NTCLauncher {
	
	private static Customer currentCustomer;
	private static Employee currentEmployee;
	
	
	
//	public static Logger e720Logger = LogManager.getLogger("com.revature.e720");

	public static Customer getCurrentCustomer() {
		return currentCustomer;
	}
	
	public static Employee getCurrentEmployee() {
		return currentEmployee;
	}



	public static void setCurrentCustomer(Customer currentCustomer) {
		NTCLauncher.currentCustomer = currentCustomer;
	}


	public static void setCurrentEmployee(Employee currentEmployee) {
		NTCLauncher.currentEmployee = currentEmployee;
	}

	public static void main(String[] args) {

		
		System.out.println("hello world!");
		
	}
}
