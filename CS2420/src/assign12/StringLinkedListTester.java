/**
 * StringLinkedListTester.java
 * 
 * This program tests the functions made in StringLinkedList.java using
 * the input.txt file that is used for ReverseFile.java. In order to test the
 * functions, this program MUST be used with some kind of input.txt file.
 * This program also creates an empty StringLinkedList to show how the functions
 * work with an empty List.
 * 
 * @author Brandon Mouser, mouser
 * Last Edited: December 1, 2015
 * 
 */

package assign12;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringLinkedListTester {

	public static void main(String[] args) {
		File bookFile = new File("input.txt");
		Scanner s = null;

		try {
			s = new Scanner(bookFile);
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		StringList words = new StringLinkedList();
		while (s.hasNext()) {
			words.append(s.next());
		}
		
		StringList emptyList = new StringLinkedList();	
		
		System.out.println("Hello! This program tests the functions made in the "
				+ "StringLinkedList.java class.");
		System.out.println();
		System.out.println("First off, if a function takes in an integer "
				+ "that is some position in the Linked List,");
		System.out.println("and the integer is not within the range of the List, "
				+ "the function prints an error message.");
		System.out.println("For example, using the function .size(), there are "
				+ words.size() + " words in this List.");
		System.out.println("If the user were to pass in a "
				+ (words.size()) + ", which, when starting at 0, is not an index of the List,");
		System.out.println("the function would print:");
		System.out.println(words.get(words.size()));
		System.out.println();
		System.out.println("Using the .toString() function, the words in this List are");
		System.out.println(words.toString());
		System.out.println();
		System.out.println("If we were to replace a word at any part of the List, we would use the"
				+ " .put(int pos, String s) function.");
		System.out.println("Let's replace the fourth word in the List with the word 'world'");
		System.out.println("(Assuming that the List has at least four words in it)");
		System.out.println("Using words.put(3, 'world'), the new List would look like this:");
		words.put(3, "world");
		System.out.println(words.toString());
		System.out.println();
		System.out.println("To get any word from the Linked List use the .get(int pos) function.");
		System.out.println("Where the integer passed in is the word at "
				+ "that position that you want to get.");
		System.out.println("For example, if we wanted to get the 6th word in the List, "
				+ "we would do words.get(5)");
		System.out.println("because when starting at 0, position 5 is the sixth word in the Linked List.");
		System.out.println("Assuming there are 6 words in the List, that word would be '"
				+ words.get(5) + "'.");
		System.out.println();
		System.out.println("Now let's remove this word using the .remove(int pos) function.");
		System.out.println("The new List would look like this: ");
		words.remove(5);
		System.out.println(words.toString());
		System.out.println("Using the .size() function, there are now "
				+ words.size() + " words in this Linked List.");
		System.out.println();
		System.out.println("To add words to the end of the List, use the function .append(String s)");
		System.out.println("Let's add the word 'today' to the end of the List.");
		words.append("today");
		System.out.println("The new List would look like this:");
		System.out.println(words.toString());
		System.out.println("Using the .size() function, there are now "
				+ words.size() + " words in this List.");
		System.out.println();
		System.out.println("Now let's remove the first word and last word in the List.");
		System.out.println("Right now, the first word at position 0 is " + words.get(0));
		System.out.println("and the last word in the List is " + words.get(words.size()-1));
		System.out.println("After we remove these words, the new List looks like this:");
		words.remove(words.size()-1);
		words.remove(0);
		System.out.println(words.toString());
		System.out.println("There are now " + words.size() + " words in this List.");
		System.out.println();
		System.out.println("What if we have an empty Linked List?");
		System.out.println("Let's make an empty List called emptyList and fill it"
				+ " with nothing. Let's see what we get.");
		System.out.println("The size of this List is " + emptyList.size());
		System.out.println("This List looks like this:" + emptyList.toString());
		System.out.println("Let's add a word, tomorrow, to the List using the .append() function.");
		emptyList.append("tomorrow");
		System.out.println("Now the List looks like this: " + emptyList.toString());
		System.out.println("The size of this List is now " + emptyList.size() + ".");
	}
}
