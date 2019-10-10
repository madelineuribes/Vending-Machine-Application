package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
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

			System.out.println("I am in the display vending machines section.");

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
					// feed money
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
}