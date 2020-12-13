package com.revature.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Displayable;
import com.revature.services.CustomerService;

public class NTCMenu {
	
	private CustomerService cs;

	
//	List<Displayable> lines;
	
	public void welcomeMenu() {
		
		Scanner userIn = new Scanner(System.in);
		
		boolean validSelection = false;
		
		int userChoice = -10;
		
		do {
			
			System.out.println("WELCOME TO NEW TORONTO CREDIT");
			System.out.println("Please choose one of the following options: ");
			System.out.println("1. Existing Customer Login");
			System.out.println("2. New Customer Registration");
			System.out.println("3. Employee Login");
			System.out.println("0. Exit Application");
			
			
			try {	
				userChoice = userIn.nextInt();
				
				if(userChoice >= 0 && userChoice < 4) {
					
					System.out.println("worked?");
					
				} else {
					
					System.out.println("Please make a valid selection.");
					
					validSelection = false;
					userIn.next();
					
				}
			} catch(InvalidChoiceSelection e) {
				
			}
			
			
		} while (!validSelection) ;
			
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