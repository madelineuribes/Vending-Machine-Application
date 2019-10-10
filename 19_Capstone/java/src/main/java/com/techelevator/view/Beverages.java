package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public abstract class Beverages implements Inventory {
	
	Map <String, String> hm = new HashMap<String, String>() {
		put("A1", "Potato Crisps $3.05");
	}
	
	public String getMessage() {	
		return "Glug Glug, Yum";
	}

}


