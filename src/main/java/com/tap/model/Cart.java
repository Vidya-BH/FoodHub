package com.tap.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

	private Map<Integer, CartItem> items = new LinkedHashMap<>();

	public void addItem(CartItem item) {

		if(items.containsKey(item.getMenuId())) {

			CartItem oldItem = items.get(item.getMenuId());

			oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());

		}
		else {

			items.put(item.getMenuId(), item);

		}
	}

	public void clearCart() {

	    items.clear();

	}
	public void updateItem(int menuId, int quantity) {

		if(items.containsKey(menuId)) {

			items.get(menuId).setQuantity(quantity);

		}
	}

	public void removeItem(int menuId) {

		items.remove(menuId);

	}

	public Collection<CartItem> getItems() {

		return items.values();

	}

	public double getGrandTotal() {

		double total = 0;

		for(CartItem item : items.values()) {

			total += item.getTotalPrice();

		}

		return total;

	}
}