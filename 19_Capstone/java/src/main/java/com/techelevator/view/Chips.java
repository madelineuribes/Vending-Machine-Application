package com.techelevator.view;

public class Chips implements Inventory {


	private int name;
	private double price;

	public Chips(String name, double price) {

	}
	
	@Override
	public String getMessage() {

		return "Crunch Crunch, Yum!";
	}

}
