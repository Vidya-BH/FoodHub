package com.tap.servlet;

import java.io.IOException;

import com.tap.daoimpl.MenuDAOImpl;
import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;
import com.tap.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		int menuId = Integer.parseInt(request.getParameter("menuId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		MenuDAOImpl menuDAO = new MenuDAOImpl();
		Menu menu = menuDAO.getMenuById(menuId);

		RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
		Restaurant restaurant = restaurantDAO.getRestaurantById(menu.getRestaurantId());

		// Create CartItem FIRST
		CartItem item = new CartItem();

		item.setMenuId(menu.getMenuId());
		item.setRestaurantId(menu.getRestaurantId());
		item.setRestaurantName(restaurant.getRestaurantName());
		item.setItemName(menu.getItemName());
		item.setPrice(menu.getPrice());
		item.setQuantity(quantity);
		item.setImagePath(menu.getImagePath());

		HttpSession session = request.getSession();

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {

			cart = new Cart();
			session.setAttribute("cart", cart);

		} else {

			boolean differentRestaurant = false;

			for (CartItem c : cart.getItems()) {

				if (c.getRestaurantId() != item.getRestaurantId()) {

					differentRestaurant = true;
					break;
				}
			}

			if (differentRestaurant) {

				session.setAttribute("newItem", item);

				response.sendRedirect("replaceCart.jsp");
				return;
			}
		}

		cart.addItem(item);

		response.sendRedirect("CartServlet");
	}
}