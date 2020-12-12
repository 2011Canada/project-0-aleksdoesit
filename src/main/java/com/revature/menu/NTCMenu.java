package com.revature.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Displayable;
import com.revature.services.CustomerService;

public class NTCMenu implements Displayable {
	
	private CustomerService cs;
	
	Scanner userIn;
	
	List<Displayable> lines;
	
	
	public loginMenu(CustomerService cs) {
		
			this.cs = cs;
			this.lines = new ArrayList<Displayable>();
			
			lines.add(()->"WELCOME TO NEW TORONTO CREDIT\" + \"\\n\" + \"Please press Enter to login");
			this.userIn = new Scanner(System.in);
	}
	
	@Override
	public String display() {
		String display = "Press Enter to login";
		return display;
	}
	
	
	public void manageUserLogin() {
//		create a different menu but this works well for validation
//		if else blocks, but we'll still use this method to check login credentials disregard rest.
		String dummy = this.userIn.nextLine();
		System.out.println("Please enter your Account Name");
		String accountName = this.userIn.nextLine();
		System.out.println("Please enter your Password");
		String password = this.userIn.nextLine();
		this.cs.login(account_name, password).display();
		
	}

}
