package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.util.DBConnection;

public class UserDAOImpl implements UserDAO {

	private Connection con;

	private static final String INSERT_USER =
			"INSERT INTO users(name,email,phone,password,address,role) VALUES(?,?,?,?,?,?)";

	private static final String UPDATE_USER =
			"UPDATE users SET name=?,email=?,phone=?,password=?,address=?,role=? WHERE userId=?";

	private static final String DELETE_USER =
			"DELETE FROM users WHERE userId=?";

	private static final String GET_USER_BY_ID =
			"SELECT * FROM users WHERE userId=?";

	private static final String GET_USER_BY_EMAIL =
			"SELECT * FROM users WHERE email=?";

	private static final String GET_ALL_USERS =
			"SELECT * FROM users";

	public UserDAOImpl() {

		con = DBConnection.getConnection();

	}

	@Override
	public int addUser(User user) {

		try {

			PreparedStatement pstmt = con.prepareStatement(INSERT_USER);

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getRole());

			return pstmt.executeUpdate();

		}
		catch (SQLException e) {

			e.printStackTrace();

		}

		return 0;
	}

	@Override
	public int updateUser(User user) {

		try {

			PreparedStatement pstmt = con.prepareStatement(UPDATE_USER);

			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPhone());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getAddress());
			pstmt.setString(6, user.getRole());
			pstmt.setInt(7, user.getUserId());

			return pstmt.executeUpdate();

		}
		catch (SQLException e) {

			e.printStackTrace();

		}

		return 0;
	}

	@Override
	public int deleteUser(int userId) {

		try {

			PreparedStatement pstmt = con.prepareStatement(DELETE_USER);

			pstmt.setInt(1, userId);

			return pstmt.executeUpdate();

		}
		catch (SQLException e) {

			e.printStackTrace();

		}

		return 0;
	}

	@Override
	public User getUserById(int userId) {

		User user = null;

		try {

			PreparedStatement pstmt = con.prepareStatement(GET_USER_BY_ID);

			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {

				user = new User();

				user.setUserId(rs.getInt("userId"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getString("role"));
				user.setCreatedDate(rs.getTimestamp("createdDate"));

			}

		}
		catch (SQLException e) {

			e.printStackTrace();

		}

		return user;
	}

	@Override
	public User getUserByEmail(String email) {

		User user = null;

		try {

			PreparedStatement pstmt = con.prepareStatement(GET_USER_BY_EMAIL);

			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {

				user = new User();

				user.setUserId(rs.getInt("userId"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getString("role"));
				user.setCreatedDate(rs.getTimestamp("createdDate"));

			}

		}
		catch (SQLException e) {

			e.printStackTrace();

		}

		return user;
	}

	@Override
	public List<User> getAllUsers() {

		List<User> users = new ArrayList<>();

		try {

			PreparedStatement pstmt = con.prepareStatement(GET_ALL_USERS);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				User user = new User();

				user.setUserId(rs.getInt("userId"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setRole(rs.getString("role"));
				user.setCreatedDate(rs.getTimestamp("createdDate"));

				users.add(user);

			}

		}
		catch (SQLException e) {

			e.printStackTrace();

		}

		return users;
	}
}