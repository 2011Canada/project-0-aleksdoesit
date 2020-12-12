package com.revature.exceptions;

public class AccountNotFoundException extends Exception {
	public AccountNotFoundException() {
		super("The account you entered could not found");
	}
}
