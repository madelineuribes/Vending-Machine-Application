package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class VendingFunctions {

	List<Inventory> vendingArray = new ArrayList<>();
	AuditEntry writer = new AuditEntry();

	public void loadInventory() {
		// read in the file
		File inputFile = new File("vendingmachine.csv");

		try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())) {
			while (inputScanner.hasNextLine()) {
				String lineInput = inputScanner.nextLine();
				String[] productInfo = lineInput.split("\\|");
				String slot = productInfo[0];
				String name = productInfo[1];
				BigDecimal price = new BigDecimal(productInfo[2]);
				String type = productInfo[3];
				if (type.equals("Chip")) {
					vendingArray.add(new Chips(slot, name, price, type, 5));
				} else if (type.equals("Candy")) {
					vendingArray.add(new Candy(slot, name, price, type, 5));
				} else if (type.equals("Gum")) {
					vendingArray.add(new Candy(slot, name, price, type, 5));
				} else if (type.equals("Drink")) {
					vendingArray.add(new Candy(slot, name, price, type, 5));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void displayInventory() {
		for (Inventory item : vendingArray) {
			System.out.println(item.getSlot() + " " + item.getName() + " $" + item.getPrice() + " Quantity: " + ""
					+ item.getQuantity());

			if (item.getQuantity() == 0) {
				System.out.println(item.getName() + " Out of stock");
			}
		}
	}

	public BigDecimal feedMoney(String choice, BigDecimal runningBalance) {
		BigDecimal amountToAddBack = new BigDecimal(0);
		String typeOfTransaction = "FEED MONEY:";

		if (choice.equals("Feed 1 dollars")) {
			amountToAddBack = new BigDecimal(1.00);
			writer.writer(typeOfTransaction, new BigDecimal(1.00).setScale(2), runningBalance.add(amountToAddBack) );
		} else if (choice.equals("Feed 2 dollars")) {
			amountToAddBack = new BigDecimal(2.00);
			writer.writer(typeOfTransaction, new BigDecimal(2.00).setScale(2), runningBalance.add(amountToAddBack));
		} else if (choice.equals("Feed 5 dollars")) {
			amountToAddBack = new BigDecimal(5.00);
			writer.writer(typeOfTransaction, new BigDecimal(5.00).setScale(2), runningBalance.add(amountToAddBack));
		} else if (choice.equals("Feed 10 dollars")) {
			amountToAddBack = new BigDecimal(10.00);
			writer.writer(typeOfTransaction, new BigDecimal(10.00).setScale(2), runningBalance.add(amountToAddBack));
		}
		return amountToAddBack;
	}

	public BigDecimal selectProduct(String userInput, BigDecimal balance) {
		boolean isFound = false;

		for (Inventory item : vendingArray) {
			if (userInput.equals(item.getSlot())) {
				if (item.getQuantity() <= 0) {
					System.out.println("Out of Stock.");
				}
				if (!(item.getQuantity() <= 0)) {
					if (balance.compareTo(item.getPrice()) == 1) {

						item.decrement();
						
						balance = balance.subtract(item.getPrice());
						System.out.println("Remaining Balance: " + balance);
						
						System.out.println(item.getName() + " | $" + item.getPrice());
						System.out.println(item.getMessage());
	
						writer.writer(item.getName(), item.getPrice(), balance);

					} else {
						System.out.println("Enter More Money.");
					}
					isFound = true;
					return balance;
				}
			}
		}
		if (!(isFound)) {
			System.out.println("Invalid Selection.");
		}
		return null;
	}

	public BigDecimal subtractBalance (Inventory item, BigDecimal balance) {

		balance = balance.subtract(item.getPrice());
		System.out.println("Remaining Balance: " + balance);
		return balance;
	}

	public void finishTransaction(BigDecimal balance) {
		double balance1;
		int quarters1;
		int dime1;
		int nickels1;
		balance1 = (balance.doubleValue() * 100);
		quarters1 = ((int) balance1 / 25);
		balance1 = balance1 - (quarters1 * 25);
		dime1 = ((int) balance1 / 10);
		balance1 = balance1 - (dime1 * 10);
		nickels1 = ((int) balance1 / 5);

		writer.writer("GIVE CHANGE:", balance, new BigDecimal(0.00).setScale(2));

		System.out.println(
				"Your change is " + quarters1 + " quarters, " + dime1 + " dimes and " + nickels1 + " nickels. ");
	}

}
