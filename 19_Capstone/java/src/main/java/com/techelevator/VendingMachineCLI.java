package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.Purchase;

import java.io.File;
import java.io.FileNotFoundException;

import com.techelevator.view.DisplayItems;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

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
				try {
					DisplayItems.getDisplay(inputFile);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("I am in the purchase section.");
				
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
