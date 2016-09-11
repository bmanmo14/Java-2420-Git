package assignment11;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.NoSuchElementException;

/**
 * This is just a basic JUnit test file for the PriorityQueue class.
 * 
 * @author Brandon Mouser and Kale Thompson
 */
public class PriorityQueueTest {

	public PriorityQueue<Integer> test;
	
	/**
	 * This test tests the add function for the Priority Queue class.
	 */
	@Test
	@Before
	public void testAdd() {
		// Make a new Priority Queue called test.
		test = new PriorityQueue<Integer>();
		// Add numbers 0-15 to it in order.
		for(int i = 0; i <= 15; i++){
			test.add(i);
		}
		// The Priority Queue should be already sorted because the numbers were added in order.
		// Test to make sure everything is in the correct place.
		for(int i = 0; i <= 15; i++){
			assertEquals(test.toArray()[i], i);
		}
		// Now when -1 is added, the new number at the first index should be -1.
		test.add(-1);
		assertEquals(test.toArray()[0], -1);
	}
	
	/**
	 * This test tests the findMin() function to make sure the right minimum value is there and 
	 * that the function is returning the correct value.
	 */
	@Test
	public void testFindMin(){
		// Using the same test PriorityQueue, make sure the minimum is correct.
		int min = test.findMin();
		assertEquals(min, -1);
		// Now add new minimum values to make sure the Priority Queue is not only adding them to
		// the correct place, but finding it correctly, too.
		test.add(-10);
		min = test.findMin();
		assertEquals(min, -10);
		// One more time.
		test.add(-100);
		min = test.findMin();
		assertEquals(min, -100);
	}
	
	/**
	 * This tests tests the deleteMin() function to make sure the correct number is deleted
	 * and the correct number took the deleted numbers place.
	 */
	@Test
	public void testDeleteMin(){
		// Using the same PriorityQueue form the first test, delete the min from this Priority Queue.
		int deletedMin = test.deleteMin();
		assertEquals(deletedMin, -1);
		// Now the new minimum should be 0 after -1 is removed. Check.
		int min = test.findMin();
		assertEquals(min, 0);
		// Now remove.
		deletedMin = test.deleteMin();
		assertEquals(deletedMin, 0);
		// Now the min should be 1
		min = test.findMin();
		assertEquals(min, 1);
	}
	
	/**
	 * This test tests the clear() and size() function to make sure the clear erases the PriorityQueue
	 * and the size() function returns the correct size.
	 */
	@Test
	(expected =NoSuchElementException.class)
	public void testClearandSize(){
		// Using the same PriorityQueue, the size should be 17 to start.
		assertEquals(test.size(), 17);
		// Now after we add an item, the size should be 18.
		test.add(90);
		assertEquals(test.size(), 18);
		// Now when I remove two items, the size should be 16.
		test.deleteMin();
		test.deleteMin();
		assertEquals(test.size(), 16);
		// No when i clear, size should be 0.
		test.clear();
		assertEquals(test.size(), 0);
		// Now test.deleteMin() should throw a NoSuchElementException because the PriorityQueue is empty.
		test.deleteMin();
	}

}
