package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.model.Menu;
import com.tap.util.DBConnection;

public class MenuDAOImpl implements MenuDAO {

	private Connection con;

	private static final String GET_ALL_MENU =
			"SELECT * FROM menu";

	private static final String GET_MENU_BY_RESTAURANT =
			"SELECT * FROM menu WHERE restaurantId=?";

	private static final String GET_MENU_BY_ID =
			"SELECT * FROM menu WHERE menuId=?";

	private static final String INSERT_MENU =
			"INSERT INTO menu(restaurantId,itemName,description,price,isAvailable,imagePath,foodType)\r\n"
			+ "VALUES(?,?,?,?,?,?,?)";

	private static final String UPDATE_MENU =
			"UPDATE menu SET restaurantId=?,itemName=?,description=?,price=?,isAvailable=?,imagePath=?,foodType=? WHERE menuId=?";

	private static final String DELETE_MENU =
			"DELETE FROM menu WHERE menuId=?";

	public MenuDAOImpl() {
		con = DBConnection.getConnection();
	}

	@Override
	public List<Menu> getAllMenus() {

		List<Menu> menuList = new ArrayList<>();

		try {

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(GET_ALL_MENU);

			while (rs.next()) {

				Menu menu = new Menu();

				menu.setMenuId(rs.getInt("menuId"));
				menu.setRestaurantId(rs.getInt("restaurantId"));
				menu.setItemName(rs.getString("itemName"));
				menu.setDescription(rs.getString("description"));
				menu.setPrice(rs.getDouble("price"));
				menu.setAvailable(rs.getBoolean("isAvailable"));
				menu.setImagePath(rs.getString("imagePath"));
				menu.setFoodType(rs.getString("foodType"));

				menuList.add(menu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuList;
	}

	@Override
	public List<Menu> getMenuByRestaurant(int restaurantId) {

		List<Menu> menuList = new ArrayList<>();

		try {

			PreparedStatement pstmt =
					con.prepareStatement(GET_MENU_BY_RESTAURANT);

			pstmt.setInt(1, restaurantId);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				Menu menu = new Menu();

				menu.setMenuId(rs.getInt("menuId"));
				menu.setRestaurantId(rs.getInt("restaurantId"));
				menu.setItemName(rs.getString("itemName"));
				menu.setDescription(rs.getString("description"));
				menu.setPrice(rs.getDouble("price"));
				menu.setAvailable(rs.getBoolean("isAvailable"));
				menu.setImagePath(rs.getString("imagePath"));

				menu.setFoodType(rs.getString("foodType"));

				

				menuList.add(menu);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuList;
	}

	@Override
	public Menu getMenuById(int menuId) {

		Menu menu = null;

		try {

			PreparedStatement pstmt =
					con.prepareStatement(GET_MENU_BY_ID);

			pstmt.setInt(1, menuId);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				menu = new Menu();

				menu.setMenuId(rs.getInt("menuId"));
				menu.setRestaurantId(rs.getInt("restaurantId"));
				menu.setItemName(rs.getString("itemName"));
				menu.setDescription(rs.getString("description"));
				menu.setPrice(rs.getDouble("price"));
				menu.setAvailable(rs.getBoolean("isAvailable"));
				menu.setImagePath(rs.getString("imagePath"));
				menu.setFoodType(rs.getString("foodType"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return menu;
	}

	@Override
	public int addMenu(Menu menu) {

		int x = 0;

		try {

			PreparedStatement pstmt =
					con.prepareStatement(INSERT_MENU);

			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setDouble(4, menu.getPrice());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setString(6, menu.getImagePath());
			pstmt.setString(7, menu.getFoodType());

			x = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return x;
	}

	@Override
	public int updateMenu(Menu menu) {

		int x = 0;

		try {

			PreparedStatement pstmt =
					con.prepareStatement(UPDATE_MENU);

			pstmt.setInt(1, menu.getRestaurantId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setDouble(4, menu.getPrice());
			pstmt.setBoolean(5, menu.isAvailable());
			pstmt.setString(6, menu.getImagePath());
			pstmt.setString(7, menu.getFoodType());
			pstmt.setInt(8, menu.getMenuId());

			x = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return x;
	}

	@Override
	public int deleteMenu(int menuId) {

		int x = 0;

		try {

			PreparedStatement pstmt =
					con.prepareStatement(DELETE_MENU);

			pstmt.setInt(1, menuId);

			x = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return x;
	}
}