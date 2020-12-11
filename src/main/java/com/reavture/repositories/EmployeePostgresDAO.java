package com.reavture.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.reavture.exceptions.AccountNotFoundException;
import com.reavture.exceptions.InternalErrorException;
import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class EmployeePostgresDAO implements EmployeeDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public Employee findEmployeeByAccountnameAndPassword(String account_name, String password)
			throws AccountNotFoundException, InternalErrorException {
				
		Connection conn = cf.getConnection();
		
		try {

			String sql = "select * from employees where \"account_name\" = ? and \"password\" = ? ;";
			PreparedStatement getEmployee = conn.prepareStatement(sql);
			getEmployee.setString(1, account_name);
			getEmployee.setString(2, password);
			
			ResultSet res = getEmployee.executeQuery();
			if(res.next()) {
				
				Employee e = new Employee();
				
				e.setEmployee_id(res.getInt("employee_id"));
				e.setEmployee_name(res.getString("employee_name"));
				e.setAccount_name(res.getString("account_name"));
				e.setPassword(res.getString("password"));
				
				return e;
				
			} else {
				throw new AccountNotFoundException();
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			throw new InternalErrorException();
			
		} finally {
			
			cf.releaseConnection(conn);
			
		}
	}

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
