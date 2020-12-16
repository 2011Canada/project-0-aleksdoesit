package com.revature.menu;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import com.revature.exceptions.AccountNotCreatedException;
import com.revature.launcher.NTCLauncher;
import com.revature.models.Customer;
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

	public static void welcomeMenu() {
		System.out.println("WELCOME TO NEW TORONTO CREDIT");
		System.out.println("Please choose one of the following options: ");
		System.out.println("1. Existing Customer Login");
		System.out.println("2. New Customer Registration");
		System.out.println("3. Employee Login");
		System.out.println("0. Exit Application");
	}

	public void customerSubMenuOne(CustomerService cs) {

		@SuppressWarnings("unused")
		String dummy = this.userIn.nextLine();
		System.out.println("New Toronto Credit Login: ");
		System.out.println("Please enter your account name, then hit 'Enter':  ");
		String account_name = this.userIn.nextLine();
		System.out.println("Please enter your password, then hit 'Enter': ");
		String password = this.userIn.nextLine();
		
		
		System.out.println(this.cs.login(account_name, password).display());
		@SuppressWarnings("unused")
		String dummy2 = this.userIn.nextLine();
		customerSubMenuTwo(cs);				


	}
	
	
	private void customerSubMenuTwo(CustomerService cs) {
		
		System.out.println("What would you like to do today?");
		System.out.println("1. Make a deposit");
		System.out.println("2. Make a withdrawl");
		System.out.println("0. Return to main menu");
		int userChoice = this.userIn.nextInt();
		
		switch (userChoice) {
		
		case 1:
			
			customerDepositSubMenuOne(cs);
			break;		
			
		case 2:
			
			customerWithdrawSubMenuOne(cs);
			break;
			
		case 0:
			
			welcomeMenu();
			
			break;
		
		
		}
		
		
	}

	private void customerWithdrawSubMenuOne(CustomerService cs2) {
		
		System.out.println("Your current balance is: " + NTCLauncher.getCurrentCustomer().getTotal_balance());
		System.out.println("Please enter the amount you would like to withdraw, then hit 'Enter'");
		double userAmount = this.userIn.nextDouble();
		
		if (userAmount < NTCLauncher.getCurrentCustomer().getTotal_balance()) {
			
			double newBalance = NTCLauncher.getCurrentCustomer().getTotal_balance() - userAmount;
			
			int customerId = NTCLauncher.getCurrentCustomer().getCustomerId();
			
			cs2.makeDepositOrWithdrawl(newBalance, customerId);
			
			System.out.println("Withdrawl successful. Your new account balance is: $" + newBalance);
			
			customerSubMenuOne(cs2);
			
			NTCLauncher.NTCBankLogger.info("Customer " + NTCLauncher.getCurrentCustomer().getAccount_name() + "(" + NTCLauncher.getCurrentCustomer().getBank_Account_number() + ")" + " has made a withdrawal from their account in the amount of $" + userAmount );
			
		} else {
			
			System.out.println("Entered amount exceeds available balance, please enter a value less than your current balance of $" + NTCLauncher.getCurrentCustomer().getTotal_balance());
			
			customerSubMenuOne(cs2);
		}
		
		
		
	}

	private void customerDepositSubMenuOne(CustomerService cs2) {
		System.out.println("Your current balance is: " + NTCLauncher.getCurrentCustomer().getTotal_balance());
		System.out.println("Please enter the amount you would like to deposit, then hit 'Enter'");
		double userAmount = this.userIn.nextDouble();
		
		double newBalance = NTCLauncher.getCurrentCustomer().getTotal_balance() + userAmount;
		
		int customerId = NTCLauncher.getCurrentCustomer().getCustomerId();
		
		cs2.makeDepositOrWithdrawl(newBalance, customerId);
		
		System.out.println("Deposit successful. Your new account balance is: $" + newBalance);
		
		customerSubMenuOne(cs2);
		
		NTCLauncher.NTCBankLogger.info("Customer " + NTCLauncher.getCurrentCustomer().getAccount_name() + "(" + NTCLauncher.getCurrentCustomer().getBank_Account_number() + ")" + " has made a deposit into their account in the amount of $" + userAmount );
		
	}

	public void employeeSubMenuOne(EmployeeService es) {
		
		@SuppressWarnings("unused")
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
		

		System.out.println("1. Print all customer accounts");
		System.out.println("2. List all customer transactions");
		System.out.println("3. Return to main menu");
		int userChoice = this.userIn.nextInt();
		
		switch (userChoice) {
		
		case 1:
			
			System.out.println(cd.findAll());
			
			employeeSubMenuTwo(es);
		
			break;		
			
		case 2:
			
			es.customerTransactionPrint();
			
			employeeSubMenuTwo(es);
			
			break;
			
		case 3:
			
			welcomeMenu();
			
			break;
		
		
		}
		
	}

	public void newCustomerSubMenuOne(CustomerDAO cd) throws AccountNotCreatedException {
		
		@SuppressWarnings("unused")
		String dummy = this.userIn.nextLine();
		int accountNumber = 10000 + new Random().nextInt(90000);
		System.out.println("Welcome to New Toronto Credit new customer registration");
		System.out.println("Please tell us your full name, then hit 'Enter :'");
		String customer_name = this.userIn.nextLine();
		System.out.println("To create a new account please enter an Account Name, then hit 'Enter :'");
		String account_name = this.userIn.nextLine();
		System.out.println("Now enter a password you would like to associate with your new account, then hit 'Enter :'");
		String password = this.userIn.nextLine();
		Customer c = new Customer(account_name, password, customer_name, 0, accountNumber);
		cd.createAccount(c);
		System.out.println("Account Created Successfully!");
		NTCLauncher.NTCBankLogger.info("New customer " + customer_name + " has successfully opened a new account.");
		System.out.println("Please enter zero (0) to return to the main menu and login to use your new account");
		
		int userChoice = this.userIn.nextInt();
		
		switch (userChoice) {
		
		case 0:
			
			welcomeMenu();
		
			break;	
			
		}
	}
	

	public void mainMenu() throws AccountNotCreatedException {

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
						
						newCustomerSubMenuOne(cd);
						
						break;

					case 3:
						
						employeeSubMenuOne(es);
						
						break;

					case 0:
						
						System.out.println("Thank you for visiting New Toronto Credit, please come back soon.");
						validSelection = false;
						System.exit(0);
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