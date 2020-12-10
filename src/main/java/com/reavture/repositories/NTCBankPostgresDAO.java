package com.reavture.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.BankAccount;
import com.revature.models.Employee;
import com.revature.util.ConnectionFactory;

public class NTCBankPostgresDAO implements NTCBankDAO {
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public List<NTCBank> findAll() {
		Connection conn = this.cf.getConnection();
		
		List<Employee> all = new ArrayList<Employee>();
		
		try {
			
			String sql = "select * from employees";
			Statement s  = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			
			while(res.next()) {
//			create new employee
				Employee e = new Employee();
				e.setName(res.getString("name"));
				all.add(e);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return all;
	}
	
	public BankAccount saveOne(BankAccount ba) {
		Connection conn = cf.getConnection();
		
		PreparedStatement insertCustomerAccount = conn.prepareStatement(sql);
		try {
			String newCustomerSql = "insert into "customers" "
					+ "("customer_name", "bank_account_number")"
					+ "values (?, ?);";
					
//					String sql = "insert into "media" "
//	                        + "("price", "type", "name", "copyright_owner", "release_date", "rating", "max_age" , "min_age")"
//	                        + "values (?, ?, ?, ?, ?, ?, ?, ?);";
			
			insertCustomerAccount.setString(1, ba.getCustomerName);
			insertCustomerAccount.setInt(2, ba.getBankAccountNumber);
			
			ResultSet res = insertCustomerAccount.executeQuery();
			int newId;
			
			if(res.next()) {
				newId = res.getInt("customer_id");
			} else {
				throw new SQLException();
			}
			
//			PreparedStatement insertAccountBalance = conn.prepareStatement(sql);
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}