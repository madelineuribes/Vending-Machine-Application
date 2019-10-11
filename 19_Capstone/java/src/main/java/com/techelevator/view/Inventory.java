package com.techelevator.view;

import java.math.BigDecimal;

public interface Inventory {

	public String getMessage();
	
	public String getSlot();
	
	public String getName();
	
	public BigDecimal getPrice();
	
	public String getType();
	
	public int getQuantity();
	
	public int decrement();
}
