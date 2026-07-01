package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.util.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO {

	private Connection con;

	private static final String INSERT_ORDER_ITEM =
			"INSERT INTO orderitems(orderId,menuId,quantity,price) VALUES(?,?,?,?)";

	private static final String GET_ORDER_ITEMS =
			"SELECT * FROM orderitems WHERE orderId=?";
	private static final String DELETE_ORDER_ITEMS =
			"DELETE FROM orderitems WHERE orderId=?";
	

	public OrderItemDAOImpl() {

		con = DBConnection.getConnection();

	}

	@Override
	public int addOrderItem(OrderItem orderItem) {

		int x = 0;

		try {

			PreparedStatement pstmt =
					con.prepareStatement(INSERT_ORDER_ITEM);

			pstmt.setInt(1, orderItem.getOrderId());
			pstmt.setInt(2, orderItem.getMenuId());
			pstmt.setInt(3, orderItem.getQuantity());
			pstmt.setDouble(4, orderItem.getPrice());

			x = pstmt.executeUpdate();

		}
		catch(Exception e) {

			e.printStackTrace();

		}

		return x;

	}

	@Override
	public List<OrderItem> getOrderItemsByOrderId(int orderId) {

		List<OrderItem> list = new ArrayList<>();

		try {

			PreparedStatement pstmt =
					con.prepareStatement(GET_ORDER_ITEMS);

			pstmt.setInt(1, orderId);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {

				OrderItem item = new OrderItem();

				item.setOrderItemId(rs.getInt("orderItemId"));
				item.setOrderId(rs.getInt("orderId"));
				item.setMenuId(rs.getInt("menuId"));
				item.setQuantity(rs.getInt("quantity"));
				item.setPrice(rs.getDouble("price"));

				list.add(item);

			}

		}
		catch(Exception e) {

			e.printStackTrace();

		}

		return list;

	}
	@Override
	public int deleteOrderItems(int orderId) {

		int x=0;

		try {

			PreparedStatement pstmt=
					con.prepareStatement(DELETE_ORDER_ITEMS);

			pstmt.setInt(1, orderId);

			x=pstmt.executeUpdate();

		}
		catch(Exception e) {

			e.printStackTrace();

		}

		return x;

	}

}