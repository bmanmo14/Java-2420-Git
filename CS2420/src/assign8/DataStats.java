package assign8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program reads in a set of numbers from a file named data.txt and then
 * computes how many numbers are in the file, the sum of the numbers, the
 * average of all numbers, the smallest number in the file, and the largest
 * number in the file. The program then gives the info to the user through the
 * console.
 * 
 * @author Brandon Mouser, mouser Last Edited on November 2, 2015.
 */
public class DataStats {

	public static void main(String[] args) {

		File bookFile = new File("data.txt");
		Scanner s = null;
		try {
			s = new Scanner(bookFile);
		} // When using the "Format" option in Eclipse, it put catch up here.
		catch (FileNotFoundException e) { // But it looks better down here.
			System.out.println(e.getMessage());
		}
		ArrayList<Double> numbers = new ArrayList<Double>();
		while (s.hasNext()) {
			numbers.add(s.nextDouble());
		}
		System.out.println("The count of all numbers in the file is "
				+ numbers.size() + ".");
		System.out.println("The sum of all numbers in the file is "
				+ sumNumber(numbers) + ".");
		System.out.println("The average of all numbers in the file is "
				+ averageNumber(numbers) + ".");
		System.out.println("The smallest number in the file is "
				+ smallestNumber(numbers) + ".");
		System.out.println("The largest number in the file is "
				+ largestNumber(numbers) + ".");
	}

	/**
	 * Determines the largest value in the .txt file.
	 * 
	 * @param words -- The array of numbers in the .txt file.
	 * @return double largest -- The largest number in the file.
	 */
	public static double largestNumber(ArrayList<Double> numbers) {
		double largest = 0.00;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) > largest) {
				largest = numbers.get(i);
			}
		}
		return largest;
	}

	/**
	 * Determines the smallest value in the .txt file.
	 * 
	 * @param words -- The array of numbers in the .txt file.
	 * @return double smallest -- The smallest number in the file.
	 */
	public static double smallestNumber(ArrayList<Double> numbers) {
		double smallest = largestNumber(numbers);
		for (int i = 0; i < numbers.size(); i++) {
			if (smallest > numbers.get(i)) {
				smallest = numbers.get(i);
			}
		}
		return smallest;
	}

	/**
	 * Determines the average value of all numbers in the .txt file.
	 * 
	 * @param words -- The array of numbers in the .txt file.
	 * @return double average -- The average of all numbers in the file.
	 */
	public static double averageNumber(ArrayList<Double> numbers) {
		double average = sumNumber(numbers) / numbers.size();
		return average;
	}

	/**
	 * Determines the sum of all numbers in the .txt file.
	 * 
	 * @param words -- The array of numbers in the .txt file.
	 * @return double sum -- The sum of all numbers in the file.
	 */
	public static double sumNumber(ArrayList<Double> numbers) {
		double sum = 0.00;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
		}
		return sum;
	}

}
