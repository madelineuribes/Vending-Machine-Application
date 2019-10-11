package com.techelevator.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VendingFunctions {
	//BigDecimal balance = new BigDecimal(0.00).setScale(2);
	//List<Product> purchaseList = new ArrayList<>();
	//LogWriter writer = new LogWriter();
	
	Map<String, List<Inventory>> inventory = new HashMap<>();

	public void displayInventory() {
		
		
		
		/*	
		if (quantity == 0) {
				System.out.println(name + " Out of stock");
			} 
		*/
	}
	
	
	
	
	
	
	
/*
	public void feedMoney(int addMoney) {
		String typeOfTransaction = "FEED MONEY:";
		if (addMoney == 1) {
			balance = balance.add(new BigDecimal(1.00));
			writer.writer(typeOfTransaction, new BigDecimal(1.00).setScale(2), balance);

		} else if (addMoney == 2) {
			balance = balance.add(new BigDecimal(2.00));
			writer.writer(typeOfTransaction, new BigDecimal(2.00).setScale(2), balance);
		} else if (addMoney == 3) {
			balance = balance.add(new BigDecimal(5.00));
			writer.writer(typeOfTransaction, new BigDecimal(5.00).setScale(2), balance);
		} else if (addMoney == 4) {
			balance = balance.add(new BigDecimal(10.00));
			writer.writer(typeOfTransaction, new BigDecimal(10.00).setScale(2), balance);
		}
		System.out.println("Your balance is " + balance);
	}
*/
}
