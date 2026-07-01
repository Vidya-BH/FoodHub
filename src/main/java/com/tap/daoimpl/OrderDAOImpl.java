package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDAO;
import com.tap.model.Order;
import com.tap.util.DBConnection;

public class OrderDAOImpl implements OrderDAO {

	private Connection con;

	private static final String INSERT_ORDER =
			"INSERT INTO orders(userId,totalAmount,status,paymentMode,deliveryAddress) VALUES(?,?,?,?,?)";

	private static final String GET_ORDER_BY_ID =
			"SELECT * FROM orders WHERE orderId=?";

	private static final String GET_ORDER_BY_USER =
			"SELECT * FROM orders WHERE userId=? ORDER BY orderDate DESC";

	private static final String UPDATE_STATUS =
			"UPDATE orders SET status=? WHERE orderId=?";
	
	private static final String DELETE_ORDER =
			"DELETE FROM orders WHERE orderId=?";

	public OrderDAOImpl() {

		con = DBConnection.getConnection();

	}

	@Override
	public int addOrder(Order order) {

		int orderId = 0;

		try {

			PreparedStatement pstmt =
					con.prepareStatement(INSERT_ORDER,
							PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, order.getUserId());
			pstmt.setDouble(2, order.getTotalAmount());
			pstmt.setString(3, order.getStatus());
			pstmt.setString(4, order.getPaymentMode());
			pstmt.setString(5, order.getDeliveryAddress());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if(rs.next()) {

				orderId = rs.getInt(1);

			}

		}
		catch(Exception e) {

			e.printStackTrace();

		}

		return orderId;

	}

	@Override
	public Order getOrderById(int orderId) {

		Order order = null;

		try {

			PreparedStatement pstmt =
					con.prepareStatement(GET_ORDER_BY_ID);

			pstmt.setInt(1, orderId);

			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {

				order = new Order();

				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setTotalAmount(rs.getDouble("totalAmount"));
				order.setStatus(rs.getString("status"));
				order.setPaymentMode(rs.getString("paymentMode"));
				order.setDeliveryAddress(rs.getString("deliveryAddress"));
				order.setOrderDate(rs.getTimestamp("orderDate"));

			}

		}
		catch(Exception e) {

			e.printStackTrace();

		}

		return order;

	}

	@Override
	public List<Order> getOrdersByUser(int userId) {

		List<Order> list = new ArrayList<>();

		try {

			PreparedStatement pstmt =
					con.prepareStatement(GET_ORDER_BY_USER);

			pstmt.setInt(1, userId);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				Order order = new Order();

				order.setOrderId(rs.getInt("orderId"));
				order.setUserId(rs.getInt("userId"));
				order.setTotalAmount(rs.getDouble("totalAmount"));
				order.setStatus(rs.getString("status"));
				order.setPaymentMode(rs.getString("paymentMode"));
				order.setDeliveryAddress(rs.getString("deliveryAddress"));
				order.setOrderDate(rs.getTimestamp("orderDate"));

				list.add(order);

			}

		}
		catch(Exception e) {

			e.printStackTrace();

		}

		return list;

	}

	@Override
	public int updateOrderStatus(int orderId, String status) {

		int x = 0;

		try {

			PreparedStatement pstmt =
					con.prepareStatement(UPDATE_STATUS);

			pstmt.setString(1, status);
			pstmt.setInt(2, orderId);

			x = pstmt.executeUpdate();

		}
		catch(Exception e) {

			e.printStackTrace();

		}

		return x;

	}
	@Override
	public int deleteOrder(int orderId) {

		int x=0;

		try {

			PreparedStatement pstmt=
					con.prepareStatement(DELETE_ORDER);

			pstmt.setInt(1, orderId);

			x=pstmt.executeUpdate();

		}
		catch(Exception e) {

			e.printStackTrace();

		}

		return x;

	}

}