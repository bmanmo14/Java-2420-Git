package assignment08;

/** 
 * This class creates a new BinarySearchNode and contains several helper methods that make accessing data within the Nodes easy.
 * This class is meant to be used with the BinarySearchTree class. This class uses type T, which means that any object type can 
 * used to make a Node.
 * @author Brandon Mouser & Kale Thompson
 *
 * @param <T> -- The type the user specifies.
 */
public class BinarySearchNode<T extends Comparable<? super T>> {

	public T data;
	public BinarySearchNode<T> left;
	public BinarySearchNode<T> right;

	/**
	 * Construct a new node with known children that are set to null.
	 * 
	 */
	public BinarySearchNode(T data, BinarySearchNode<T> left,
			BinarySearchNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	/**
	 * This is just a basic constructor for the BinarySearchNode class. It creates a new Node with
	 * a specified data and no left or right children.
	 * 
	 */
	public BinarySearchNode(T data) {
		this(data, null, null);
	}

	/**
	 * This function returns the leftmost node in the Binary Tree.
	 * 
	 * @return The leftmost node in the binary tree rooted at this node.
	 */
	public BinarySearchNode<T> getLeftmostNode() {
		// Base case, done for you
		if (this.left == null) {
			return this; // returns "this" node
		}
		
		BinarySearchNode<T> parentOfSuccessor = new BinarySearchNode<T>(null);
		parentOfSuccessor = this;
		while(parentOfSuccessor.left.left != null){
			parentOfSuccessor.left = parentOfSuccessor.left.left;
		}
		return parentOfSuccessor; 
	}

	/**
	 * This function returns the rightmost node in the Binary Tree.
	 * @return The rightmost node in the binary tree rooted at this node.
	 */
	public BinarySearchNode<T> getRightmostNode() {
		// Base case, done for you
		if (this.right == null) {
			return this; // returns "this" node
		}
		BinarySearchNode<T> temp = new BinarySearchNode<T>(null);
		temp = this;
		while(temp.right.right != null){
			temp.right = temp.right.right;
		}
		return temp; 
	}
	/**
	 * This method returns the parent to the successor of the current node. 
	 * 
	 * @return The successor of this node.
	 *         The successor is a node which can replace this node in a case-3
	 *         BST deletion. It is either the smallest node in the right
	 *         subtree, or the largest node in the left subtree.
	 */
	public BinarySearchNode<T> getSuccessor() {
		BinarySearchNode<T> temp = new BinarySearchNode<T>(null);
		temp = this;
		if (temp.right == null && temp.left == null) {
			return temp; // returns "this" node
		}
		else if(temp.right != null){
			return temp.right.getLeftmostNode();
		}
		else if(temp.right == null){ 
			return temp.left.getRightmostNode();
		}
		return null;
	}
}
