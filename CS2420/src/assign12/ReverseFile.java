/**
 * ReverseFile.java
 * 
 * This program reads in words from an input.txt file and writes the words
 * into an output.txt file in opposite order. The words that are brought
 * in from the input.txt file are stored in a String Linked List that is
 * made using the StringLinkedList class.
 * 
 * @author Brandon Mouser, mouser
 * Last Edited: December 1, 2015
 * 
 */

package assign12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReverseFile {

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

		try {
			PrintWriter write = new PrintWriter(new File("output.txt"));
			for (int i = words.size() - 1; i >= 0; i--) {
				write.println(words.get(i));
			}
			write.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

