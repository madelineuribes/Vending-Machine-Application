package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class bookKeeping {
	
	public void timeStamp(BigDecimal balance) throws FileNotFoundException {
		LocalDate todaysDate = LocalDate.now();
		LocalTime todaysTime = LocalTime.now();
		PrintWriter write = new PrintWriter(new FileOutputStream(new File("recordsForYourFace.txt")));
		
		String today = todaysDate.toString();
		String time = todaysTime.toString();
		String balanceString = balance.toString();
		
		write.flush();
		write.close();
	}
	
}
