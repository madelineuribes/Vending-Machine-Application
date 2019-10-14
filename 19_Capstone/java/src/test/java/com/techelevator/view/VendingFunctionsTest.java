package com.techelevator.view;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class VendingFunctionsTest {
	VendingFunctions vendingFunctionsTest = new VendingFunctions();

	// Testing feedMoney in VendingFunctions
	@Test
	public void balanceIsZeroFeedOneDollarResultsIsOneDollarAmountToAddBack() {
		Assert.assertEquals(new BigDecimal("1"), vendingFunctionsTest.feedMoney("Feed 1 dollars", BigDecimal.ZERO));
	}
	@Test
	public void balanceIsZeroFeedTwoDollarResultsIsTwoDollarAmountToAddBack() {
		Assert.assertEquals(new BigDecimal("2"), vendingFunctionsTest.feedMoney("Feed 2 dollars", BigDecimal.ZERO));
	}
	@Test
	public void balanceIsZeroFeedFiveDollarResultsIsFiveDollarAmountToAddBack() {
		Assert.assertEquals(new BigDecimal("5"), vendingFunctionsTest.feedMoney("Feed 5 dollars", BigDecimal.ZERO));
	}
	@Test
	public void balanceIsZeroFeedTenDollarResultsIsTenDollarAmountToAddBack() {
		Assert.assertEquals(new BigDecimal("10"), vendingFunctionsTest.feedMoney("Feed 10 dollars", BigDecimal.ZERO));
	}
	@Test
	public void balanceIsOneFeedFiveDollarResultsIsFiveDollarAmountToAddBack() {
		Assert.assertEquals(new BigDecimal("5"), vendingFunctionsTest.feedMoney("Feed 5 dollars", BigDecimal.ONE));
	}
	@Test
	public void balanceIsTenFeedTwoDollarResultsIsTwoDollarAmountToAddBack() {
		Assert.assertEquals(new BigDecimal("2"), vendingFunctionsTest.feedMoney("Feed 2 dollars", BigDecimal.TEN));
	}
	@Test
	public void balanceIsOneFeedTenDollarResultsIsTenDollarAmountToAddBack() {
		Assert.assertEquals(new BigDecimal("10"),
				vendingFunctionsTest.feedMoney("Feed 10 dollars", new BigDecimal("2")));
	}
	@Test
	public void balanceIsFiveFeedOneDollarResultsIsOneDollarAmountToAddBack() {
		Assert.assertEquals(new BigDecimal("1"), vendingFunctionsTest.feedMoney("Feed 1 dollars", new BigDecimal("5")));
	}
	
	
	// Test selectProduct method in VendingFunctions
	@Test
	public void testSelectProductBalanceTenReturnNull() {
		Assert.assertEquals(null, vendingFunctionsTest.selectProduct("A1", BigDecimal.TEN));
	}
	
	@Test
	public void testSelectProductBalanceZeroReturnNull() {
		Assert.assertEquals(null, vendingFunctionsTest.selectProduct("B3", BigDecimal.ZERO));
	}
	
	
	// Test testSubtract method 
	@Test
	public void testSubtract375Minus365ResultIs10Cents() {
		Inventory doritos = new Chips("A1", "doritos", new BigDecimal("3.65"), "Chip", 5);
		BigDecimal balance = vendingFunctionsTest.subtractBalance(doritos, new BigDecimal("3.75"));
		BigDecimal expectedBalance = new BigDecimal("0.10");
		Assert.assertEquals(expectedBalance, balance);
	}
	@Test
	public void testSubtractCowtaleBalance10Resultis850() {
		Inventory cowtales = new Chips("B2", "Cowtales", new BigDecimal("1.50"), "Candy", 5);
		BigDecimal balance = vendingFunctionsTest.subtractBalance(cowtales, new BigDecimal("10"));
		BigDecimal expectedBalance = new BigDecimal("8.50");
		Assert.assertEquals(expectedBalance, balance);
	}
	@Test
	public void testSubtractProductPriceZeroBalanceIs5ResultIs5() {
		Inventory soup = new Chips("Q2", "Soup", BigDecimal.ZERO, "Chip", 0);
		BigDecimal balance = vendingFunctionsTest.subtractBalance(soup, new BigDecimal("5"));
		BigDecimal expectedBalance = new BigDecimal("5");
		Assert.assertEquals(expectedBalance, balance);
	}
	@Test
	public void testSubtractBalanceIsZeroResultIsNegative() {
		Inventory soup = new Chips("C4", "Heavy", new BigDecimal("1.50"), "Drink", 0);
		BigDecimal balance = vendingFunctionsTest.subtractBalance(soup, BigDecimal.ZERO);
		BigDecimal expectedBalance = new BigDecimal("-1.50");
		Assert.assertEquals(expectedBalance, balance);
	}
	@Test
	public void testSubtractZeroFromZeroResultIsZero() {
		Inventory nothing = new Chips("E1", "Nothing", BigDecimal.ZERO, "Drink", 0);
		BigDecimal balance = vendingFunctionsTest.subtractBalance(nothing, BigDecimal.ZERO);
		BigDecimal expectedBalance = BigDecimal.ZERO;
		Assert.assertEquals(expectedBalance, balance);
	}
	
	//
	
}
