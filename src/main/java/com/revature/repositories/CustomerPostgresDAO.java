package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.revature.exceptions.AccountNotCreatedException;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.InternalErrorException;
import com.revature.menu.NTCMenu;
import com.revature.models.Customer;
import com.revature.util.ConnectionFactory;

public class CustomerPostgresDAO implements CustomerDAO {

	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	Scanner userIn = new Scanner(System.in);

	public Customer findCustomerByAccountnameAndPassword(String account_name, String password)
			throws AccountNotFoundException, InternalErrorException {

		Connection conn = cf.getConnection();

		try {

			String sql = "select * from customers where \"account_name\" = ? and \"password\" = ? ;";
			PreparedStatement getCustomer = conn.prepareStatement(sql);
			getCustomer.setString(1, account_name);
			getCustomer.setString(2, password);

			ResultSet res = getCustomer.executeQuery();
			if (res.next()) {

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

		} catch (SQLException e) {

			e.printStackTrace();
			throw new InternalErrorException();

		} finally {

			cf.releaseConnection(conn);

		}
	}

	public List<Customer> findAll() {

		Connection conn = this.cf.getConnection();
		List<Customer> allCustomers = new ArrayList<Customer>();

		try {

			String sql = "select * from customers";
			Statement s = conn.createStatement();

			ResultSet res = s.executeQuery(sql);

			while (res.next()) {

				Customer c = new Customer();

				c.setCustomerId(res.getInt("customer_id"));
				c.setName(res.getString("customer_name"));
				c.setAccount_name(res.getString("account_name"));
				c.setPassword(res.getString("password"));
				c.setTotal_balance(res.getDouble("total_balance"));
				c.setBank_Account_number(res.getInt("bank_account_number"));

				allCustomers.add(c);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			cf.releaseConnection(conn);

		}

		return allCustomers;

	}


	public Customer createAccount(Customer c) throws AccountNotCreatedException {

		Connection conn = cf.getConnection();

		try {
			
			conn.setAutoCommit(false);
			
			String sql = "insert into \"customers\" "
					+ "(\"account_name\", \"password\", \"customer_name\", \"total_balance\", \"bank_account_number\") "
					+ "values (?, ?, ?, ?, ? );";
			
			PreparedStatement insertAccount = conn.prepareStatement(sql);
				
				insertAccount.setString(1, c.getAccount_name());
				insertAccount.setString(2, c.getPassword());
				insertAccount.setString(3, c.getName());
				insertAccount.setDouble(4, c.getTotal_balance());
				insertAccount.setInt(5, c.getBank_Account_number());

				insertAccount.executeUpdate();


		} catch (SQLException e) {
			
			e.printStackTrace();
			
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
				try {
					conn.commit();
					conn.setAutoCommit(true);
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				cf.releaseConnection(conn);
			}
		
		return c;
		
	}
	

	public Customer makeDepositOrWithdrawl(double newBalance, int customerId) {
		
		Connection conn = cf.getConnection();
		
		try {
			
			String sql = "update \"customers\" "
						+ "set \"total_balance\" = ?"
						+ "where \"customer_id\" = ?;";
			
			PreparedStatement updateBalance = conn.prepareStatement(sql);
			
			updateBalance.setDouble(1, newBalance);
			updateBalance.setInt(2, customerId);
			
			updateBalance.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		return null;
	}

}
