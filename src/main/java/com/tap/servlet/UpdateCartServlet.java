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

@WebServlet("/UpdateCartServlet")
public class UpdateCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		int menuId = Integer.parseInt(request.getParameter("menuId"));
		String action = request.getParameter("action");

		HttpSession session = request.getSession();

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart != null) {

			for (CartItem item : cart.getItems()) {

				if (item.getMenuId() == menuId) {

					if ("plus".equals(action)) {

						item.setQuantity(item.getQuantity() + 1);

					}
					else if ("minus".equals(action)) {

						if (item.getQuantity() > 1) {

							item.setQuantity(item.getQuantity() - 1);

						}
						else {

							cart.removeItem(menuId);

						}
					}

					break;
				}
			}
		}

		response.sendRedirect("CartServlet");
	}
}