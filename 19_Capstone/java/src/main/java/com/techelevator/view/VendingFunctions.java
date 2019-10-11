package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.techelevator.VendingMachineCLI;

public class VendingFunctions {

	List<Inventory> vendingArray = new ArrayList<>();

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

	public BigDecimal feedMoney(String choice) {
		BigDecimal amountToAddBack = new BigDecimal(0);

		if (choice.equals("Feed 1 dollars")) {

			amountToAddBack = new BigDecimal(1.00);
		} else if (choice.equals("Feed 2 dollars")) {
			amountToAddBack = new BigDecimal(2.00);
		} else if (choice.equals("Feed 5 dollars")) {
			amountToAddBack = new BigDecimal(5.00);
		} else if (choice.equals("Feed 10 dollars")) {
			amountToAddBack = new BigDecimal(10.00);
		}

		return amountToAddBack;
	}

	public Inventory selectProduct() {

		displayInventory();
		System.out.println("Enter Product Code: ");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		boolean isFound = false;
		for (Inventory item : vendingArray) {
			if (userInput.equals(item.getSlot())) {
				System.out.println(item.getName() + " | $" + item.getPrice());
				System.out.println(item.getMessage());
				System.out.println("before: " + item.getQuantity());
				if (!(item.getQuantity() <= 0)) {
					item.decrement();
				}

				System.out.println(item.getQuantity());
				isFound = true;
				return item;
			}
		}
		if (!(isFound)) {
			System.out.println("Invalid Selection.");
		}
		return null;
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

		System.out.println(
				"Your change is " + quarters1 + " quarters and " + dime1 + " dimes and " + nickels1 + " nickels. ");
	}

}
