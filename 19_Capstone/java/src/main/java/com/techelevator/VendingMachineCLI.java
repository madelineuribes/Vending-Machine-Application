package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

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

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				File inputFile = new File("vendingmachine.csv");
				try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())) {
					while (inputScanner.hasNextLine()) {
						String lineInput = inputScanner.nextLine();
						System.out.println(lineInput);
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
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
