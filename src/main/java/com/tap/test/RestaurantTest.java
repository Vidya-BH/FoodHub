package com.tap.test;

import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.Restaurant;

public class RestaurantTest {

	public static void main(String[] args) {

		RestaurantDAO dao = new RestaurantDAOImpl();

		// ================================
		// ADD RESTAURANT
		// ================================

		/*
		Restaurant restaurant = new Restaurant();

		restaurant.setRestaurantName("Udupi Grand");
		restaurant.setCuisineType("South Indian");
		restaurant.setDeliveryTime(25);
		restaurant.setAddress("Bangalore");
		restaurant.setRating(4.6);
		restaurant.setActive(true);
		restaurant.setImagePath("images/udupi.jpg");

		int x = dao.addRestaurant(restaurant);

		if(x > 0)
			System.out.println("Restaurant Added Successfully");
		else
			System.out.println("Failed");
		*/

		// ================================
		// GET ALL RESTAURANTS
		// ================================

		List<Restaurant> restaurants = dao.getAllRestaurants();

		for(Restaurant r : restaurants) {
			System.out.println(r);
		}

		// ================================
		// GET RESTAURANT BY ID
		// ================================

		/*
		Restaurant r = dao.getRestaurantById(1);

		System.out.println(r);
		*/

		// ================================
		// UPDATE RESTAURANT
		// ================================

		/*
		Restaurant restaurant = dao.getRestaurantById(1);

		restaurant.setRating(4.9);

		int x = dao.updateRestaurant(restaurant);

		if(x > 0)
			System.out.println("Updated Successfully");
		*/

		// ================================
		// DELETE RESTAURANT
		// ================================

		/*
		int x = dao.deleteRestaurant(8);

		if(x > 0)
			System.out.println("Deleted Successfully");
		*/

	}
}