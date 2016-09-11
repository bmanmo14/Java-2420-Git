/** 
 * StringLinkedList.java
 * 
 * This Class makes a Linked List using Node's to store a collection of Strings.
 * When searching for a specific position in the Linked List, remember that the 
 * head (or first) position starts at 0, not 1.
 * The functions in this class:
 * Create a new String List,
 * Add/Append words to the List,
 * Remove words from the List,
 * Put words into specific positions in the List,
 * Keep track of how many words are in the Linked List,
 * And turn the List into a String just like the .toString() function would
 * do for an ArrayList<String>.
 * 
 * @author Brandon Mouser, mouser
 * Last Edited: December 1, 2015
 * 
 */

package assign12;

public class StringLinkedList implements StringList {
	
	/**
	 * This Node Class stores a String item called data and a reference to the
	 * next node called next.
	 */
	private class Node {
		public String data;
		public Node next;
	}

	private Node head;
	private Node tail;
	private int count;

	/**
	 * This is the default Constructor for the StringLinkedList. It sets the
	 * head and tail Node's to null and initializes count to 0.
	 */
	public StringLinkedList() {
		this.head = null;
		this.tail = null;
		count = 0;
	}

	/**
	 * This function adds words to the end of the Linked List and adds 1 to
	 * count every time a new word is added.
	 * 
	 * @param String s -- A word that is passed in.
	 */
	public void append(String s) {
		Node temp = new Node();
		if (head == null) {
			head = temp;
			tail = temp;
			temp.data = s;
			temp.next = tail;
		} 
		else {
			temp.data = s;
			temp.next = null;
			tail.next = temp;
			tail = temp;
		}
		count++;
	}

	/**
	 * This function removes a word from the Linked List and and subtracts 1
	 * from count every time a word is removed. This function removes the word
	 * at the position that is passed in.
	 * 
	 * @param int pos -- The position in the Linked List that will be removed.
	 *        			 Assuming that position is valid.
	 */
	public void remove(int pos) {
		Node temp = head;
		if (pos >= count || pos < 0) {
			System.out.println("ERROR! No word at this position.");
			System.out.println("Position starts at 0 and must be greater than 0 and less than the total number of words.");
		} 
		else {
			if (pos == 0) {
				head = head.next;
			} 
			else {
				for (int i = 0; i < pos - 1; i++) {
					temp = temp.next;
				}
				temp.next = temp.next.next;
			}
			count--;
		}
	}

	/**
	 * This function gets a word from the Linked List at a specific position and
	 * returns it to the user.
	 * 
	 * @param int pos -- The position in the List that the user wants to get the
	 *        			 word from. Assuming that position is valid.
	 * @return String -- Returns a String that is the word at the users desired
	 *         			 location.
	 */
	public String get(int pos) {
		String get = "";
		Node temp = head;

		if (pos >= count || pos < 0) {
			get = "ERROR! No word at this position. \r\n"
				+ "Position starts at 0 and must be greater than 0 and less than the total number of words.";
		} 
		else {
			if (pos == 0) {
				get = temp.data;
			} 
			else {
				for (int i = 0; i < pos; i++) {
					temp = temp.next;
					get = temp.data;
				}
			}
		}
		return get;
	}

	/**
	 * This function finds a specific place in the Linked List and replaces the
	 * word that is there with a new word of the users choice.
	 * 
	 * @param int pos -- The position in the List where the user wants to
	 *        			 replace a word. Assuming that position is valid.
	 * @param String s -- The word that the user wants the word in the list to be
	 *            		  replaced by.
	 */
	public void put(int pos, String s) {
		Node temp = head;

		if (pos >= count || pos < 0) {
			System.out.println("ERROR! No word at this position.");
			System.out.println("Position starts at 0 and must be greater than 0 and less than the total number of words.");
		} 
		else {
			if (pos == 0) {
				temp.data = s;
			} 
			else {
				for (int i = 0; i < pos; i++) {
					temp = temp.next;
				}
				temp.data = s;
			}
		}
	}

	/**
	 * This function displays the number of words in the Linked List.
	 * 
	 * @return int -- The number of words in the List.
	 */
	public int size() {
		return count;
	}

	/**
	 * This function turns the words in the Linked List into a string of words.
	 * Just like the .toString() function would do for an ArrayList<String>,
	 * this function displays the words in brackets with commas after the word.
	 * 
	 * @return String -- The words in the List put into one string.
	 */
	public String toString() {
		Node temp = head;
		String toString = "";
		for (int i = 0; i < count; i++) {
			if (i < count - 1) {
				toString += (temp.data + ", ");
				temp = temp.next;
			}
			if (i == count - 1) {
				toString += (temp.data);
			}
		}
		toString = "[" + toString + "]";
		return toString;
	}
}
