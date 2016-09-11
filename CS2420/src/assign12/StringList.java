/**
 * StringList.java
 * 
 * This interface lists the common methods that are used for
 * StringLinkedList.java and StringArrayList.java so that 
 * variables can be declared using this interface, making it easy
 * to switch between a StringLinkedList and StringArrayList.
 * 
 * @author Brandon Mouser, mouser
 * Last Edited: December 1, 2015
 * 
 */

package assign12;

public interface StringList {
	void append(String s);
	String get(int pos);
	void remove(int pos);
	void put(int pos, String s);
	int size();
	String toString();
}
