package assignment06;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

/**
 * A test class for the DoublyLinkedList class
 * 
 * @author David Neil Ord & Brandon Mouser
 *
 */
public class DoublyLinkedListTest {

	DoublyLinkedList<Integer> testList = new DoublyLinkedList<Integer>();
	DoublyLinkedList<Integer> test = new DoublyLinkedList<Integer>();
	DoublyLinkedList<Integer> newTest = new DoublyLinkedList<Integer>();
	final int SIZE = 100;
	
	@Test
	public void addFirstMethodAddsToListAndIncrementsCount() {
		testList.addFirst(5);
		testList.addFirst(10);
		System.out.println(testList);
		assertEquals(2, testList.size());
	}

	@Test
	public void addMethodFromHeadAddsToCorrectPlace() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		assertEquals(10, testList.size());
		
		testList.add(4, 200);
		assertEquals(11, testList.size());
		System.out.println(testList);
	}
	
	@Test
	public void addMethodFromTailAddsToCorrectPlace() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		assertEquals(10, testList.size());
		
		testList.add(8, 300);
		assertEquals(11, testList.size());
		System.out.println(testList);
	}
	
	@Test
	public void addLastMethodAddsToTailAndIncrementsCount() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		testList.addLast(333);
		System.out.println(testList);
		assertTrue(testList.getLast() == 333);
		assertEquals(11, testList.size());
		assertTrue(testList.get(10) == 333);
		assertTrue(testList.indexOf(333) == 10);
	}
	
	@Test 
	public void addMethodThrowsIndexOutOfBoundsExceptionIfIndexIsGreaterThanCount() {
		try {
			testList.add(4, 42);
			fail();
		}
		catch(IndexOutOfBoundsException e){}
	}
	
	@Test
	public void toArrayMethodReturnsCorrectObjectArray() {
		Object[] referenceList = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		assertArrayEquals(referenceList, testList.toArray());
	}
	
	@Test
	public void getMethodReturnsTheCorrectValue() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		System.out.println(testList);
		System.out.println("Index Four: " + testList.get(4));
		System.out.println("First: " + testList.getFirst());
		System.out.println("Last: " + testList.getLast());
		
		// Try/Catch exceptions.
		DoublyLinkedList<Integer> emptyList = new DoublyLinkedList<Integer>();
		try {
			testList.get(23);
			emptyList.getFirst();
			emptyList.getLast();
			fail();
		}
		catch (IndexOutOfBoundsException e) {} 
		catch (NoSuchElementException e) {}
	}
	
	@Test
	public void indexOfMethodReturnsCorrectValue() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		assertEquals(3, testList.indexOf(6));
	}
	
	@Test
	public void lastIndexOfMethodReturnsCorrectValue() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		assertEquals(8, testList.lastIndexOf(1));
	}
	
	@Test
	public void indexOfAndLastIndexOfMethodsReturnCorrectValuesForRepeatingValues() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		testList.addFirst(0);
		assertEquals(10, testList.lastIndexOf(0));
		assertEquals(0, testList.indexOf(0));
	}
	
	@Test
	public void clearMethodCreatesAnEmptyList() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		testList.clear();
		assertEquals(0, testList.size());
		System.out.println("After clear: " + testList);
	}
	
	@Test
	public void isEmptyMethodReturnsTrueForEmptyListAndFalseOtherwise() {
		DoublyLinkedList<Integer> emptyList = new DoublyLinkedList<Integer>();
		for (int i = 0; i < 3; i++) {
			testList.addFirst(i);
		}
		
		assertTrue(emptyList.isEmpty());
		assertFalse(testList.isEmpty());
	}
	
	@Test
	public void removeMethodReturnsCorrectValueAndDecrementsCount() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		
		assertTrue(testList.remove(1) == 8);
		assertEquals(9, testList.size());
	}
	
	@Test
	public void removeFirstMethodReturnsFirstValueAndDecrementsCount() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		assertTrue(testList.removeFirst() == 9);
		assertEquals(9, testList.size());
		System.out.println("Remove: " + testList);
		
		DoublyLinkedList<Integer> emptyList = new DoublyLinkedList<Integer>();
		try {
			emptyList.removeFirst();
			fail();
		}
		catch(NoSuchElementException e) {}
	}
	
	@Test
	public void removeLastMethodReturnsLastValueAndDecrementsCount() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		assertTrue(testList.removeLast() == 0);
		assertEquals(9, testList.size());
		System.out.println("RemoveLast: " + testList);
		
		DoublyLinkedList<Integer> emptyList = new DoublyLinkedList<Integer>();
		try {
			emptyList.removeLast();
			fail();
		}
		catch(NoSuchElementException e) {}
	}
	
	@Test
	public void iteratorMethodsFunctionAsExpected() {
		for (int i = 0; i < 10; i++) {
			testList.addFirst(i);
		}
		Iterator<Integer> testIt = testList.iterator();
		
		assertTrue(testIt.hasNext());
		assertTrue(testIt.next() == 9);
		
		assertTrue(testIt.hasNext());
		assertTrue(testIt.next() == 8);
		
		// Remove the value 8, then test the exception.
		
		testIt.remove();
		System.out.println("Iterator:" + testList);
		
		try {
			testIt.remove();
			fail();
		}
		catch(IllegalStateException e) {}
		
		DoublyLinkedList<Integer> emptyList = new DoublyLinkedList<Integer>();
		
		Iterator<Integer> testTwo = emptyList.iterator();
		
		assertFalse(testTwo.hasNext());
		try {
			testTwo.next();
			fail();
		}
		catch(NoSuchElementException e) {}
	}

	/**
	 * This just creates a new Linked List to be used with the Test functions.
	 */
	@Before
	public void createNewLinkedList(){
		for(int i = 1; i<= SIZE; i++){
			test.add(i-1,i);
		}
	}
	
	/**
	 * This test tests the addFirst function.
	 */
	@Test
	public void testAddFirst() {
		// Test the addFirst function to see if items are placed in the first part of the Array.
		newTest.addFirst(5);
		// If the element at the beginning of the Linked List doesn't equal the First element that was passed in, the function failed.
		if(newTest.get(0) != 5){
			System.err.println("addFirst() failed.");
		}
		// Keep testing different scenarios
		test.addFirst(200);
		if(test.get(0) != 200){
			System.err.println("addFirst() failed.");
		}
		newTest.addFirst(4);
		newTest.addFirst(3);
		newTest.addFirst(2);
		newTest.addFirst(1);
		if(newTest.get(0) != 1){
			System.err.println("addFirst() failed.");
		}
		// All of the items in the newTest Linked List should be in the Linked List in order from 1-5.
		for(int i =1; i<=5; i++){
			if(newTest.get(i-1) != i){
				System.err.println("addFirst() failed.");
			}
		}
		
	}
	
	/**
	 * This test tests the addLast function.
	 */
	@Test
	public void testAddLast() {
		// Add Items to an empty Linked List
		newTest.addLast(100);
		// Make sure the ONLY item in the Linked List at 0 is 100
		if(newTest.get(0) != 100){
			System.err.println("addLast() failed.");
		}
		newTest.addLast(200);
		newTest.addLast(300);
		newTest.addLast(400);
		// The Last element should be the very last addLast that we called.
		if(newTest.get(newTest.size()-1) != 400){
			System.err.println("addLast() failed.");
		}
		// Make sure that all of the numbers were added to the Linked List successfully.
		for(int i = 1; i <=4; i++){
			if(newTest.get(i-1) != i*100){
				System.err.println("addLast() failed.");
			}
		}
		// Test different scenarios
		test.addLast(200);
		test.addLast(300);
		// Both items were added to the last spot, but only 300 should be in the last position.
		if(test.get(test.size()-1) != 300){
			System.err.println("addLast() failed.");
		}
		// 200 should be at the second last position
		if(test.get(test.size()-2) != 200){
			System.err.println("addLast() failed.");
		}
	}
	
	/**
	 * This test tests the get function.
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void testGetElement(){
		// Our test Linked List should have all the numbers 1-100 in it
		for(int i = 1; i<= SIZE; i++){
			if(test.get(i-1) != i){
				System.err.println("get() failed.");
			}
		}
		// Test an empty Linked List. If the user tries to 'get' an index that doesn't exist,
		// An IndexOutOFBoundsException will be thrown.
		newTest.get(0);
	}
	
	/**
	 * This test tests the regular add function.
	 */
	@Test
	public void testAddFunction() {
		// First we add numbers to the specific position.
		newTest.add(0, 100);
		newTest.add(1, 200);
		newTest.add(2, 300);
		newTest.add(3, 400);
		newTest.add(4, 500);
		// Now if the number at the position isn't what it should be, the function failed.
		if(newTest.get(0) != 100){
			System.err.println("add() failed.");
		}
		if(newTest.get(1) != 200){
			System.err.println("add() failed.");
		}
		if(newTest.get(2) != 300){
			System.err.println("add() failed.");
		}
		// Now let's mix it up and see if the function still works.
		newTest.add(2, 700);
		newTest.add(4, 800);
		// If the numbers at those positions isn't what it should be, the function failed.
		if(newTest.get(0) != 100){
			System.err.println("add()! failed.");
		}
		if(newTest.get(1) != 200){
			System.err.println(newTest.get(4));
		}
		if(newTest.get(2) != 700){
			System.err.println("add() failed.");
		}
		if(newTest.get(3) != 300){
			System.err.println("add() failed.");
		}
		if(newTest.get(4) != 800){
			System.err.println("add() failed.");
		}
		if(newTest.get(5) != 400){
			System.err.println("add() failed.");
		}
		if(newTest.get(6) != 500){
			System.err.println("add() failed.");
		}

	}
	
	/**
	 * This test tests the getFirst function.
	 */
	@Test
	public void testGetFirst(){
		// The test Linked List should have the numbers 1-100 in it.
		if(test.getFirst() != 1){
			System.err.println("getFirst() failed.");
		}
		// Place items in the newTest Linked List and test the getFirst function
		newTest.addFirst(100);
		if(newTest.getFirst() != 100){
			System.err.println("getFirst() failed.");
		}
		newTest.addFirst(200);
		newTest.addFirst(300);
		newTest.addFirst(400);
		// The FIRST item should be the very last addFirst that we called, the other numbers should be after that.
		if(newTest.getFirst() != 400){
			System.err.println("getFirst() failed.");
		}
	}
	/**
	 * This test tests the getLast function.
	 */
	@Test
	public void testGetLast(){
		// The test Linked List should have the numbers 1-100 in it.
		if(test.getLast() != 100){
			System.err.println("getLast() failed.");
		}
		// If the Linked List is empty, getLast will throw a NoSuchElementException
		
		// Add an item to the end of the test Linked List, make sure getLast finds it.
		test.addLast(0);
		if(test.getLast() != 0){
			System.err.println("getLast() failed.");
		}
		
		// Now, add an item to the FIRST spot in an empty Linked List, make sure getLast still finds the number.
		newTest.addFirst(100);
		if(newTest.getLast() != 100){
			System.err.println("getLast() failed.");
		}
		newTest.addLast(200);
		if(newTest.getLast() != 200){
			System.err.println("getLast() failed.");
		}
	}
	
	/**
	 * This test tests the removeFirst function.
	 */
	@Test
	public void testRemoveFirst(){
		// The test Linked List should have numbers 1-100 in it.
		// Make sure the first element IS 1.
		if(test.get(0) != 1){
			System.err.println("get() failed.");
		}
		// Now we remove it
		if(test.removeFirst() != 1){
			System.err.println("removeFirst() failed.");
		}
		// Make sure the first element is no longer 1.
		if(test.get(0) == 1){
			System.err.println("removeFirst() failed.");
		}
		// The first element in the test Linked List should be 2 now.
		if(test.get(0) != 2){
			System.err.println("removeFirst(). failed.");
		}
		
	}
	
	/**
	 * This test tests the removeLast function.
	 */
	@Test
	public void testRemoveLast(){
		// Use the test Linked List and remove the last element in it. The last element should be 100.
		if(test.removeLast() != 100){
			System.err.println("removeLast failed");
		}
		if(test.getLast() != 99){
			System.err.println("removeLast failed");
		}
		// Test again
		if(test.removeLast() != 99){
			System.err.println("removeLast failed");
		}
		if(test.getLast() != 98){
			System.err.println("removeLast failed");
		}
		// Test a new Linked List
		newTest.addFirst(1);
		newTest.addFirst(0);
		if(newTest.removeLast() != 1){
			System.err.println("removeLast failed");
		}
		if(newTest.size() != 1){
			System.err.println("removeLast failed");
		}
		if(newTest.getFirst() != 0){
			System.err.println("removeLast failed");
		}
	}
	
	/**
	 * This test tests the remove function.
	 */
	@Test
	public void testRemoveFunction(){
		// test remove on the test Linked List
		int count = 0;
		// removes the first 10 numbers in the test Linked List. 
		while(count < 10){
			if(test.remove(0) != count+1){
				System.err.println("remove failed");
			}
			count++;
		}
		if(test.getFirst()!= 11){
			System.err.println("remove failed");
		}
		// Now lets remove a random number from the Linked List
		if(test.remove(60) != 71){
			System.err.println("...remove failed");
		}
		
		if(test.get(60) == 71){
			System.err.println("remove failed");
		}
	}
	
	/**
	 * This test tests the indexOf function.
	 */
	@Test
	public void testIndexOf(){
		// Use the test Linked List to get the index of specific numbers.
		for(int i = 1; i<=SIZE; i++){
			if(test.indexOf(i) != i-1){
				System.err.println("indexOf failed");
			}
		}
		// 101 is not in our Linked List, so the function should return -1.
		if(test.indexOf(101) != -1){
			System.err.println("indexOf failed");
		}
		// Now test a new Linked List
		newTest.addFirst(1);
		newTest.addFirst(2);
		newTest.addFirst(3);
		newTest.addFirst(4);
		newTest.addFirst(4);
		// When searching for the number 4, the function should return 0 because that is the first place with 4.
		if(newTest.indexOf(4) != 0){
			System.err.println("indexOf failed");
		}
		newTest.addLast(8);
		newTest.addLast(8);
		// When searching for the number 8, the function should return 5 because that is the first place with the number 8.
		if(newTest.indexOf(8) != 5){
			System.err.println("indexOf failed");
		}
		
	}
	
	/**
	 * This test tests the lastIndexOf function.
	 */
	@Test
	public void testLastIndexOf(){
		// Use the test Linked List to get the index of specific numbers.
			for(int i = 1; i<=SIZE; i++){
					if(test.lastIndexOf(i) != i-1){
						System.err.println("lastIndexOf failed");
					}
				}
				// 101 is not in our Linked List, so the function should return -1.
				if(test.lastIndexOf(101) != -1){
					System.err.println("lastIndexOf failed");
				}
				// Now test a new Linked List
				newTest.addFirst(1);
				newTest.addFirst(2);
				newTest.addFirst(3);
				newTest.addFirst(4);
				newTest.addFirst(4);
				// When searching for the number 4, the function should return 1 because that is the last place with 4.
				if(newTest.lastIndexOf(4) != 1){
					System.err.println("lastIndexOf failed");
				}
				newTest.addLast(8);
				newTest.addLast(8);
				// When searching for the number 8, the function should return 6 because that is the last place with the number 8.
				if(newTest.lastIndexOf(8) != 6){
					System.err.println("lastIndexOf failed");
				}
	}
	
	/**
	 * This test tests the isEmpty function.
	 */
	@Test
	public void testIsEmpty(){
		// Use the test Linked List to test isEmpty.
		if(test.isEmpty() == true){
			System.out.println("isEmpty failed");
		}
		// Now try it on a new Linked List
		if(newTest.isEmpty() != true){
			System.out.println("isEmpty failed");
		}
		newTest.addFirst(1);
		// Test again for good measures.
		if(newTest.isEmpty() == true){
			System.out.println("isEmpty failed");
		}
	}
	
	/**
	 * This test tests the clear function.
	 */
	@Test
	public void testClearAndSize(){
		// Use the test Linked List to test the clear function
		if(test.size() != SIZE){
			System.err.println("size failed");
		}
		// Now clear the Linked List
		test.clear();
		if(test.size() != 0 || test.isEmpty() != true){
			System.err.println("clear failed");
		}
		
	}
	
	/**
	 * This test tests the toArray function.
	 */
	@Test
	public void testToArray(){
		// Use the test Linked List to turn it into an array.
		Object[] toArray = new Object[100];
		toArray = test.toArray();
		// Now we compare the Linked List to the Array to make sure they are identical.
		for(int i = 0; i<SIZE; i++){
			if(toArray[i] != test.get(i)){
				System.err.println("toArray failed");
			}
		}
	}
	
	/**
	 * This test tests the toString function.
	 */
	@Test
	public void testToString(){
		// Use the test Linked List to test the toString function
		System.out.println(test.toString());
		// Make sure it really does work
		for(int i = 1; i <= 10; i++){
			newTest.add(i-1, i);
		}
		// Display the toString
		System.out.println(newTest.toString());
	}
}
