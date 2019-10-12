package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class AuditEntry {
	public void writer(String typeOfTransaction, BigDecimal amount, BigDecimal balance) {

		LocalDate todaysDate = LocalDate.now();
		LocalTime currentTime = LocalTime.now();
		try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(new File("./log.txt"), true))) {

			String printToday = todaysDate.toString();
			String printTime = currentTime.toString().substring(0, currentTime.toString().length() - 4);
			String printTypeOfTransaction = typeOfTransaction.toString();
			String printAmount = amount.toString();
			String printBalance = balance.toString();

			logWriter.println(printToday + " " + printTime + " " + String.format("%-25s", printTypeOfTransaction)
					+ String.format("%-10s", "$" + printAmount) + String.format("%-10s", "$" + printBalance));

		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}
}