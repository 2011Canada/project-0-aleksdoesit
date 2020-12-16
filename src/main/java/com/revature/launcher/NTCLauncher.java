package com.revature.launcher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.exceptions.AccountNotCreatedException;
import com.revature.menu.NTCMenu;
import com.revature.models.Customer;
import com.revature.models.Employee;

public class NTCLauncher {
	
	public static Logger NTCBankLogger = LogManager.getLogger("com.revature.NTCBank");
	
	private static Customer currentCustomer;
	private static Employee currentEmployee;

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

	public static void main(String[] args) throws AccountNotCreatedException {

		
		NTCMenu menu = new NTCMenu();
		
		menu.mainMenu();
		
	}
}
