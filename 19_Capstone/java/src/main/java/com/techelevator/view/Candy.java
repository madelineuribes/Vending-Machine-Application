package com.techelevator.view;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Candy implements Inventory {

	private String slot;
	private String name;
	private BigDecimal price;
	private String type;
	private int quantity;
	
	public Candy(String slot, String name, BigDecimal price, String type, int quantity) {
		this.slot = slot;
		this.name = name;
		this.price = price;
		this.type = type;
		this.quantity = quantity;
	}
	
	@Override
	public String getMessage() {
		return "Munch Munch, Yum!";
	}
	
	
	public String getSlot() {
		return slot;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public int decrement() {
		quantity = quantity - 1;
		return quantity;
	}

}
