package com.tap.dao;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDAO {

	// Add a new restaurant
	int addRestaurant(Restaurant restaurant);

	// Update restaurant details
	int updateRestaurant(Restaurant restaurant);

	// Delete restaurant by ID
	int deleteRestaurant(int restaurantId);

	// Get a restaurant by ID
	Restaurant getRestaurantById(int restaurantId);

	// Get all restaurants
	List<Restaurant> getAllRestaurants();
	
	List<Restaurant> searchRestaurant(String keyword);
}