package com.tap.model;

public class Restaurant {

	private int restaurantId;
	private String restaurantName;
	private String cuisineType;
	private int deliveryTime;
	private String address;
	private double rating;
	private boolean isActive;
	private String imagePath;
	private double priceForTwo;
	private String offerText;
	
	public String getOfferText() {
		return offerText;
	}

	public void setOfferText(String offerText) {
		this.offerText = offerText;
	}

	public Restaurant() {

	}

	public Restaurant(int restaurantId,
			String restaurantName,
			String cuisineType,
			int deliveryTime,
			String address,
			double rating,
			boolean isActive,
			String imagePath,
			double priceForTwo,
			String offerText) {

				this.restaurantId = restaurantId;
				this.restaurantName = restaurantName;
				this.cuisineType = cuisineType;
				this.deliveryTime = deliveryTime;
				this.address = address;
				this.rating = rating;
				this.isActive = isActive;
				this.imagePath = imagePath;
				this.priceForTwo = priceForTwo;
				this.offerText = offerText;
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

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public double getPriceForTwo() {
		return priceForTwo;
	}

	public void setPriceForTwo(double priceForTwo) {
		this.priceForTwo = priceForTwo;
	}

	@Override
	
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId
				+ ", restaurantName=" + restaurantName
				+ ", cuisineType=" + cuisineType
				+ ", deliveryTime=" + deliveryTime
				+ ", address=" + address
				+ ", rating=" + rating
				+ ", isActive=" + isActive
				+ ", imagePath=" + imagePath
				+ ", priceForTwo=" + priceForTwo
				+ ", offerText=" + offerText
				+ "]";
	}
}