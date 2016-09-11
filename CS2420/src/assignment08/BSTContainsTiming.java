package assignment08;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/** 
 * This is a timing file for the contains method in BinarySearchTree. This method tests for two different conditions with contains. 
 * The first is that if all items were added to the BinarySearchTree in sorted order, how long does it take to find an item within the list? The next 
 * test case if all items were added to the BinarySearchTree in random order, how long does it take to find an item within the list? The only difference 
 * between these two test cases is whether or not the collections.shuffle line is commented out. The timing file will average out the times and print the 
 * results in NanoSeconds.
 * 
 * @author Brandon Mouser & Kale Thompson
 *
 */
public class BSTContainsTiming {
	
	public static void main(String[] args) {
		// Starts at 900 because before the test is ran it will be incremented to 1000.
		int sizeSet = 900;
		try (FileWriter fileOut = new FileWriter("ContainsUnsorted.txt")) {
			// Runs a for loop to increment 900 to 10000.
			for (int exp = 0; exp <= 90; exp++) {
				//Increments the Number of items within the Tree by 100 each time the test is run.
				sizeSet+= 100;
				long totalTime = 0;
				// Creates a new Tree
				BinarySearchTree<Integer> tempTree = new BinarySearchTree<Integer>();
				// Creates a new ArrayList
				ArrayList<Integer> tempArray = new ArrayList<Integer>();
				// Adds the items to the ArrayList in sorted order.
				for(int i = 1; i <= sizeSet; i++){
					tempArray.add(i);
				}
				// Shuffles the ArrayList before items are added to the tree, if you want to test for sorted simply comment this line out.
				Collections.shuffle(tempArray);
				// Adds all items to the tree.
				tempTree.addAll(tempArray);
				//Increment through the tree based on how many items were added. Starts the clock, calls contains for one item within the Tree and records the time.
				for(int i = 1; i<= sizeSet; i++){
					long startRun = System.nanoTime();
					tempTree.contains(i);
					long stopRun = System.nanoTime();
					// Adds up the total time it took to find all items within the Tree
					totalTime += stopRun - startRun;
				}
				// Clears the tree so the next test is completely separate from this one.
				tempTree.clear();
				// Takes the total time it took to find all items within the tree and divides by the number of items. This gives the average amount of time to find one item.
				double averageRuntime = totalTime / (double)sizeSet;
				// Prints out the results.
				System.out.println("SetSize: " + sizeSet + " AverageTimeRun: " + averageRuntime);
				fileOut.write(sizeSet + "\t" + averageRuntime + "\n");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
