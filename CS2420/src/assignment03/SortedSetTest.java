package assignment03;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Brandon Mouser and Kale Thompson
 * 
 * This test file tests the functions made in the BinarySearchSet.java file. The
 * program first constructs a new BinarySearchSet and adds Integers to the set.
 * The program then tests the add(), addAll(), remove(), removeAll(), size(),
 * contains(), containsAll(), isEmpty(), clear(), first(), and last() functions
 * implemented in the java file. The program then constructs a new
 * BinarySearchSet with the comparator as a parameter and tests the functions
 * with that constructor/comparator.
 * 
 */
public class SortedSetTest {

	private BinarySearchSet<Integer> test;

	/**
	 * This runs before the Test functions to start each function off with a set
	 * filled with 8 random integers.
	 * 
	 */
	@Before
	public void addToArray() {
		test = new BinarySearchSet<Integer>();
		test.add(90);
		test.add(99);
		test.add(-9);
		test.add(0);
		test.add(100);
		test.add(45);
		test.add(123);
		test.add(564);
	}

	/**
	 * This Test tests the add() function. If the add() function fails, a
	 * message will appear in Red.
	 */
	@Test
	public void testAdd() {
		if (test.add(78) == false) {
			System.err.println("add() failed.");
		}
		if (test.add(92) == false) {
			System.err.println("add() failed.");
		}
		if (test.add(107) == false) {
			System.err.println("add() failed.");
		}
		if (test.add(92) == true) {
			System.err.println("add() failed.");
		}

	}

	/**
	 * This Test tests the first() function. If the integer that is supposed to
	 * be first is not first, or if the function just fails, a message will
	 * appear in Red.
	 */
	@Test
	public void testFirst() {
		if (test.first() != -9) {
			System.err.println("first() failed.");
		}
		// Adds a new element that should be read as the first element.
		test.add(-100);
		if (test.first() != -100) {
			System.err.println("first() failed.");
		}
		// Adds a new element that should be read as the first element.
		test.add(-500);
		if (test.first() != -500) {
			System.err.println("first() failed.");
		}
		// Adds a new element that should be read as the first element.
		test.add(-1980);
		if (test.first() != -1980) {
			System.err.println("first() failed.");
		}
	}

	/**
	 * This Test tests the last() function. If the integer that is supposed to
	 * be last is not last, or if the function just fails, a message will appear
	 * in Red.
	 */
	@Test
	public void testLast() {
		if (test.last() != 564) {
			System.err.println("last() failed.");
		}
		// Adds a new element that should be read as the last element.
		test.add(1240);
		if (test.last() != 1240) {
			System.err.println("last() failed.");
		}
		// Adds a new element that should be read as the last element.
		test.add(2750);
		if (test.last() != 2750) {
			System.err.println("last() failed.");
		}
		// Adds a new element that should be read as the last element.
		test.add(567893);
		if (test.last() != 567893) {
			System.err.println("last() failed.");
		}
	}

	/**
	 * This Test tests the contains() function. If the integer that is supposed
	 * to be contained in the set is not, or if a contains is called on an
	 * integer that isn't in the set, a message will appear in Red.
	 */
	@Test
	public void testContains() {
		if (!test.contains(-9)) {
			System.err.println("contains() failed.");
		}
		// Adds a new element that should be contained in the set.
		if (!test.contains(564)) {
			System.err.println("contains() failed.");
		}

		// Adds a new element that should be contained in the set.
		test.add(673);
		if (!test.contains(673)) {
			// System.err.println("contains() failed.");
		}
		// Adds a new element that should be contained in the set.

		if (!test.contains(123)) {
			System.err.println("contains() failed.");
		}

		if (!test.contains(100)) {
			System.err.println("contains() failed.");
		}
	}

	/**
	 * This Test tests the isEmpty() function. If the set is empty when it
	 * shouldn't be, or has items in it when it shouldn't, a message will appear
	 * in Red.
	 */
	@Test
	public void isArrayEmpty() {
		if (test.isEmpty() == true) {
			System.err.println("isEmpty() failed.");
		}
		// Create a new empty set to test the isEmpty function.
		BinarySearchSet<Integer> test2 = new BinarySearchSet<Integer>();
		if (test2.isEmpty() == false) {
			System.err.println("isEmpty() failed.");
		}
		// Now if we add something to this set, it shouldn't be empty anymore.
		test2.add(3456);
		if (test2.isEmpty() == true) {
			System.err.println("isEmpty() failed.");
		}
	}

	/**
	 * This Test tests the clear() and size() functions. If the size is
	 * incorrect, or the clear function fails, a message will appear in Red.
	 */
	@Test
	public void clearAndSize() {
		// Get the size of the array
		if (test.size() != 8) {
			System.err.println("size() failed.");
		}
		// Now clear the array. The size should be 0.
		test.clear();
		if (test.size() != 0) {
			System.err.println("size() failed.");
		}
		// Now add something to the array, the size should be 1.
		test.add(90);
		if (test.size() != 1) {
			System.err.println("size() failed.");
		}
	}

	/**
	 * This Test tests the remove function. If the remove function is incorrect,
	 * or doesn't remove what should be removed, a message will appear in Red.
	 */
	@Test
	public void remove() {
		if (!test.remove(99)) {
			System.err.println("remove() failed.");
		}
		if (!test.remove(-9)) {
			System.err.println("remove() failed.");
		}
		if (!test.remove(123)) {
			System.err.println("remove() failed.");
		}
		if (!test.remove(564)) {
			System.err.println("remove() failed.");
		}
	}

	/**
	 * This Test tests the addAll function. If the addAll function is incorrect,
	 * or doesn't add what should be added, a message will appear in Red.
	 */
	@Test
	public void addAll() {
		// Create a new Set to add items to.
		BinarySearchSet<Integer> test3 = new BinarySearchSet<Integer>();
		// Create a new collection of Integers to add to the set.
		ArrayList<Integer> listSet = new ArrayList<Integer>();
		// Add numbers to this collection.
		listSet.add(675);
		listSet.add(123);
		listSet.add(456);
		listSet.add(789);
		listSet.add(765);
		listSet.add(432);

		if (!(test3.addAll(listSet))) {
			System.err.println("addAll() failed.");
		}
		// Do the same thing to the first array.
		if (!(test.addAll(listSet))) {
			System.err.println("addAll() failed.");
		}
	}

	/**
	 * This Test tests the removeAll function. If the removeAll function is
	 * incorrect, or doesn't remove what should be removed, a message will
	 * appear in Red.
	 */
	@Test
	public void removeAll() {
		// Create a new Set to add items to.
		BinarySearchSet<Integer> test4 = new BinarySearchSet<Integer>();
		// Create a new collection of Integers to add to the set.
		ArrayList<Integer> listSet = new ArrayList<Integer>();
		// Add numbers to this collection.
		listSet.add(675);
		listSet.add(123);
		listSet.add(456);
		listSet.add(789);
		listSet.add(765);
		listSet.add(432);

		// Add the list to the new test set.
		test4.addAll(listSet);

		if (!test4.removeAll(listSet)) {
			System.err.println("removeAll() failed.");
		}
		listSet.clear();

		// Add the contents of the first set to this collection.
		listSet.add(90);
		listSet.add(99);
		listSet.add(-92);
		listSet.add(0);
		listSet.add(100);
		listSet.add(-9);
		listSet.add(123);
		listSet.add(564);

		// Remove these from the first test set.
		if (!test.removeAll(listSet)) {
			System.err.println("removeAll() failed.");
		}

	}

	/**
	 * This Test tests the containsAll function. If the containsAll is
	 * incorrect, a message will appear in Red.
	 */
	@Test
	public void containsAll() {
		// Create a new collection of Integers to compare with our test set.
		ArrayList<Integer> listSet = new ArrayList<Integer>();
		// Add numbers to this collection.
		listSet.add(90);
		listSet.add(99);
		listSet.add(-9);
		listSet.add(0);
		listSet.add(100);
		listSet.add(45);
		listSet.add(123);
		listSet.add(564);

		// Test to see if our test set contains these numbers.
		if (!test.containsAll(listSet)) {
			System.err.println("containsAll() failed.");
		}
		// Clear test to add different numbers and test again.
		test.clear();
		// We can test the containsAll method again here. This time, it should
		// fail because test is empty.
		if (test.containsAll(listSet)) {
			System.err.println("containsAll() failed.");
		}

		test.add(0);
		test.add(3);
		test.add(2);
		test.add(1);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(10);
		test.add(6);
		test.add(8);
		test.add(4);

		// Now do the same thing for our listSet to compare to the test set.
		listSet.clear();

		listSet.add(3);
		listSet.add(2);
		listSet.add(1);
		listSet.add(0);
		listSet.add(6);
		listSet.add(4);
		listSet.add(8);
		listSet.add(9);
		listSet.add(10);
		listSet.add(7);
		listSet.add(5);

		// Now compare it to the test set. The test set should contain
		// everything in this listSet.
		if (!test.containsAll(listSet)) {
			System.err.println("containsAll() failed.");
		}
	}

	/**
	 * This Test tests the toArray function. If the toArray is incorrect, a
	 * message will appear in Red.
	 */
	@Test
	public void toArray() {
		Object[] testArray = test.toArray();

		if (testArray[0] != test.first()) {
			System.err.println("toArray() failed.");
		}
		if (testArray[testArray.length - 1] != test.last()) {
			System.err.println("toArray() failed.");
		}
		// Create a String comparison of the testArray.
		String testSame = "";
		for (int i = 0; i <= testArray.length - 1; i++) {
			if (i < testArray.length - 1) {
				testSame += (testArray[i] + ", ");
			}
			if (i == testArray.length - 1) {
				testSame += (testArray[i]);
			}
		}
		testSame = "[" + testSame + "]";

		// Now we can compare this string to the test.toString method to see if
		// they are equal.
		if (!test.toString().equals(testSame)) {
			System.err.println("toArray() failed.");
		}
		// If this doesn't fail, we know that the testArray is equal to our
		// original test set.
	}

	/**
	 * This Test tests the binarySearch function. If the binarySearch is
	 * incorrect, a message will appear in Red.
	 */
	@Test
	public void binarySearchTest() {
		// Clear the test array to put in new numbers 0-10.
		test.clear();
		test.add(0);
		test.add(3);
		test.add(2);
		test.add(1);
		test.add(5);
		test.add(7);
		test.add(9);
		test.add(10);
		test.add(6);
		test.add(8);
		test.add(4);

		// Print the set. It is sorted because of the BinarySearch method.
		System.out.println("This array shows the binarySearch in action");
		System.out.println(test.toString());

		// These tests search for the number in the set using the BinarySearch.
		if (test.binarySearch(0) != 0) {
			System.err.println("binarySearchTest() failed.");
		}
		if (test.binarySearch(5) != 5) {
			System.err.println("binarySearchTest() failed.");
		}
		if (test.binarySearch(9) != 9) {
			System.err.println("binarySearchTest() failed.");
		}
		if (test.binarySearch(10) != 10) {
			System.err.println("binarySearchTest() failed.");
		}
		if (test.binarySearch(3) != 3) {
			System.err.println("binarySearchTest() failed.");
		}
	}
}
