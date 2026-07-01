package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.daoimpl.OrderDAOImpl;
import com.tap.daoimpl.OrderItemDAOImpl;
import com.tap.model.Order;
import com.tap.model.OrderItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OrderDetailsServlet")
public class OrderDetailsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		int orderId=Integer.parseInt(request.getParameter("orderId"));

		OrderDAOImpl orderDAO=new OrderDAOImpl();

		Order order=orderDAO.getOrderById(orderId);

		OrderItemDAOImpl itemDAO=new OrderItemDAOImpl();

		List<OrderItem> orderItems=itemDAO.getOrderItemsByOrderId(orderId);

		request.setAttribute("order", order);

		request.setAttribute("orderItems", orderItems);

		request.getRequestDispatcher("orderDetails.jsp")
		       .forward(request,response);

	}

}