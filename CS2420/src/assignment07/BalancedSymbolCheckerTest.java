package assignment07;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * This class tests the functions created in the BalancedSymbolChecker class.
 * To use these tests, include the test Class files from the Assignment 07 page in your folder 
 * so this program can access them. Also include the custom Class files included with this source code.
 * This program tests the functions using those test Classes. The output should be the same as what is 
 * stated on the Assignment 07 page online for test Class 1-14, for our custom test classes, the output
 * should be what is written in the function below.
 * If any of the functions are to fail, an error message will appear.
 * 
 * @author Brandon Mouser and David Ord
 */
public class BalancedSymbolCheckerTest {
	private BalancedSymbolChecker test1 = new BalancedSymbolChecker();
	/**
	 * This test tests files that have Unmatched Symbols in them.
	 * The tests should match the output of Class1, Class2, Class5, Class7, Class8, Class9, and Class10
	 * that are provided on the Assignment 07 page.
	 * 
	 * @throws FileNotFoundException -- If the file cannot be found, an Exception is thrown.
	 */
	@Test (expected = FileNotFoundException.class)
	public void testUnmatchedSymbol() throws FileNotFoundException {
		// First check Class1, the error message that appears should match what is on the Assignment 07 page, if not, BalancedSymbolChecker failed.
		assertEquals(test1.checkFile("Class1.java"), "ERROR: Unmatched symbol at line 6 and column 1. Expected ), but read } instead.");
		// Test all of the Classes that have Unmatched Symbols. The output for all of these should match what is on the Assignment 07 page.
		assertEquals(test1.checkFile("Class2.java"), "ERROR: Unmatched symbol at line 7 and column 1. Expected  , but read } instead.");
		assertEquals(test1.checkFile("Class5.java"), "ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.");
		assertEquals(test1.checkFile("Class7.java"), "ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.");
		assertEquals(test1.checkFile("Class8.java"), "ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.");
		assertEquals(test1.checkFile("Class9.java"), "ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.");
		assertEquals(test1.checkFile("Class10.java"), "ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.");
		// Now test a file that does not exist. A FileNotFoundException should be thrown.
		test1.checkFile("Doesn'tExist.java");
	}
	
	/**
	 * This test function tests all of the classes given on the Assignment 07 page that should pass
	 * every test. All symbols should match when running these tests. This function will be testing 
	 * Class3, Class6, Class12, Class13, and Class14 as all of these Classes should pass without
	 * having any Unmatched Symbols or Open Comments.
	 * @throws FileNotFoundException -- If the file cannot be found, an Exception is thrown.
	 */
	@Test
	public void testAllSymbolsMatch() throws FileNotFoundException{
		// Test each Class, if the output is not exactly what should be printed, as stated by the Assignment 07 page, BalancedSymbolChecker failed.
		assertEquals(test1.checkFile("Class3.java"), "No errors found. All symbols match.");
		assertEquals(test1.checkFile("Class6.java"), "No errors found. All symbols match.");
		assertEquals(test1.checkFile("Class12.java"), "No errors found. All symbols match.");
		assertEquals(test1.checkFile("Class13.java"), "No errors found. All symbols match.");
		assertEquals(test1.checkFile("Class14.java"), "No errors found. All symbols match.");
	}
	
	/**
	 * This test function tests all of the classes given on the Assignment 07 page that have unfinished comments. 
	 * All of the Classes in this test should fail because of an unfinished comment. This function will be testing 
	 * Class4 as well as a few custom classes, Class17 and Class18, meant to fail with unfinished comments when ran.
	 * 
	 * @throws FileNotFoundException -- If the file cannot be found or doesn't exist, an Exception is thrown.
	 */
	@Test
	public void testUnfinishedComment() throws FileNotFoundException{
		// Test each Class, if the output is not exactly what should be printed, as stated by the Assignment 07 page, BalancedSymbolChecker failed.
		assertEquals(test1.checkFile("Class4.java"), "ERROR: File ended before closing comment.");
		assertEquals(test1.checkFile("Class17.java"), "ERROR: File ended before closing comment.");
		assertEquals(test1.checkFile("Class18.java"), "ERROR: File ended before closing comment.");
	}
	
	/**
	 * This function tests classes that have unmatched symbols at the end of the file. In addition to the
	 * Class11 that was given on the Assignment 07 page, this function tests two other files, Class15 and Class 16, 
	 * that should all fail with unmatched symbols at the end of the file. 
	 * @throws FileNotFoundException -- If the file cannot be found or doesn't exist, an Exception is thrown.
	 */
	@Test
	public void testUnmatchedSymbolAtEOF() throws FileNotFoundException{
		// Test each Class, if the output is not exactly what should be printed, BalancedSymbolChecker failed.
		assertEquals(test1.checkFile("Class11.java"), "ERROR: Unmatched symbol at the end of file. Expected }.");
		assertEquals(test1.checkFile("Class15.java"), "ERROR: Unmatched symbol at the end of file. Expected }.");
		assertEquals(test1.checkFile("Class16.java"), "ERROR: Unmatched symbol at the end of file. Expected }.");
	}
}
