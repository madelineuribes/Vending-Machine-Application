package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingFunctions {
	
	List <Inventory> vendingArray = new ArrayList<>();

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
				if (type.equals("Ch1"
						+ "ip")) {
					vendingArray.add(new Chips(slot, name, price, type, 5));
				} else if (type.equals("Candy")) {
					vendingArray.add(new Candy(slot, name, price, type, 5));
				} else if(type.equals("Gum")) {
					vendingArray.add(new Candy(slot, name, price, type, 5));
				} else if(type.equals("Drink")) {
					vendingArray.add(new Candy(slot, name, price, type, 5));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void displayInventory() {
		
		for(Inventory item: vendingArray) {
			System.out.println(item.getSlot() + " "+ item.getName()  + " $" +  item.getPrice()  + " Quantity: "
					+ "" + item.getQuantity());
			
			if (item.getQuantity() == 0) {
				System.out.println(item.getName() + " Out of stock");
			} 
		}
	}
	
	public void feedMoney(String choice) {
		BigDecimal balance = new BigDecimal(0);
		
		while(!(choice.equals("Done"))){
			if (choice.equals("Feed 1 dollar")) {
				balance = balance.add(new BigDecimal(1.00));
			}
			else if (choice.equals("Feed 2 dollar")) {
				balance = balance.add(new BigDecimal(2.00));
			}
			else if (choice.equals("Feed 5 dollar")) {
				balance = balance.add(new BigDecimal(5.00));
			}
			else if (choice.equals("Feed 10 dollar")) {
				balance = balance.add(new BigDecimal(10.00));
			}
			else if (choice.equals("Done")) {
				break;
			}
		}
		
		System.out.println("Current Balance: " + balance);	
	}

	
	
	
	
	
	
	

	
	
	
	
	
	
	
	//BigDecimal balance = new BigDecimal(0.00).setScale(2);
	//List<Product> purchaseList = new ArrayList<>();
	//LogWriter writer = new LogWriter();
	
	
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
