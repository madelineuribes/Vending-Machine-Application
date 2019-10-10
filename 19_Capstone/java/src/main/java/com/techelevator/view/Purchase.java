package com.techelevator.view;

import com.techelevator.view.Menu;


public class Purchase {

	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String PURCHASE_MENU_OPTION_CURRENT_MONEY = "Current Money Provided: ";
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};
	
	private Menu purchaseMenu;
	
	public Purchase(Menu purchaseMenu) {
		this.purchaseMenu = purchaseMenu;
	}

	
	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		Purchase cli = new Purchase(menu);
		cli.runPurchase();
	}
	
	public void runPurchase() {
		while (true) {
			String choice = (String) purchaseMenu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				System.out.println("I am in the display vending machines section.");
				
			if (choice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
				// feed money
			} else if (choice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
				System.out.println("I am in the purchase section.");
				// select product
			} else if (choice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
				// finish transaction
			} else if (choice.equals(PURCHASE_MENU_OPTION_CURRENT_MONEY)) {
				// display current money
			}
		}
	}
}
