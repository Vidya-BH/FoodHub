package com.tap.test;

import java.util.List;

import com.tap.daoimpl.MenuDAOImpl;
import com.tap.model.Menu;

public class MenuTest {

	public static void main(String[] args) {

		MenuDAOImpl dao = new MenuDAOImpl();

		System.out.println("========== ALL MENU ITEMS ==========");

		List<Menu> list = dao.getAllMenus();

		for(Menu m : list) {

			System.out.println("Menu Id : " + m.getMenuId());
			System.out.println("Restaurant Id : " + m.getRestaurantId());
			System.out.println("Item Name : " + m.getItemName());
			System.out.println("Description : " + m.getDescription());
			System.out.println("Price : " + m.getPrice());
			System.out.println("Available : " + m.isAvailable());
			System.out.println("Image : " + m.getImagePath());
			System.out.println("------------------------------------");
		}

		System.out.println();
		System.out.println("===== MENU OF RESTAURANT ID : 1 =====");

		List<Menu> restaurantMenu = dao.getMenuByRestaurant(1);

		for(Menu m : restaurantMenu) {

			System.out.println(m.getItemName() + " - ₹" + m.getPrice());
		}
	}
}