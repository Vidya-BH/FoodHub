package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.daoimpl.OrderDAOImpl;
import com.tap.model.Order;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MyOrdersServlet")
public class MyOrdersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();

		User user=(User)session.getAttribute("loggedInUser");

		if(user==null){

			response.sendRedirect("login.jsp");
			return;

		}

		OrderDAOImpl dao=new OrderDAOImpl();

		List<Order> orders=dao.getOrdersByUser(user.getUserId());

		request.setAttribute("orders", orders);

		request.getRequestDispatcher("myOrders.jsp").forward(request, response);

	}

}