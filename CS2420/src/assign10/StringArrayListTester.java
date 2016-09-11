/**
 * StringArrayListerTester.java
 * 
 * This program tests the functions made in StringArrayList.java using
 * the input.txt file that is used for ReverseFile.java. In order to test the
 * functions, this program MUST be used with some kind of input.txt file.
 * This program also creates an empty StringArrayList to show how the functions
 * work with an empty array.
 * 
 * Author: Brandon Mouser, mouser
 * Last Edited: November 17, 2015
 * 
 */

package assign10;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import assign10.StringArrayList;

public class StringArrayListTester {

	public static void main(String[] args) {
		File bookFile = new File("input.txt");
		Scanner s = null;

		try {
			s = new Scanner(bookFile);
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		StringArrayList words = new StringArrayList();
		while (s.hasNext()) {
			words.append(s.next());
		}
		
		StringArrayList emptyList = new StringArrayList();
		
		System.out.println("Hello! This program tests the functions made in the "
				+ "StringArrayList.java class.");
		System.out.println();
		System.out.println("First off, if a function takes in an integer "
				+ "that is some position in the list,");
		System.out.println("and the integer is not within the range of the array/list, "
				+ "the function prints an error message.");
		System.out.println("For example, using the function .size(), there are "
				+ words.size() + " words in this list.");
		System.out.println("If the user were to pass in a "
				+ (words.size() + 1) + ", which is not an index of the array,"
				+ " the function would print:");
		System.out.println(words.get(words.size() + 1));
		System.out.println();
		System.out.println("Using the .toString() function, the words in this list are");
		System.out.println(words.toString());
		System.out.println();
		System.out.println("If we were to replace a word at any part of the list, we would use the"
				+ " .put(int pos, String s) function.");
		System.out.println("Let's replace the fourth word in the list with the word 'world'");
		System.out.println("(Assuming that the array has at least four words in it)");
		System.out.println("Using words.put(3, 'world'), the new array list would look like this:");
		words.put(3, "world");
		System.out.println(words.toString());
		System.out.println();
		System.out.println("To get any word from the list use the .get(int pos) function.");
		System.out.println("Where the integer passed in is the word at "
				+ "that position that you want to get.");
		System.out.println("For example, if we wanted to get the 6th word in the list, "
				+ "we would do words.get(5)");
		System.out.println("Assuming there are 6 words in the list, that word would be '"
				+ words.get(5) + "'.");
		System.out.println();
		System.out.println("Now let's remove this word using the .remove(int pos) function.");
		System.out.println("The new list would look like this: ");
		words.remove(5);
		System.out.println(words.toString());
		System.out.println("Using the .size() function, there are now "
				+ words.size() + " words in this list.");
		System.out.println();
		System.out.println("To add words to the end of the list, use the function .append(String s)");
		System.out.println("Let's add the word 'bunny' to the end of the list.");
		words.append("bunny");
		System.out.println("The new list would look like this:");
		System.out.println(words.toString());
		System.out.println("Using the .size() function, there are now "
				+ words.size() + " words in this list.");
		System.out.println();
		System.out.println("What if we have an empty list?");
		System.out.println("Let's make an empty list called emptyList and fill it"
				+ " with nothing. Let's see what we get.");
		System.out.println("The size of this list is " + emptyList.size());
		System.out.println("This list looks like this:" + emptyList.toString());
		System.out.println("Let's add a word, cowboy, to the list.");
		emptyList.append("cowboy");
		System.out.println("Now the list looks like this: " + emptyList.toString());
		System.out.println("The size of this list is now " + emptyList.size() + ".");
	}
}
