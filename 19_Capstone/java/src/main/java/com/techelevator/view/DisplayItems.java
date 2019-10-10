package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DisplayItems {

	public static void main(String[] args) throws FileNotFoundException {

		Integer productAmount = 5;
		
		File inputFile = new File("vendingmachine.csv");
//		File newFile = new File("updatedvendingmachine.csv");
//		PrintWriter pw = new PrintWriter(inputFile.getAbsoluteFile());

//		PrintWriter pw = null;
		
		if (inputFile.exists()) {
//			pw = new PrintWriter(inputFile.getAbsoluteFile());
			System.out.println("File found.");
		}

		try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())) {

			while (inputScanner.hasNextLine()) {
				String lineInput = inputScanner.nextLine();
				String [] lineData = lineInput.split("\\|");
//				pw.append("|5");
//				pw.flush();
//				pw.close();
				String slot = lineData[0];
				String productName = lineData[1];
				String price = lineData[2];
				String productType = lineData[3];
				
				
				
				System.out.println(slot + " " + productName + " " + price);
			}			
		}
	}
}
