package assignment08;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This JUnit test file tests the functions made in the SpellChecker class. The functions made in
 * the SpellChecker class use the BinarySearchTree to hold the words in a dictionary and to hold
 * the words in a text file that we are testing to see if everything is spelled correctly.
 * 
 * @author Brandon Mouser and Kale Thompson
 *
 */
public class SpellCheckerTester {
	
	private SpellChecker testSpell;

	/**
	 * Runs before the tests to add words to the dictionary.
	 * Also tests to make sure the file is read and the words are added to the SpellChecker.
	 */
	@Before
	@Test
	public void addToSpellChecker(){
		// Create a new file to add to the SpellChecker.
		File doc = new File("dictionary.txt");
		// Add the file/words to the SpellChecker.
		testSpell = new SpellChecker(doc);
		// Make sure everything is added correctly and file was read correctly in the next function.
		
	}
	/**
	 * This test tests the addToDictionary function to make sure that everything is added correctly
	 * and the BinarySearchTree is adding elements to the tree correctly.
	 */
	@Test
	public void testSpellChecker() {
		// Test the SpellChecker made in the previous function.
		// To do so, use the SpellCheck function to spellCheck the dictionary file that was added to the SpellChecker.
		// If this fails, reading the file and adding the words into the SpellCHecker failed.
		File doc = new File("dictionary.txt");
		List<String> testSpellChecker = testSpell.spellCheck(doc);
		// This List should be empty because the words being checked are the same words that were added.
		if(!testSpellChecker.isEmpty()){
			System.err.println("SpellChecker failed.");
		}
		// Now using the good_luck file that was given to us, test the SpellChecker.
		List<String> testGoodLuckFile = testSpell.spellCheck(new File("good_luck.txt"));
		// The only word that is not in the dictionary that is in this file is BST. If the List does not contain BST,
		// Or BST is not the only thing in the List, SpellChecker failed.
		if(testGoodLuckFile.size() != 1){
			System.err.println("SpellChecker failed.");
		}
		// The only thing in this List should be BST, (lowercase though because everything is read in as lowercase).
		assertEquals(testGoodLuckFile.get(0), "bst");
		// Now using the hello_world text file that was given to us, everything should pass, the list should be empty.
		List<String> testHelloWorldFile = testSpell.spellCheck(new File("hello_world.txt"));
		// Everything should be spelled correctly, so the list should be empty.
		assertEquals(testHelloWorldFile.size(), 0);
	}
	/**
	 * Using the dictionary that is set up before this test, we will add and remove words from the 
	 * dictionary and make sure that the SpellChecker still works how it should. If not, SpellChecker failed.
	 */
	@Test
	public void testAddAndRemove(){
		// Using the good_luck file, the only word that is spelled incorrectly is BST. 
		// However, if we add that to the dictionary, everything should be spelled correctly.
		testSpell.addToDictionary("bst");
		// Now test the new dictionary with the file, there should be no misspelled words.
		List<String> testGoodLuckFile = testSpell.spellCheck(new File("good_luck.txt"));
		// If the size of this List is not zero, addToDictionary failed.
		assertEquals(testGoodLuckFile.size(), 0);
		// Now we can remove words from the dictionary and test the file again. More things should fail now.
		testSpell.removeFromDictionary("nice");
		testSpell.removeFromDictionary("meet");
		testSpell.removeFromDictionary("you");
		// Removing these words should make the hello_world file fail with three misspelled words. 'Nice', 'meet', and 'you'.
		List<String> testHelloWorldFile = testSpell.spellCheck(new File("hello_world.txt"));
		// The size of this list should be three because there were three misspelled words.
		assertEquals(testHelloWorldFile.size(), 3);
		// The three misspelled words should be 'nice','meet', and 'you'. (In the order they appear in the file).
		assertEquals(testHelloWorldFile.get(0), "nice");
		assertEquals(testHelloWorldFile.get(1), "meet");
		assertEquals(testHelloWorldFile.get(2), "you");
		// Now if we add these words back to the dictionary, the file should pass again.
		testSpell.addToDictionary("nice");
		testSpell.addToDictionary("meet");
		testSpell.addToDictionary("you");
		// Test it
		List<String> testNewHelloWorldFile = testSpell.spellCheck(new File("hello_world.txt"));
		// The size should be zero, as there should be no misspelled words.
		assertEquals(testNewHelloWorldFile.size(), 0);
	}
}
