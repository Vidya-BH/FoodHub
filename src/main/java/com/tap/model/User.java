
package com.tap.model;

import java.sql.Timestamp;

public class  User{

	private int userId;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String address;
	private String role;
	private Timestamp createdDate;

	// Default Constructor
	public User() {

	}

	// Constructor without userId and createdDate
	public User(String name, String email, String phone, String password,
			String address, String role) {

		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.role = role;
	}

	// Constructor with all fields
	public User(int userId, String name, String email, String phone,
			String password, String address, String role,
			Timestamp createdDate) {

		this.userId = userId;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;
		this.role = role;
		this.createdDate = createdDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email
				+ ", phone=" + phone + ", password=" + password
				+ ", address=" + address + ", role=" + role
				+ ", createdDate=" + createdDate + "]";
	}

}

