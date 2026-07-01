package com.tap.servlet;

import java.io.IOException;

import com.tap.model.Cart;
import com.tap.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ReplaceCartServlet")
public class ReplaceCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		Cart cart = (Cart) session.getAttribute("cart");

		CartItem newItem = (CartItem) session.getAttribute("newItem");

		if (cart != null) {

			cart.clearCart();
		}
		else {

			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		if (newItem != null) {

			cart.addItem(newItem);

			session.removeAttribute("newItem");
		}

		response.sendRedirect("CartServlet");
	}
}