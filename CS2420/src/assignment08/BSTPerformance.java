package assignment08;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

/**
 * This is the code used for timing.
 * The timing code does the following:
 * 
 * Add N items to a TreeSet in a random order and record the time required to do this.
 * Record the time required to invoke the contains method for each item in the TreeSet.
 * Add the same N items (in the same random order) as in #1 to a BinarySearchTree and record the time required to do this.
 * Record the time required to invoke the contains method for each item in the BinarySearchTree.
 * 
 * @author Brandon Mouser & Kale Thompson
 *
 */
public class BSTPerformance {
	public static void main(String[] args) {
		// Initial number of items within the tree.
		int sizeSet = 1000;
		// Writes all information to the files.
		try (FileWriter treeContains = new FileWriter("TreeSetContains.txt")) {
			try (FileWriter binaryContains = new FileWriter("BinaryTreeContains.txt")) {
				try (FileWriter treeAdd = new FileWriter("TreeSetAdd.txt")) {
					try (FileWriter binaryAdd = new FileWriter("BinaryTreeAdd.txt")) {
			// Runs the for loop the necessary amount of times to reach a value of 10000 items.
			for (int exp = 0; exp <= 90; exp++) {
				// Initializes the value of all timing variables.
				long totalBinaryTreeTime = 0;
				long totalTreeSetTime = 0;
				long totalBinaryAddTime = 0;
				long totalTreeAddTime = 0;
				// Creates a new BinarySearchTree
				BinarySearchTree<Integer> tempBinaryTree = new BinarySearchTree<Integer>();
				// Creates a new TreeSet
				TreeSet<Integer> tempTree = new TreeSet<Integer>();
				// Creates a new ArrayList
				ArrayList<Integer> tempArray = new ArrayList<Integer>();
				// Adds the specified number of items into the Array.
				for(int i = 1; i <= sizeSet; i++){
					tempArray.add(i);
				}
				// Shuffle the ArrayList so TreeSet and BinarySearchTree get numbers in random order.
				Collections.shuffle(tempArray);
				
				// The amount of time that it takes to add all items to a BinarySearchTree.
				for(int i = 0; i < tempArray.size(); i++){
					int numberToAdd = tempArray.get(i);
					long startRun = System.nanoTime();
					tempBinaryTree.add(numberToAdd);
					long stopRun = System.nanoTime();
					totalBinaryAddTime += stopRun - startRun;
				}
				
				// The amount of time it takes to add all items to a TreeSet
				for(int i = 0; i < tempArray.size(); i++){
					int numberToAdd = tempArray.get(i);
					long startRun = System.nanoTime();
					tempTree.add(numberToAdd);
					long stopRun = System.nanoTime();
					totalTreeAddTime += stopRun - startRun;
				}
				
				// The amount of time it takes to find each time within the BinarySearchTree.
				for(int i = 1; i<= sizeSet; i++){
					long startRun = System.nanoTime();
					tempBinaryTree.contains(i);
					long stopRun = System.nanoTime();
					totalBinaryTreeTime += stopRun - startRun;
				}
				
				// The amount of time it takes to find each item within the TreeSet.
				for(int i = 1; i<= sizeSet; i++){
					long startRun = System.nanoTime();
					tempTree.contains(i);
					long stopRun = System.nanoTime();
					totalTreeSetTime += stopRun - startRun;
				}
				
				// Clears all lists so the next experiment is not effected.
				tempBinaryTree.clear();
				tempArray.clear();
				tempTree.clear();
				// Averages the total time it took to find or add all items and divides by the number of items. Results in the 
				// average time it takes to add or find an individual item.
				double averageBinaryRuntime = totalBinaryTreeTime / (double)sizeSet;
				double averageTreeSetRuntime = totalTreeSetTime / (double)sizeSet;
				double averageTreeAddTime = totalTreeAddTime / (double)sizeSet;
				double averageBinaryAddTime = totalBinaryAddTime / (double)sizeSet;
				
				// Records the final data to the appropriate files.
				binaryAdd.write(sizeSet + "\t" + averageBinaryAddTime + "\n");
				treeAdd.write(sizeSet + "\t" + averageTreeAddTime + "\n");
				binaryContains.write(sizeSet + "\t" + averageBinaryRuntime + "\n");
				treeContains.write(sizeSet + "\t" + averageTreeSetRuntime + "\n");
				// Increments the number of items to be added in the next experiment.
				sizeSet+= 100;
			}
			System.out.println("Gorlami");
			}
					catch (IOException e) {
						e.printStackTrace();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		} catch (IOException e3) {
			e3.printStackTrace();
		}
	}
}