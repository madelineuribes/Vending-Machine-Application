package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplayItems {

	public static void main(String[] args) throws FileNotFoundException {

		Integer productAmount = 5;
		
		File inputFile = new File("vendingmachine.csv");

		if (inputFile.exists()) {
			System.out.println("File found.");
		}

		try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())) {

			while (inputScanner.hasNextLine()) {
				String lineInput = inputScanner.nextLine();
				
				
			}
			
		}
	}
}
