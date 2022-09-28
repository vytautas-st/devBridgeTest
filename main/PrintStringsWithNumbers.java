package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintStringsWithNumbers {
	public void run() {
		try {
			Scanner myReader = new Scanner(new File("filename.txt"));
			while (myReader.hasNextLine()) { 											//Read while line is present
				String data = myReader.nextLine();
				findAndPrint(formatString(data), data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred while reading a file");
			e.printStackTrace();
		}
	}

	public List<String> formatString(String data) {
		String dataConvert = data.replaceAll("[a-zA-Z]", " "); 							//remove all letters from string
		return new ArrayList<String>(Arrays.asList(dataConvert.trim().split(" ")));		//return list of numbers from string
	}

	public void findAndPrint(List<String> numbers, String data) {
		try {
			for (String number : numbers) {
				if (number.equals(""))													//check if not empty record
					break; 																
				if (Integer.valueOf(number) >= 10) 										//find required values
					System.out.println(data);
			}
		} catch (NumberFormatException e) {
			System.out.println("An error occurred while converting numbers from string");
			e.printStackTrace();
		}
	}
}
