package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class GumTest {
	
	// Test getMessage method
	Gum gumTestMessage = new Gum("D3", "Chiclets", new BigDecimal("0.75"), "Gum", 5);
	Candy candyTestMessage = new Candy("B4", "Crunchie", new BigDecimal("1.75"), "Candy", 5);
	
	@Test
	public void productIsGumGetMessage() {
		Assert.assertEquals("Chew Chew, Yum!", gumTestMessage.getMessage());
	}
	
	@Test
	public void productIsCandyGetMessageShouldNotBeChew() {
		boolean expectedResult = true;
		if (!(gumTestMessage.getMessage() == "Chew Chew, Yum!")) {
			expectedResult = false;
			Assert.assertEquals(expectedResult, candyTestMessage.getMessage());
		}
	}
	
	// Test decrement method
	Gum gumTestQuantity5 = new Gum("D3", "Chiclets", new BigDecimal("0.75"), "Gum", 5);
	Gum gumTestQuantity4 = new Gum("D3", "Chiclets", new BigDecimal("0.75"), "Gum", 4);
	Gum gumTestQuantity3 = new Gum("D3", "Chiclets", new BigDecimal("0.75"), "Gum", 3);
	Gum gumTestQuantity2 = new Gum("D3", "Chiclets", new BigDecimal("0.75"), "Gum", 2);
	Gum gumTestQuantity1 = new Gum("D3", "Chiclets", new BigDecimal("0.75"), "Gum", 1);
	Gum gumTestQuantity0 = new Gum("D3", "Chiclets", new BigDecimal("0.75"), "Gum", 0);
	
	@Test
	public void quantityIs5ResultIs4() {
		Assert.assertEquals(4, gumTestQuantity5.decrement());
	}
	
	@Test
	public void quantityIs4ResultIs3() {
		Assert.assertEquals(3, gumTestQuantity4.decrement());
	}
	
	@Test
	public void quantityIs3ResultIs2() {
		Assert.assertEquals(2, gumTestQuantity3.decrement());
	}
	
	@Test
	public void quantityIs2ResultIs1() {
		Assert.assertEquals(1, gumTestQuantity2.decrement());
	}	
	
	@Test
	public void quantityIs1ResultIs0() {
		Assert.assertEquals(0, gumTestQuantity1.decrement());
	}
	
	@Test
	public void quantityIs1ResultIsNegative() {
		Assert.assertEquals(-1, gumTestQuantity0.decrement());
	}
}
