package assignment09;

import java.util.LinkedList;

/**
 * This is just a basic Node class that is used by the PathFinder class.
 * The Node created has a reference to its data, a LinkedList of its neighbors, a reference to the 
 * Node before it, and a boolean to check to see if it has been visited or not.
 * 
 * @author Brandon Mouser and Kale Thompson
 */
public class Node {
		public char data;
		public boolean visited;
		public Node prev;
		public LinkedList<Node> neighbors = new LinkedList<Node>();
}
