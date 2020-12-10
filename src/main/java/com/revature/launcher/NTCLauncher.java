package com.revature.launcher;

import java.sql.Connection;

public class NTCLauncher {

	public static void main(String[] args) {
		System.out.println("hello world!");
		
		ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
		
		Connection conn = cf.getConnection();
		
	}

}
