package assignment10;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * This is just a basic JUnit test file for the QuadProbeHashTable.
 * 
 * @author Brandon Mouser and Kale Thomson
 *
 */
public class QuadProbeHashTableTester {

	@Test
	public void testQuadProbeHashTable() {
		QuadProbeHashTable testTable = new QuadProbeHashTable(7, new BadHashFunctor());
		assertEquals(testTable.capacity, 7);
		assertEquals(testTable.add("One"), true);
		assertEquals(testTable.add("One"), false);
		assertEquals(testTable.add("Two"), true);
		assertEquals(testTable.add("Three"), true);
		assertEquals(testTable.add("Four"), true);
		assertEquals(testTable.add("Five"), true);
		assertEquals(testTable.add("Six"), true);
		// Doubles the array, then searches for the next prime number, should be 17.
		assertEquals(testTable.capacity, 17);
		ArrayList<String> testList = new ArrayList<String>();
		testList.add("Seven");
		testList.add("Eight");
		testList.add("Nine");
		assertEquals(testTable.addAll(testList), true);
		assertEquals(testTable.addAll(testList), false);
		assertEquals(testTable.contains("One"), true);
		assertEquals(testTable.contains("Ten"), false);
		assertEquals(testTable.containsAll(testList), true);
		testList.add("Ten");
		assertEquals(testTable.containsAll(testList), false);
	}

}
