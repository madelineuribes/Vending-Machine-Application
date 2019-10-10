package com.techelevator.view;

public class Gum implements Inventory {


	private int name;
	private double price;

	public Gum(String name, double price) {

	}
	
	@Override
	public String getMessage() {
		
		return "Chew Chew, Yum!";
	}

}
