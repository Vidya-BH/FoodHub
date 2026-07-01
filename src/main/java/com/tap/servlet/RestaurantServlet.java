package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		RestaurantDAOImpl dao=new RestaurantDAOImpl();

		String keyword=request.getParameter("search");

		List<Restaurant> restaurants;

		if(keyword!=null && !keyword.trim().isEmpty()){

			restaurants=dao.searchRestaurant(keyword);

		}
		else{

			restaurants=dao.getAllRestaurants();

		}

		request.setAttribute("restaurants", restaurants);

		request.getRequestDispatcher("restaurants.jsp")
		.forward(request,response);

	}
}