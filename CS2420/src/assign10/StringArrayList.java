/** 
 * StringArrayList.java
 * 
 * This Class makes a String List using an array of Strings.
 * The functions in this class:
 * Create a new String list,
 * Add words to the list,
 * Remove words from the list,
 * Put words into specific positions in the list,
 * Compute how many words are in the list,
 * And turn the list into a String just like the .toString() function would
 * do for an ArrayList<String>.
 * 
 * Author: Brandon Mouser, mouser
 * Last Edited: November 17, 2015
 * 
 */

package assign10;

public class StringArrayList {
	private String[] list;
	private int count;
	/** 
	 * This is the default Constructor for the StringArrayList.
	 * 
	 * It sets the size of the array to 10 and initializes count to 0.
	 */
	public StringArrayList() {
		this.list = new String[10];
		count = 0;
	}

	/**
	 * This function adds words to the String list and doubles the size
	 * of the String array when necessary. Each word that is added to the
	 * list increases the count of the list by 1.
	 * 
	 * @param String s -- Some word that is passed in by the user.
	 */
	public void append(String s) {
		if (count == list.length) {
			String[] newList = new String[list.length * 2];
			for (int i = 0; i < list.length; i++) {
				newList[i] = list[i];
			}
			list = newList;
		}
		list[count] = s;
		count++;
	}
	
	/**
	 * This function removes an word from the list and shrinks the size of
	 * the list after removing the word. The word that is removed is at
	 * some position in the array that is passed in by the user.
	 * 
	 * @param int pos -- The position in the array that will be removed.
	 * 					 Assuming that position is valid.
	 */
	public void remove(int pos) {
		if (pos > count) {
			System.out.println("ERROR! No word at this position.");
		}
		for (int i = pos; i < count; i++) {
			list[i] = list[i + 1];
		}
		count = count - 1;
	}
	
	/**
	 * This function gets a word from the list at a specific position
	 * and returns it to the user.
	 * 
	 * @param int pos -- The position in the list that the user wants
	 * 					 to get the word from. Assuming that position is valid.
	 * @return String -- Returns a String that is the word at the users
	 * 					 desired location.
	 */
	public String get(int pos) {
		String get = "";
		if (pos > count) {
			get = "ERROR! No word at this position.";
		} else {
			get = list[pos];
		}
		return get;
	}

	/**
	 * This function finds a specific place in the list and replaces the word
	 * that is there with a new word of the users choice.
	 * 
	 * @param int pos -- The position in the list where the user wants to 
	 * 					 replace a word. Assuming that position is valid.
	 * @param String s -- The word that the user wants the word in the list
	 * 					  to be replaced by.
	 */
	public void put(int pos, String s) {
		if (pos > count) {
			System.out.println("ERROR! No word at this position.");
		}
		list[pos] = s;
	}

	/**
	 * This function displays the number of words in the list.
	 * 
	 * @return int -- The number of words in the list.
	 */
	public int size() {
		return count;
	}

	/**
	 * This function turns the words in the list into a string of words.
	 * Just like the .toString() function would do for an ArrayList<String>,
	 * this function displays the words in brackets with commas after the 
	 * word.
	 * 
	 * @return String -- The words in the list put into one string.
	 */
	public String toString() {
		String toString = "";
		for (int i = 0; i < count; i++) {
			if (i < count - 1) {
			toString += (list[i] + ", ");
			}
			if (i == count-1) {
				toString += (list[count-1]);
			}
		}
		toString = "[" + toString + "]";
		return toString;
	}
}
