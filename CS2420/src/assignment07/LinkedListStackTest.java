package assignment07;

import org.junit.Test;

/**
 * This JUnit test file tests the functions made in the LinkedListStack class.
 * A new LinkedListStack<Integer> is made and tested to make sure it behaves like it should.
 * If any of the functions should fail, an error message will be printed in red.
 * 
 * @author Brandon Mouser & David Ord
 */
		
public class LinkedListStackTest {

	private LinkedListStack<Integer> testStack = new LinkedListStack<Integer>();
	private LinkedListStack<Integer> emptyStack = new LinkedListStack<Integer>();
	
	/**
	 * This test tests the push() and peek() functions as they go hand in hand.
	 * If peek() is called on an empty Stack, a NoSuchElementException should be thrown.
	 */
	@Test (expected = java.util.NoSuchElementException.class)
	public void testPushAndPeek() {
		// Call the push function on testStack.
		testStack.push(10);
		// Make sure the stack isn't empty.
		if(testStack.size() != 1){
			System.err.println("push() failed.");
		}
		// Now when peek is called, it should return 10, the first and only thing in the Stack.
		if(testStack.peek() != 10){
			System.err.println("peek() failed.");
		}
		// Keep testing both functions.
		testStack.push(20);
		if(testStack.size() != 2){
			System.err.println("push() failed.");
		}
		
		if(testStack.peek() != 20){
			System.err.println("peek() failed.");
		}
		// Add multiple things to the Stack. Test to make sure everything is added.
		for(int i = 1; i <=10; i++){
			testStack.push(i);
			if(testStack.peek() != i){
				System.err.println("push() failed.");
			}
		}
		// Now test the empty stack to make sure the NoSuchElementException is thrown when peek is called on an empty Stack.
		emptyStack.peek();
	}
	/**
	 * This test tests the pop() function.
	 * At the end, if pop is called on an empty Stack, it should throw NoSuchElementException.
	 */
	@Test (expected = java.util.NoSuchElementException.class)
	public void testPop(){
		// Add some things to the testStack.
		testStack.push(10);
		testStack.push(20);
		testStack.push(30);
		// When pop is called, it should remove and return the first item in the Stack.
		if(testStack.pop() != 30){
			System.err.println("pop() failed.");
		}
		// Now when peek is called, it should return 20 because 30 should have been removed.
		if(testStack.peek() != 20){
			System.err.println("pop() failed.");
		}
		// The size should be 2.
		if(testStack.size() != 2){
			System.err.println("pop() failed.");
		}
		// Keep testing!
		for(int i = 1; i <= 20; i++){
			testStack.push(i);
			if(testStack.pop() != i){
				System.err.println("pop() failed.");
			}
		}
		// Now test the emptyStack. It should throw NoSuchElementException if pop is called on an empty Stack.
		emptyStack.pop();
	}
	
	/**
	 * This test tests the clear(), size(), and isEmpty() functions as they go hand in hand.
	 * If any of these functions fail, an error message will appear.
	 */
	@Test 
	public void testClearIsEmpty(){
		// See if the emptyStack is empty. It should be.
		if(!emptyStack.isEmpty()){
			System.err.println("isEmpty() failed.");
		}
		// Add some stuff to the testStack, it shouldn't be empty now.
		for(int i = 1; i <= 30; i++){
			testStack.push(i);
		}
		if(testStack.isEmpty()){
			System.err.println("isEmpty() failed.");
		}
		// Test the size() function while we are here.
		if(testStack.size() != 30){
			System.err.println("size() failed.");
		}
		// Now we can test the clear function. After which the Stack should be empty and size be 0.
		testStack.clear();
		if(!testStack.isEmpty()){
			System.err.println("clear() failed.");
		}
		if(testStack.size() != 0){
			System.err.println("clear() failed.");
		}
	}

}
