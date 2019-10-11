package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.view.Candy;
import com.techelevator.view.Chips;
import com.techelevator.view.Inventory;
import com.techelevator.view.Menu;
import com.techelevator.view.VendingFunctions;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
			MAIN_MENU_OPTION_EXIT };

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String PURCHASE_MENU_OPTION_CURRENT_MONEY = "Current Money Provided: ";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private static final String MONEY_MENU_OPTION_ONE = "Feed 1 dollar";
	private static final String MONEY_MENU_OPTION_TWO = "Feed 2 dollars";
	private static final String MONEY_MENU_OPTION_FIVE = "Feed 5 dollars";
	private static final String MONEY_MENU_OPTION_TEN = "Feed 10 dollars";
	private static final String[] MONEY_MENU_OPTIONS = { MONEY_MENU_OPTION_ONE, MONEY_MENU_OPTION_TWO,
			MONEY_MENU_OPTION_FIVE, MONEY_MENU_OPTION_TEN };
	
	private static VendingFunctions vm = null;
	
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		// read in the file
		File inputFile = new File("vendingmachine.csv");
		List <Inventory> vendingArray = new ArrayList<>();
		
		try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())) {
			while (inputScanner.hasNextLine()) {
				String lineInput = inputScanner.nextLine();
				String[] lineStuff = lineInput.split("\\|");
				String slot = lineStuff[0];
				String name = lineStuff[1];
				BigDecimal price = new BigDecimal(lineStuff[2]);
				String type = lineStuff[3];
				if (type.equals("Chips")) {
					vendingArray.add(new Chips(slot, name, price, type, 5));
				} else if (type.equals("Candy")) {
					vendingArray.add(new Candy(slot, name, price, type, 5));
				} else if(type.equals("Gum")) {
					vendingArray.add(new Candy(slot, name, price, type, 5));
				} else if(type.equals("Beverages")) {
					vendingArray.add(new Candy(slot, name, price, type, 5));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				vm.displayInventory();
			}

			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("I am in the purchase section.");
				String choicePurchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

				if (choicePurchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					getCurrentMoneyEntered(this.menu);
				} else if (choicePurchase.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					// select product
				} else if (choicePurchase.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					// finish transaction
				}
			}

			else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	
	public static void getCurrentMoneyEntered(Menu menu) {

		final String FEED_MONEY_1 = "$1";
		final String FEED_MONEY_2 = "$2";
		final String FEED_MONEY_5 = "$5";
		final String FEED_MONEY_10 = "$10";
		final String FEED_MONEY_20 = "$20";
		final String FEED_MONEY_EXIT = "Exit";
		final String[] FEED_MONEY_MENU_OPTIONS = { FEED_MONEY_1, FEED_MONEY_2, FEED_MONEY_5, FEED_MONEY_10,
				FEED_MONEY_20, FEED_MONEY_EXIT};

		String choice = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU_OPTIONS);
		int currentTotal = 0;
		
		while (true) {
			if (choice.equals(FEED_MONEY_1)) {
				currentTotal++;
			}
			else if (choice.equals(FEED_MONEY_2)) {
				currentTotal += 2;
			}
			else if (choice.equals(FEED_MONEY_5)) {
				currentTotal += 5;
			}
			else if (choice.equals(FEED_MONEY_10)) {
				currentTotal += 10;
			}
			else if (choice.equals(FEED_MONEY_20)) {
				currentTotal += 20;
			}
			else if (choice.equals(FEED_MONEY_EXIT)) {
				break;
			}
		}
	
		System.out.println("Current Money Provided: " + currentTotal);
	}
}
