package com.revature.models;

public class Employee {
	
	private int employee_id;
	
	private String account_name;
	
	private String password;
	
	private String employee_name;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int employee_id, String account_name, String password, String employee_name) {
		super();
		this.employee_id = employee_id;
		this.account_name = account_name;
		this.password = password;
		this.employee_name = employee_name;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
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

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", account_name=" + account_name + ", password=" + password
				+ ", employee_name=" + employee_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_name == null) ? 0 : account_name.hashCode());
		result = prime * result + employee_id;
		result = prime * result + ((employee_name == null) ? 0 : employee_name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (account_name == null) {
			if (other.account_name != null)
				return false;
		} else if (!account_name.equals(other.account_name))
			return false;
		if (employee_id != other.employee_id)
			return false;
		if (employee_name == null) {
			if (other.employee_name != null)
				return false;
		} else if (!employee_name.equals(other.employee_name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	

}
