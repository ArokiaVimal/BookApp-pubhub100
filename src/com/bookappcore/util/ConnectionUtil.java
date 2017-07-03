package com.bookappcore.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtil {

	public static Connection getConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_app","root","4565");
		return connection;
	}
public static void main(String[] args) throws Exception {
		
		System.out.println(ConnectionUtil.getConnection());
	}
}
