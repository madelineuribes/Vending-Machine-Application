package com.techelevator.view;

public class Beverages implements Inventory {


	private int name;
	private double price;

	public Beverages(String name, double price) {

	}
	
	@Override
	public String getMessage() {
		return "Glug Glug, Yum!";
	}

}
