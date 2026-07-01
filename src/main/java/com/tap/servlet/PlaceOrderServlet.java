
package com.tap.servlet;

import java.io.IOException;

import com.tap.daoimpl.OrderDAOImpl;
import com.tap.daoimpl.OrderItemDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PlaceOrderServlet")
public class PlaceOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("loggedInUser");

		Cart cart = (Cart) session.getAttribute("cart");

		if (user == null || cart == null || cart.getItems().isEmpty()) {

			response.sendRedirect("login.jsp");
			return;

		}

		String address = request.getParameter("address");

		String paymentMode = request.getParameter("paymentMode");

		Order order = new Order();

		order.setUserId(user.getUserId());

		order.setTotalAmount(cart.getGrandTotal());

		order.setStatus("PLACED");

		order.setPaymentMode(paymentMode);

		order.setDeliveryAddress(address);

		OrderDAOImpl orderDAO = new OrderDAOImpl();

		int orderId = orderDAO.addOrder(order);

		OrderItemDAOImpl orderItemDAO = new OrderItemDAOImpl();

		for (CartItem item : cart.getItems()) {

			OrderItem orderItem = new OrderItem();

			orderItem.setOrderId(orderId);

			orderItem.setMenuId(item.getMenuId());

			orderItem.setQuantity(item.getQuantity());

			orderItem.setPrice(item.getPrice());

			orderItemDAO.addOrderItem(orderItem);

		}

		session.removeAttribute("cart");

		response.sendRedirect("orderSuccess.jsp");

	}

}

