package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.AccountNotCreatedException;
import com.revature.exceptions.AccountNotFoundException;
import com.revature.exceptions.InternalErrorException;
import com.revature.models.Customer;
import com.revature.repositories.CustomerDAO;

public class BankServiceImplementationTest {
	
	private Customer c;
	private CustomerDAO cd = mock(CustomerDAO.class);
	private CustomerService cs;
	private CustomerServiceImplementation csi;
	
	
	@BeforeEach
	public void setupCSI() {
		
		this.cd = mock(CustomerDAO.class);
		csi = new CustomerServiceImplementation(this.cd);
		
	}
	
	@Test
	public void testPrintAllAccounts() {
		
		List<Customer> testValues = new ArrayList<Customer>();
		
		Customer jt = new Customer("jt", "password", "Justin Trudeau", 0, 12345);
		Customer bs = new Customer("bs", "password", "Bob Smith", 0, 12345);
		
		testValues.add(jt);
		testValues.add(bs);
		
		when(cd.findAll()).thenReturn(testValues);
		
		List<Customer> expectedListResult = new ArrayList<>(testValues);
		
		
		assertEquals(expectedListResult, cd.findAll());
		
	}
	
	@Test
	public void testCheckSameCustomer() {
		
		Customer jt = new Customer("jt", "password", "Justin Trudeau", 0, 12345);
		Customer bs = new Customer("bs", "password", "Bob Smith", 0, 12345);
		Customer jt2 = new Customer("jt", "password", "Justin Trudeau", 0, 12345);
		
		assertSame(jt, jt2);
		
	}
	
	@Test
	public void testCurrentCustomer() {
		
		Customer currentCustomer = new Customer("jt", "password", "Justin Trudeau", 0, 12345);
		
		assertEquals(new Customer("jt", "password", "Justin Trudeau", 0, 12345), currentCustomer);
		
	}
	
	
	@Test
	public void testCustomerLoggedIn() throws AccountNotFoundException, InternalErrorException {
		
		assertNotNull(cd.findCustomerByAccountnameAndPassword("georgie", "password"));
		
	}
	
	@Test
	public void testCustomerThrowsException() throws AccountNotFoundException, InternalErrorException {
		
		assertThrows(AccountNotFoundException.class, () -> {
			
			cd.findCustomerByAccountnameAndPassword(null, null);
			
		});
		
	}
	
	
	@Test
	public void testNewAccountException() {
		
		CustomerDAO cd = (CustomerDAO) c;
		Customer c = new Customer();
		
		Assertions.assertThrows(AccountNotCreatedException.class, () -> {
			
			cd.createAccount(c);
			
		});
		
	}
	
}
