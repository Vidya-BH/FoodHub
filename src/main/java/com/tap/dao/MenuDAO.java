package com.tap.dao;

import java.util.List;
import com.tap.model.Menu;

public interface MenuDAO {

	List<Menu> getAllMenus();

	List<Menu> getMenuByRestaurant(int restaurantId);

	Menu getMenuById(int menuId);

	int addMenu(Menu menu);

	int updateMenu(Menu menu);

	int deleteMenu(int menuId);
}