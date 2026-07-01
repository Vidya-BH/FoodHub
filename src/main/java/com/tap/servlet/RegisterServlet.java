package com.tap.servlet;

import java.io.IOException;

import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!password.equals(confirmPassword)) {

			response.getWriter().println("Password and Confirm Password do not match.");
			return;
		}

		User user = new User();

		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAddress(address);
		user.setPassword(password);
		user.setRole("CUSTOMER");

		UserDAOImpl userDAO = new UserDAOImpl();

		int result = userDAO.addUser(user);

		if (result > 0) {

			response.sendRedirect("login.jsp");

		} else {

			response.getWriter().println("Registration Failed!");

		}
	}
}