package com.tap.model;

public class CartItem {

	private int menuId;
	private int restaurantId;
	private String restaurantName;
	private String itemName;
	private double price;
	private int quantity;
	private String imagePath;

	public CartItem() {

	}

	public CartItem(int menuId, int restaurantId, String restaurantName,
			String itemName, double price, int quantity, String imagePath) {

		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.itemName = itemName;
		this.price = price;
		this.quantity = quantity;
		this.imagePath = imagePath;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public double getTotalPrice() {
		return price * quantity;
	}

	@Override
	public String toString() {
		return "CartItem [menuId=" + menuId + ", restaurantId="
				+ restaurantId + ", restaurantName=" + restaurantName
				+ ", itemName=" + itemName + ", price=" + price
				+ ", quantity=" + quantity + ", imagePath=" + imagePath + "]";
	}
}