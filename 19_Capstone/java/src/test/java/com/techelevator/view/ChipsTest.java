package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class ChipsTest {

	// Test getMessage method
	Chips chipsTestMessage = new Chips("A2", "Stackers", new BigDecimal("1.45"), "Chips", 5);
	Beverages bevTestMessage = new Beverages("C1", "Cola", new BigDecimal("1.25"), "Drink", 5);
	
	@Test
	public void productIsChipsGetMessage() {
		Assert.assertEquals("Crunch Crunch, Yum!", chipsTestMessage.getMessage());
	}
	
	@Test
	public void productIsBeverageGetMessageShouldNotBeCrunch() {
		boolean expectedResult = true;
		if (!(chipsTestMessage.getMessage() == "Crunch Crunch, Yum!")) {
			expectedResult = false;
			Assert.assertEquals(expectedResult, bevTestMessage.getMessage());
		}
	}
	
	// Test decrement method
	Chips chipsTestQuantity5 = new Chips("A2", "Stackers", new BigDecimal("1.45"), "Chips", 5);
	Chips chipsTestQuantity4 = new Chips("A2", "Stackers", new BigDecimal("1.45"), "Chips", 4);
	Chips chipsTestQuantity3 = new Chips("A2", "Stackers", new BigDecimal("1.45"), "Chips", 3);
	Chips chipsTestQuantity2 = new Chips("A2", "Stackers", new BigDecimal("1.45"), "Chips", 2);
	Chips chipsTestQuantity1 = new Chips("A2", "Stackers", new BigDecimal("1.45"), "Chips", 1);
	Chips chipsTestQuantity0 = new Chips("A2", "Stackers", new BigDecimal("1.45"), "Chips", 0);
	
	@Test
	public void quantityIs5ResultIs4() {
		Assert.assertEquals(4, chipsTestQuantity5.decrement());
	}
	
	@Test
	public void quantityIs4ResultIs3() {
		Assert.assertEquals(3, chipsTestQuantity4.decrement());
	}
	
	@Test
	public void quantityIs3ResultIs2() {
		Assert.assertEquals(2, chipsTestQuantity3.decrement());
	}
	
	@Test
	public void quantityIs2ResultIs1() {
		Assert.assertEquals(1, chipsTestQuantity2.decrement());
	}	
	
	@Test
	public void quantityIs1ResultIs0() {
		Assert.assertEquals(0, chipsTestQuantity1.decrement());
	}
	
	@Test
	public void quantityIs1ResultIsNegative() {
		Assert.assertEquals(-1, chipsTestQuantity0.decrement());
	}

}
