package assignment08;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import org.junit.Test;

/**
 * This Junit test file contains test for each function in the BinarySearchTree class. these tests
 * test for both functionality and that the correct exceptions are thrown when appropriate.
 * 
 * @author Brandon Mouser and Kale Thompson
 * 
 */
public class BinarySearchTreeTest {
	private BinarySearchTree<Integer> tester;
	
	@Test
	public void testAdd() {
		tester = new BinarySearchTree<Integer>();
		assertEquals(tester.add(20), true);
		assertEquals(tester.add(5), true);
		assertEquals(tester.add(30), true);
		assertEquals(tester.add(0), true);
		assertEquals(tester.add(-9000), true);
		assertEquals(tester.add(9000), true);
		assertEquals(tester.add(20), false);
		tester.clear();
		for(Integer i = 0; i < 10000; i++){
			assertEquals(tester.add(i), true);
		}
		for(Integer i = 0; i < 10000; i++){
			assertEquals(tester.contains(i), true);
		}
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddException(){
		tester = new BinarySearchTree<Integer>();
		tester.add(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddAllException(){
		tester = new BinarySearchTree<Integer>();
		ArrayList<Integer> testNumbers = new ArrayList<Integer>();
		testNumbers.add(1);
		testNumbers.add(3);
		testNumbers.add(null);
		testNumbers.add(4);
		tester.addAll(testNumbers);
	}
	
	@Test(expected = NullPointerException.class)
	public void testContainException(){
		tester = new BinarySearchTree<Integer>();
		tester.contains(null);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testContainsAllException(){
		tester = new BinarySearchTree<Integer>();
		ArrayList<Integer> testNumbers = new ArrayList<Integer>();;
		tester.containsAll(testNumbers);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRemoveException(){
		tester = new BinarySearchTree<Integer>();
		tester.remove(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testRemoveAllException(){
		tester = new BinarySearchTree<Integer>();
		ArrayList<Integer> testNumbers = new ArrayList<Integer>();
		testNumbers.add(1);
		testNumbers.add(3);
		testNumbers.add(2);
		testNumbers.add(4);
		tester.addAll(testNumbers);
		testNumbers.add(null);
		tester.removeAll(testNumbers);
	}
	
	@Test
	public void testFirstAndLast(){
		tester = new BinarySearchTree<Integer>();
		tester.add(8999);
		tester.add(9000);
		assertEquals(tester.first(),(Integer)8999);
		assertEquals(tester.last(), (Integer)9000);
		tester.add(890);
		tester.add(90000);
		assertEquals(tester.first(),(Integer)890);
		assertEquals(tester.last(), (Integer)90000);
		tester.add(5002);
		tester.add(4272);
		tester.add(9783);
		tester.add(4323);
		assertEquals(tester.first(),(Integer)890);
		assertEquals(tester.last(), (Integer)90000);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testFirstException(){
		tester = new BinarySearchTree<Integer>();
		tester.first();
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testLastException(){
		tester = new BinarySearchTree<Integer>();
		tester.last();
	}
	
	@Test
	public void testContains(){
		tester = new BinarySearchTree<Integer>();
		tester.add(35);
		tester.add(100);
		tester.add(1234);
		tester.add(30);
		tester.add(87634);
		assertEquals(tester.contains(35), true);
		assertEquals(tester.contains(100), true);
		assertEquals(tester.contains(1234), true);
		assertEquals(tester.contains(30), true);
		assertEquals(tester.contains(87634), true);
		assertEquals(tester.contains(8), false);
		
	}
	@Test
	public void testRemove(){
		tester = new BinarySearchTree<Integer>();
		tester.add(30);
		tester.add(29);
		tester.add(38);
		tester.add(31);
		tester.add(42);
		tester.add(41);
		tester.add(40);
		tester.add(50);
		assertEquals(tester.size(), 8);
		tester.remove(29);
		tester.remove(50);
		tester.remove(31);
		tester.remove(30);
		tester.remove(38);
		tester.remove(42);
		tester.remove(41);
		tester.remove(40);
		assertEquals(tester.contains(29), false);
		assertEquals(tester.contains(50), false);
		assertEquals(tester.contains(31), false);
		assertEquals(tester.contains(41), false);
		assertEquals(tester.contains(40), false);
		assertEquals(tester.size(), 0);
	}
	
	@Test
	public void testAddAll(){
		tester = new BinarySearchTree<Integer>();
		ArrayList<Integer> testNumbers = new ArrayList<Integer>();
		testNumbers.add(1);
		testNumbers.add(3);
		testNumbers.add(2);
		testNumbers.add(4);
		assertEquals(tester.addAll(testNumbers), true);
		assertEquals(tester.contains(1), true);
		assertEquals(tester.contains(2), true);
		assertEquals(tester.contains(3), true);
		assertEquals(tester.contains(4), true);
		assertEquals(tester.first(), (Integer) 1);
		assertEquals(tester.last(), (Integer) 4);
	}
	
	@Test
	public void testContainsAll(){
		tester = new BinarySearchTree<Integer>();
		ArrayList<Integer> testNumbers = new ArrayList<Integer>();
		testNumbers.add(1);
		testNumbers.add(3);
		testNumbers.add(2);
		testNumbers.add(4);
		tester.addAll(testNumbers);
		assertEquals(tester.containsAll(testNumbers), true);
		testNumbers.add(5);
		assertEquals(tester.containsAll(testNumbers), false);
	}
	
	@Test
	public void testRemoveAll(){
		tester = new BinarySearchTree<Integer>();
		ArrayList<Integer> testNumbers = new ArrayList<Integer>();
		testNumbers.add(1);
		testNumbers.add(3);
		testNumbers.add(2);
		testNumbers.add(4);
		tester.addAll(testNumbers);	
		assertEquals(tester.containsAll(testNumbers), true);
		assertEquals(tester.removeAll(testNumbers), true);
		assertEquals(tester.contains(1), false);
		assertEquals(tester.contains(2), false);
		assertEquals(tester.contains(3), false);
		assertEquals(tester.contains(4), false);
		tester.clear();
		tester.addAll(testNumbers);
		testNumbers.remove(3);
		testNumbers.remove(2);
		assertEquals(tester.containsAll(testNumbers), true);
		assertEquals(tester.removeAll(testNumbers), true);
		assertEquals(tester.contains(1), false);
		assertEquals(tester.contains(3), false);
		assertEquals(tester.contains(2), true);
		assertEquals(tester.contains(4), true);
		
	}
	
	@Test
	public void testDotFile() throws FileNotFoundException{
		// Create a new list with numbers 1-100
		ArrayList<Integer> testDotFile = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++){
			testDotFile.add(i);
		}
		// Shuffle the list so the BinarySearchTree is more balanced.
		Collections.shuffle(testDotFile);
		// Add the list to a new BinarySearchTree
		BinarySearchTree<Integer> dotFile = new BinarySearchTree<Integer>();
		dotFile.addAll(testDotFile);
		// Now test the writeDot function to make sure it makes a dot file
		dotFile.writeDot("DotFile.dot");
		// Make sure it is here!
		File dir = new File("DotFile.dot");
		if(!dir.exists()){
			System.err.println("writeDot failed.");
		}
		// The DotFile.png that was created from this is included in the code I submitted!
	}

}