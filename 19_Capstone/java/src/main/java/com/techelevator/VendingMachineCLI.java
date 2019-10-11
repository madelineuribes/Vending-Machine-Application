package com.techelevator;

import java.math.BigDecimal;

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
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	private VendingFunctions vm = new VendingFunctions();

	private Menu menu;
	BigDecimal runningBalance = new BigDecimal("0.00");

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		vm.loadInventory();

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				vm.displayInventory();
			}

			else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				System.out.println("I am in the purchase section.");
				String choicePurchase = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

				if (choicePurchase.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
					System.out.println("Feed Money");
					final String FEED_MONEY_1 = "Feed 1 dollars";
					final String FEED_MONEY_2 = "Feed 2 dollars";
					final String FEED_MONEY_5 = "Feed 5 dollars";
					final String FEED_MONEY_10 = "Feed 10 dollars";
					final String FEED_MONEY_DONE = "Done";
					final String[] FEED_MONEY_MENU_OPTIONS = { FEED_MONEY_1, FEED_MONEY_2, FEED_MONEY_5, FEED_MONEY_10,
							FEED_MONEY_DONE };

					boolean feedMoneyLoopContinue = true;

					while (feedMoneyLoopContinue) {

						String feedChoice = (String) menu.getChoiceFromOptions(FEED_MONEY_MENU_OPTIONS);

						if (feedChoice.equals("Done")) {
							feedMoneyLoopContinue = false;
						} else {

							BigDecimal amountAdded = vm.feedMoney(feedChoice);
							runningBalance = runningBalance.add(amountAdded);
						}
					}

					System.out.println("The total running balance" + runningBalance);

				} else if (choicePurchase.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {
					Inventory item = vm.selectProduct();
					if (item == null) {
						String feedChoice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
					} else if(item.getQuantity() <= 0){ 
						String feedChoice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
						System.out.println("Out Of Stock. You Broke Us.");
					}
						else {
						// find out if they have enough money
					//	BigDecimal remainingBalance;
						runningBalance = runningBalance.subtract(item.getPrice());
						System.out.println("Remaining Balance: " + runningBalance);
						String feedChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					}

				} else if (choicePurchase.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
					// vm.finishTransaction();
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
