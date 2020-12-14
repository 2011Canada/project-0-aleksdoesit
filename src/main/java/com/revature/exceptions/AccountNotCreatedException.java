package com.revature.exceptions;

public class AccountNotCreatedException extends Exception {
	public AccountNotCreatedException() {
		super("Account not created due to error, please try a new account name");
	}
}
