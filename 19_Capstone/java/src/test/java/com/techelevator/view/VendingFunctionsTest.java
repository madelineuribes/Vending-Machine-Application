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

	// Testing selectProduct Method
	@Test
	public void userInputA1BalanceIs0ReturnZero() {
		Assert.assertEquals(BigDecimal.ZERO, vendingFunctionsTest.selectProduct("A1", BigDecimal.ZERO));
	}
	
	@Test
	public void userInputB1BalanceIs0ReturnZero() {
		Assert.assertEquals(BigDecimal.ZERO, vendingFunctionsTest.selectProduct("B1", BigDecimal.ZERO));
	}
	
	@Test
	public void userInputC1BalanceIs0ReturnZero() {
		Assert.assertEquals(BigDecimal.ZERO, vendingFunctionsTest.selectProduct("C1", BigDecimal.ZERO));
	}
	
	@Test
	public void userInputD1BalanceIs0ReturnZero() {
		Assert.assertEquals(BigDecimal.ZERO, vendingFunctionsTest.selectProduct("D1", BigDecimal.ZERO));
	}
	
	@Test
	public void userInputQ1BalanceIs1ReturnOne() {
		Assert.assertEquals(BigDecimal.ONE, vendingFunctionsTest.selectProduct("Q1", BigDecimal.ONE));
	}
	
	@Test
	public void userInputA1BalanceIs10Return695() {
		Assert.assertEquals(new BigDecimal("6.95"), vendingFunctionsTest.selectProduct("A1", new BigDecimal("6.95")));
	}
	
//	@Test
//	public void someName() {
//		 vendingFunctionsTest.selectProduct("A1", new BigDecimal("6.95"));
//		 vendingFunctionsTest.selectProduct("A1", BigDecimal.TEN);
//	}
	
	@Test
	public void testSubtract() {
		Inventory doritos = new Chips("A1", "doritos", new BigDecimal("3.65"), "Chip", 5);
		BigDecimal balance = vendingFunctionsTest.subtractBalance(doritos, new BigDecimal("3.75"));
		BigDecimal expectedBalance = new BigDecimal("0.10");
		Assert.assertEquals(expectedBalance, balance);
	}

}
