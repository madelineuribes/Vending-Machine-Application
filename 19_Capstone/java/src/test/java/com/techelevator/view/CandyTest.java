package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class CandyTest {

	// Test getMessage method
	Candy candyTestMessage = new Candy("B4", "Crunchie", new BigDecimal("1.75"), "Candy", 5);
	Gum gumTestMessage = new Gum("D3", "Chiclets", new BigDecimal("0.75"), "Gum", 5);
	
	@Test
	public void productIsCandyGetMessage() {
		Assert.assertEquals("Munch Munch, Yum!", candyTestMessage.getMessage());
	}
	
	@Test
	public void productIsGumGetMessageShouldNotBeMunch() {
		boolean expectedResult = true;
		if (!(candyTestMessage.getMessage() == "Munch Munch, Yum!")) {
			expectedResult = false;
			Assert.assertEquals(expectedResult, gumTestMessage.getMessage());
		}
	}
	
	// Test decrement method
	Candy candyTestQuantity5 = new Candy("B4", "Crunchie", new BigDecimal("1.75"), "Candy", 5);
	Candy candyTestQuantity4 = new Candy("B4", "Crunchie", new BigDecimal("1.75"), "Candy", 4);
	Candy candyTestQuantity3 = new Candy("B4", "Crunchie", new BigDecimal("1.75"), "Candy", 3);
	Candy candyTestQuantity2 = new Candy("B4", "Crunchie", new BigDecimal("1.75"), "Candy", 2);
	Candy candyTestQuantity1 = new Candy("B4", "Crunchie", new BigDecimal("1.75"), "Candy", 1);
	Candy candyTestQuantity0 = new Candy("B4", "Crunchie", new BigDecimal("1.75"), "Candy", 0);
	
	@Test
	public void quantityIs5ResultIs4() {
		Assert.assertEquals(4, candyTestQuantity5.decrement());
	}
	
	@Test
	public void quantityIs4ResultIs3() {
		Assert.assertEquals(3, candyTestQuantity4.decrement());
	}
	
	@Test
	public void quantityIs3ResultIs2() {
		Assert.assertEquals(2, candyTestQuantity3.decrement());
	}
	
	@Test
	public void quantityIs2ResultIs1() {
		Assert.assertEquals(1, candyTestQuantity2.decrement());
	}	
	
	@Test
	public void quantityIs1ResultIs0() {
		Assert.assertEquals(0, candyTestQuantity1.decrement());
	}
	
	@Test
	public void quantityIs1ResultIsNegative() {
		Assert.assertEquals(-1, candyTestQuantity0.decrement());
	}

}
