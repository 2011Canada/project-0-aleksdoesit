package com.revature.menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.revature.launcher.Entertainment720Launcher;
import com.revature.launcher.NTCLauncher;
import com.revature.models.Displayable;
import com.revature.repositories.CustomerDAO;
import com.revature.repositories.CustomerPostgresDAO;
import com.revature.repositories.EmployeeDAO;
import com.revature.repositories.EmployeePostgresDAO;
import com.revature.services.CustomerService;
import com.revature.services.CustomerServiceImplementation;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImplementation;

public class NTCMenu {
	
	private CustomerDAO cd = new CustomerPostgresDAO();

	private CustomerService cs = new CustomerServiceImplementation(cd);
	
	private EmployeeDAO ed = new EmployeePostgresDAO();
	
	private EmployeeService es = new EmployeeServiceImplementation(ed);

	Scanner userIn = new Scanner(System.in);

	int userChoice = -10;

	public void welcomeMenu() {
		System.out.println("WELCOME TO NEW TORONTO CREDIT");
		System.out.println("Please choose one of the following options: ");
		System.out.println("1. Existing Customer Login");
		System.out.println("2. New Customer Registration");
		System.out.println("3. Employee Login");
		System.out.println("0. Exit Application");
	}

	public void customerSubMenuOne(CustomerService cs) {

		String dummy = this.userIn.nextLine();
		System.out.println("New Toronto Credit Login: ");
		System.out.println("Please enter your account name, then hit 'Enter':  ");
		String account_name = this.userIn.nextLine();
		System.out.println("Please enter your password, then hit 'Enter': ");
		String password = this.userIn.nextLine();
		System.out.println(this.cs.login(account_name, password).display());
		
		if (this.cs.login(account_name, password).accountExists) {
			
			customerSubMenuTwo(cs);
			
		} else {
			
			System.out.println("Please enter a valid account name and password");
			
		}

	}
	
	
	private void customerSubMenuTwo(CustomerService cs) {
		
		System.out.println("BIG FFARTS ITS WORKING!");
		System.out.println();
		System.out.println();
		int userChoice = this.userIn.nextInt();
		
		
	}

	public void employeeSubMenuOne(EmployeeService es) {
		
		String dummy = this.userIn.nextLine();
		System.out.println("New Toronto Credit Employee Login: ");
		System.out.println("Please enter your account name, then hit 'Enter':  ");
		String account_name = this.userIn.nextLine();
		System.out.println("Please enter your password, then hit 'Enter': ");
		String password = this.userIn.nextLine();
		System.out.println(this.es.login(account_name, password).display());
		if(NTCLauncher.getCurrentEmployee() != null) {		
			
			employeeSubMenuTwo(es);
			
		} else {
			
			System.out.println("Please make a valid selection");
			
		}
		
		
	}
	
	public void employeeSubMenuTwo(EmployeeService es) {
		
//		String dummy = this.userIn.nextLine();
		System.out.println("1. Print all customer accounts");
		System.out.println("2. Approve new customer accounts");
		System.out.println("3. Return to main menu");
		int userChoice = this.userIn.nextInt();
		
		switch (userChoice) {
		
		case 1:
			
			CustomerDAO cd = new CustomerPostgresDAO();
			
			System.out.println(cd.findAll());
		
			break;		
			
		case 2:
			
			break;
			
		case 3:
			
			welcomeMenu();
			
			break;
		
		
		}
		
	}

	public void mainMenu() {

		boolean validSelection = false;
		welcomeMenu();

		do {

			userChoice = userIn.nextInt();

			try {

				if (userChoice >= 0 && userChoice < 4) {

					switch (userChoice) {

					case 1:

						customerSubMenuOne(cs);

						break;

					case 2:

						break;

					case 3:
						
						employeeSubMenuOne(es);
						
						break;

					case 0:
						
						validSelection = false;

						break;

					}
				} else {

					System.out.println("Please make a valid selection");
					validSelection = false;

				}

			} catch (InputMismatchException e) {

				System.out.println("Please make a valid selection.");
				validSelection = false;

			}

		} while (!validSelection);

		System.out.println(userChoice);

	}

}

//	public void manageUserLogin() {
//		create a different menu but this works well for validation
//		if else blocks, but we'll still use this method to check login credentials disregard rest.
//		String dummy = this.userIn.nextLine();
//		System.out.println("Please enter your Account Name");
//		String accountName = this.userIn.nextLine();
//		System.out.println("Please enter your Password");
//		String password = this.userIn.nextLine();
//		this.cs.login(account_name, password).display();
//		
//	}