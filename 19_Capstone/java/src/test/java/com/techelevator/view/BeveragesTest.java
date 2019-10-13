package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class BeveragesTest {
	
	// Test getMessage method
	Beverages bevTestMessage = new Beverages("C1", "Cola", new BigDecimal("1.25"), "Drink", 5);
	Chips chipsTestMessage = new Chips("A2", "Stackers", new BigDecimal("1.45"), "Chips", 5);
	
	@Test
	public void productIsBeverageGetMessage() {
		Assert.assertEquals("Glug Glug, Yum!", bevTestMessage.getMessage());
	}
	
	@Test
	public void productIsChipsGetMessageShouldNotBeGlug() {
		boolean expectedResult = true;
		if (!(bevTestMessage.getMessage() == "Glug Glug, Yum!")) {
			expectedResult = false;
			Assert.assertEquals(expectedResult, chipsTestMessage.getMessage());
		}
	}
	
	// Test decrement method
	Beverages bevTestQuantity5 = new Beverages("C1", "Cola", new BigDecimal("1.25"), "Drink", 5);
	Beverages bevTestQuantity4 = new Beverages("C1", "Cola", new BigDecimal("1.25"), "Drink", 4);
	Beverages bevTestQuantity3 = new Beverages("C1", "Cola", new BigDecimal("1.25"), "Drink", 3);
	Beverages bevTestQuantity2 = new Beverages("C1", "Cola", new BigDecimal("1.25"), "Drink", 2);
	Beverages bevTestQuantity1 = new Beverages("C1", "Cola", new BigDecimal("1.25"), "Drink", 1);
	Beverages bevTestQuantity0 = new Beverages("C1", "Cola", new BigDecimal("1.25"), "Drink", 0);
	
	@Test
	public void quantityIs5ResultIs4() {
		Assert.assertEquals(4, bevTestQuantity5.decrement());
	}
	
	@Test
	public void quantityIs4ResultIs3() {
		Assert.assertEquals(3, bevTestQuantity4.decrement());
	}
	
	@Test
	public void quantityIs3ResultIs2() {
		Assert.assertEquals(2, bevTestQuantity3.decrement());
	}
	
	@Test
	public void quantityIs2ResultIs1() {
		Assert.assertEquals(1, bevTestQuantity2.decrement());
	}	
	
	@Test
	public void quantityIs1ResultIs0() {
		Assert.assertEquals(0, bevTestQuantity1.decrement());
	}
	
	@Test
	public void quantityIs1ResultIsNegative() {
		Assert.assertEquals(-1, bevTestQuantity0.decrement());
	}

}
