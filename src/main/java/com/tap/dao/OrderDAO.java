package com.tap.dao;

import java.util.List;

import com.tap.model.Order;

public interface OrderDAO {

	int addOrder(Order order);

	Order getOrderById(int orderId);

	List<Order> getOrdersByUser(int userId);

	int updateOrderStatus(int orderId,String status);

	int deleteOrder(int orderId);

}