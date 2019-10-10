package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DisplayItems {

	public static void getDisplay (File inputFile) throws FileNotFoundException {
		
		if (inputFile.exists()) {
			System.out.println("File found.");
		}

		try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())) {

			while (inputScanner.hasNextLine()) {
				String lineInput = inputScanner.nextLine();
				String [] lineData = lineInput.split("\\|");
				String slot = lineData[0];
				String productName = lineData[1];
				String price = lineData[2];
				
				System.out.println(slot + " " + productName + "  Price: $" + price);
			}			
		}
		
	}
}
