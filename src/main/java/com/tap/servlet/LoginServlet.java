package com.tap.servlet;

import java.io.IOException;

import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		UserDAOImpl userDAO = new UserDAOImpl();

		User user = userDAO.getUserByEmail(email);

		if(user != null && user.getPassword().equals(password)) {

			HttpSession session = request.getSession();

			session.setAttribute("loggedInUser", user);

			response.sendRedirect("RestaurantServlet");

		}
		else {

			response.getWriter().println("<h2>Invalid Email or Password</h2>");

		}
	}
}