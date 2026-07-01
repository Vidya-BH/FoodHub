package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.util.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {

	private Connection con;

	// SQL Queries
	private static final String INSERT_QUERY =
			"INSERT INTO restaurant(restaurantName,cuisineType,deliveryTime,address,rating,isActive,imagePath) VALUES(?,?,?,?,?,?,?)";

	private static final String UPDATE_QUERY =
			"UPDATE restaurant SET restaurantName=?, cuisineType=?, deliveryTime=?, address=?, rating=?, isActive=?, imagePath=? WHERE restaurantId=?";

	private static final String DELETE_QUERY =
			"DELETE FROM restaurant WHERE restaurantId=?";

	private static final String GET_BY_ID_QUERY =
			"SELECT * FROM restaurant WHERE restaurantId=?";

	private static final String GET_ALL_QUERY =
			"SELECT * FROM restaurant";
	
	private static final String SEARCH_RESTAURANT =
			"SELECT * FROM restaurant WHERE restaurantName LIKE ? OR cuisineType LIKE ?";

	// Constructor
	public RestaurantDAOImpl() {

		con = DBConnection.getConnection();
	}

	@Override
	public int addRestaurant(Restaurant restaurant) {

		try {

			PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);

			pstmt.setString(1, restaurant.getRestaurantName());
			pstmt.setString(2, restaurant.getCuisineType());
			pstmt.setInt(3, restaurant.getDeliveryTime());
			pstmt.setString(4, restaurant.getAddress());
			pstmt.setDouble(5, restaurant.getRating());
			pstmt.setBoolean(6, restaurant.isActive());
			pstmt.setString(7, restaurant.getImagePath());

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int updateRestaurant(Restaurant restaurant) {

		try {

			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);

			pstmt.setString(1, restaurant.getRestaurantName());
			pstmt.setString(2, restaurant.getCuisineType());
			pstmt.setInt(3, restaurant.getDeliveryTime());
			pstmt.setString(4, restaurant.getAddress());
			pstmt.setDouble(5, restaurant.getRating());
			pstmt.setBoolean(6, restaurant.isActive());
			pstmt.setString(7, restaurant.getImagePath());
			pstmt.setInt(8, restaurant.getRestaurantId());

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public int deleteRestaurant(int restaurantId) {

		try {

			PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);

			pstmt.setInt(1, restaurantId);

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) {

		Restaurant restaurant = null;

		try {

			PreparedStatement pstmt = con.prepareStatement(GET_BY_ID_QUERY);

			pstmt.setInt(1, restaurantId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				restaurant = new Restaurant();

				restaurant.setRestaurantId(rs.getInt("restaurantId"));
				restaurant.setRestaurantName(rs.getString("restaurantName"));
				restaurant.setCuisineType(rs.getString("cuisineType"));
				restaurant.setDeliveryTime(rs.getInt("deliveryTime"));
				restaurant.setAddress(rs.getString("address"));
				restaurant.setRating(rs.getDouble("rating"));
				restaurant.setActive(rs.getBoolean("isActive"));
				restaurant.setImagePath(rs.getString("imagePath"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {

		List<Restaurant> restaurantList = new ArrayList<>();

		try {

			PreparedStatement pstmt = con.prepareStatement(GET_ALL_QUERY);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Restaurant restaurant = new Restaurant();

				restaurant.setRestaurantId(rs.getInt("restaurantId"));
				restaurant.setRestaurantName(rs.getString("restaurantName"));
				restaurant.setCuisineType(rs.getString("cuisineType"));
				restaurant.setDeliveryTime(rs.getInt("deliveryTime"));
				restaurant.setAddress(rs.getString("address"));
				restaurant.setRating(rs.getDouble("rating"));
				restaurant.setActive(rs.getBoolean("isActive"));
				restaurant.setImagePath(rs.getString("imagePath"));
				restaurant.setPriceForTwo(rs.getDouble("priceForTwo"));
				restaurant.setOfferText(rs.getString("offerText"));

				restaurantList.add(restaurant);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurantList;
	}
	
	@Override
	public List<Restaurant> searchRestaurant(String keyword) {

		List<Restaurant> restaurants=new ArrayList<>();

		try {

			PreparedStatement pstmt=
					con.prepareStatement(SEARCH_RESTAURANT);

			pstmt.setString(1,"%"+keyword+"%");
			pstmt.setString(2,"%"+keyword+"%");

			ResultSet rs=pstmt.executeQuery();

			while(rs.next()) {

				Restaurant restaurant=new Restaurant();

				restaurant.setRestaurantId(rs.getInt("restaurantId"));
				restaurant.setRestaurantName(rs.getString("restaurantName"));
				restaurant.setCuisineType(rs.getString("cuisineType"));
				restaurant.setAddress(rs.getString("address"));
				restaurant.setRating(rs.getFloat("rating"));
				restaurant.setDeliveryTime(rs.getInt("deliveryTime"));
				restaurant.setPriceForTwo(rs.getDouble("priceForTwo"));
				restaurant.setImagePath(rs.getString("imagePath"));
				restaurant.setActive(rs.getBoolean("isActive"));

				restaurants.add(restaurant);

			}

		}
		catch(Exception e) {

			e.printStackTrace();

		}

		return restaurants;

	}
}