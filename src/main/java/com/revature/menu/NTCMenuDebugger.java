package com.revature.menu;

import com.revature.exceptions.AccountNotCreatedException;
import com.revature.models.Customer;

public class NTCMenuDebugger {
	
	private static Customer currentCustomer;

	public static void setCurrentCustomer(Customer currentCustomer) {
		NTCMenuDebugger.currentCustomer = currentCustomer;
	}
	
	public static Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public static void main(String[] args) throws AccountNotCreatedException {
		
		NTCMenu menu = new NTCMenu();
		
		menu.mainMenu();

	}

}
