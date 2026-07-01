package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.daoimpl.MenuDAOImpl;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		int restaurantId =
				Integer.parseInt(request.getParameter("restaurantId"));

		MenuDAOImpl dao = new MenuDAOImpl();

		List<Menu> menuList =
				dao.getMenuByRestaurant(restaurantId);

		request.setAttribute("menuList", menuList);

		request.getRequestDispatcher("menu.jsp")
				.forward(request, response);

	}
}