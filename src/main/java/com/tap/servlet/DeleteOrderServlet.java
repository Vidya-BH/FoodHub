package com.tap.servlet;

import java.io.IOException;

import com.tap.daoimpl.OrderDAOImpl;
import com.tap.daoimpl.OrderItemDAOImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		int orderId=Integer.parseInt(request.getParameter("orderId"));

		OrderItemDAOImpl orderItemDAO=new OrderItemDAOImpl();

		orderItemDAO.deleteOrderItems(orderId);

		OrderDAOImpl orderDAO=new OrderDAOImpl();

		orderDAO.deleteOrder(orderId);

		response.sendRedirect("MyOrdersServlet");

	}

}