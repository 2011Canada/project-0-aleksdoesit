package com.reavture.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.reavture.exceptions.AccountNotFoundException;
import com.reavture.exceptions.InternalErrorException;
import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;

public class CustomerPostgresDAO implements CustomerDAO {
		
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();

	public Customer findCustomerByAccountnameAndPassword(String account_name, String password)
			throws AccountNotFoundException, InternalErrorException {
		
		Connection conn = cf.getConnection();
		
		try {
			
			String sql = "select * from customers where \"account_name\" = ? and \"password\" = ? ;"; 
			PreparedStatement getCustomer = conn.prepareStatement(sql);
			getCustomer.setString(1, account_name);
			getCustomer.setString(2, password);
			
			ResultSet res = getCustomer.executeQuery();
			
			if(res.next()) {
				
				Customer c = new Customer();
				
				c.setCustomerId(res.getInt("customer_id"));
				c.setName(res.getString("customer_name"));
				c.setAccount_name(res.getString("account_name"));
				c.setPassword(res.getString("password"));
				c.setTotal_balance(res.getDouble("total_balance"));
				c.setBank_Account_number(res.getInt("bank_account_number"));
				
				return c;
				
				
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

	public List<Customer> findAll() {

		return null;
	}
	
	
	
	
}

