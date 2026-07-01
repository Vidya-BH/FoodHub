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

@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("loggedInUser");

		if(user == null) {

			response.sendRedirect("login.jsp");
			return;

		}

		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String password = request.getParameter("password");

		user.setName(name);
		user.setPhone(phone);
		user.setAddress(address);
		user.setPassword(password);

		UserDAOImpl dao = new UserDAOImpl();

		int x = dao.updateUser(user);

		if(x > 0) {

			session.setAttribute("loggedInUser", user);

			response.sendRedirect("profile.jsp");

		}
		else {

			response.getWriter().println("<h2>Profile Update Failed!</h2>");

		}

	}

}