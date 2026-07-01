package com.tap.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Database URL
    private static final String URL = "jdbc:mysql://localhost:3306/fooddeliverydb";

    // MySQL Username
    private static final String USERNAME = "root";

    // MySQL Password
    private static final String PASSWORD = "VIdy12@#"; // Change this if your MySQL password is different

    // Connection Object
    private static Connection connection;

    // Method to get Database Connection
    public static Connection getConnection() {

    	try {

    		Class.forName("com.mysql.cj.jdbc.Driver");

    		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    		System.out.println("Database Connected Successfully...");

    	} catch (Exception e) {

    		e.printStackTrace();
    	}

    	return connection;
    }
}