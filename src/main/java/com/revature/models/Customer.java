package com.revature.models;

public class Customer {
	
	private int customerId;
	
	private String account_name;
	
	private String password;
	
	private String name;
	
	private int bank_account_number;
	
	private double total_balance;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String account_name, String password, String name, int account_number,
			double total_balance, int bank_account_number) {
		super();
		this.customerId = customerId;
		this.account_name = account_name;
		this.password = password;
		this.name = name;
		this.bank_account_number = bank_account_number;
		this.total_balance = total_balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBank_Account_number() {
		return bank_account_number;
	}

	public void setBank_Account_number(int account_number) {
		this.bank_account_number = account_number;
	}

	public double getTotal_balance() {
		return total_balance;
	}

	public void setTotal_balance(double d) {
		this.total_balance = d;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", account_name=" + account_name + ", password=" + password
				+ ", name=" + name + ", bank_account_number=" + bank_account_number + ", total_balance=" + total_balance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		double result = 1;
		result = prime * result + ((account_name == null) ? 0 : account_name.hashCode());
		result = prime * result + bank_account_number;
		result = prime * result + customerId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + total_balance;
		return (int) result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (account_name == null) {
			if (other.account_name != null)
				return false;
		} else if (!account_name.equals(other.account_name))
			return false;
		if (bank_account_number != other.bank_account_number)
			return false;
		if (customerId != other.customerId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (total_balance != other.total_balance)
			return false;
		return true;
	}
}