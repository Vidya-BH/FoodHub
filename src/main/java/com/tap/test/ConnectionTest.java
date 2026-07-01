package com.tap.test;

import java.sql.Connection;

import com.tap.util.DBConnection;

public class ConnectionTest {

	public static void main(String[] args) {

		Connection con = DBConnection.getConnection();

		if (con != null) {

			System.out.println("Connection Created Successfully");

		} else {

			System.out.println("Connection Failed");
		}
	}
}