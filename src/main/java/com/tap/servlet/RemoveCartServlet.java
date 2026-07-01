package com.tap.servlet;

import java.io.IOException;

import com.tap.model.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RemoveCartServlet")
public class RemoveCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		int menuId = Integer.parseInt(request.getParameter("menuId"));

		HttpSession session = request.getSession();

		Cart cart = (Cart) session.getAttribute("cart");

		if(cart != null) {

			cart.removeItem(menuId);

		}

		response.sendRedirect("CartServlet");

	}
}