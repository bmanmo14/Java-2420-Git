package assignment08;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements SortedSet and creates a new BinarySearchTree with any
 * kind of type. The BinarySearchTree stores data in Nodes. Each Node has a
 * reference to the data it contains, the node to the right and the node to the
 * left. The Nodes are organized based on the value of the data in the Node. The
 * data in the Node to the left is guaranteed to be less than the data in the
 * current Node, and the data in the Node to the right is guaranteed to be more
 * than the data in the current Node.
 * 
 * @author Brandon Mouser and Kale Thompson
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements SortedSet<T> {

	private BinarySearchNode<T> binaryNode;
	private BinarySearchNode<T> temp;
	private int count;
	ArrayList<T> toArray = null;

	/**
	 * This is just a basic constructor for a BinarySearchTree. It creates a new
	 * empty tree with nothing in it.
	 */
	public BinarySearchTree() {
		binaryNode = null;
		count = 0;
	}

	@Override
	public boolean add(T item) {
		if (item == null) {
			throw new NullPointerException();
		}
		if (binaryNode == null) {
			binaryNode = new BinarySearchNode<T>(item);
			count++;
			return true;
		} else if (contains(item)) {
			return false;
		} else {
			addRecursive(item, binaryNode);
			if (contains(item) == true) {
				count++;
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * This function is used by the add function to find the correct position
	 * within a tree to place the new item. Compares the data at the current
	 * Node to the the item passed in and if the data is less than or greater
	 * than, the method moves to either the left or the right node. Continues
	 * this process until the value of null is found.
	 * 
	 * @param item
	 *            (The Item you wish to add to the BinarySearchTree).
	 * @param node
	 *            (The Node you initially start looking at).
	 */
	private void addRecursive(T item, BinarySearchNode<T> node) {
		BinarySearchNode<T> itemAdded = new BinarySearchNode<T>(item);
		if (item.compareTo(node.data) < 0) {
			if (node.left == null) {
				node.left = itemAdded;
				return;
			}
			if (node.left != null) {
				addRecursive(item, node.left);
				return;
			}
		} else {
			if (node.right == null) {
				node.right = itemAdded;
				return;
			}
			if (node.right != null) {
				addRecursive(item, node.right);
				return;
			}
		}
	}

	@Override
	public boolean addAll(Collection<? extends T> items) {
		Iterator<? extends T> itr = (Iterator<? extends T>) items.iterator();
		while (itr.hasNext()) {
			add(itr.next());
		}
		if (containsAll(items)) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		binaryNode = null;
		count = 0;
	}

	@Override
	public boolean contains(T item) {
		if (item == null) {
			throw new NullPointerException();
		} else {
			return containsRecursive(item, binaryNode);
		}
	}

	/**
	 * This is the recursive method used by contains the traverse the
	 * BinarySearchTree until the desired Item is found. The method will
	 * continue traversing the list until either the value of item is found, or
	 * the value of null is found. If null is found that means that the item
	 * does not exist within the BinaryTree.
	 * 
	 * @param item
	 *            (The item you are looking for).
	 * @param node
	 *            (The Node you begin looking at).
	 * @return Boolean (True if the item exists within the tree).
	 */
	private boolean containsRecursive(T item, BinarySearchNode<T> node) {
		if (size() == 0) {
			return false;
		}
		if (node == null) {
			return false;
		}
		if (item.compareTo(node.data) == 0) {
			return true;
		}
		if (item.compareTo(node.data) < 0) {
			return containsRecursive(item, node.left);
		} else {
			return containsRecursive(item, node.right);
		}
	}

	@Override
	public boolean containsAll(Collection<? extends T> items) {
		if (items.size() == 0) {
			throw new NoSuchElementException();
		}
		Iterator<? extends T> itr = (Iterator<? extends T>) items.iterator();
		while (itr.hasNext()) {
			if (contains(itr.next()) != true) {
				return false;
			}
		}
		return true;
	}

	@Override
	public T first() throws NoSuchElementException {
		if (binaryNode == null) {
			throw new NoSuchElementException();
		}
		temp = binaryNode;
		if (temp.left == null) {
			return temp.data;
		}
		while (temp.left.left != null) {
			temp.left = temp.left.left;
		}
		return temp.left.data;
	}

	@Override
	public boolean isEmpty() {
		if (binaryNode == null && count == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T last() throws NoSuchElementException {
		if (binaryNode == null) {
			throw new NoSuchElementException();
		}
		temp = binaryNode;
		if (temp.right == null) {
			return temp.data;
		}
		while (temp.right.right != null) {
			temp.right = temp.right.right;
		}
		return temp.right.data;
	}

	@Override
	public boolean remove(T item) {
		if (item == null) {
			throw new NullPointerException();
		}

		if (!contains(item) || binaryNode == null) {
			return false;
		}
		if (size() == 1) {
			clear();
			return true;
		} else {
			removeRecursive(item, binaryNode);
			if (!contains(item)) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * This is the recursive method used by the remove function. The method
	 * traverses a BinarySearchTree until it finds the item passed in. It will
	 * then update the references of the surrounding nodes to delete the desired
	 * Node.
	 * 
	 * @param item
	 *            (The item you wish to delete).
	 * @param node
	 *            (The Node you begin looking at).
	 */
	private void removeRecursive(T item, BinarySearchNode<T> node) {
		// If the item being removed is our root node.
		if (item.equals(node.data)) {
			if (node.right != null && node.left == null) {
				node.left = node.right.left;
				node.data = node.right.data;
				node.right = node.right.right;
			} else if (node.right == null && node.left != null) {
				node.data = node.left.data;
				node.left = node.left.left;
			} else if (node.right != null && node.left != null) {
				BinarySearchNode<T> removeable = node.getSuccessor();
				if (removeable.left == null) {
					node.data = removeable.data;
					node.right = removeable.right;
				} else {
					node.data = removeable.left.data;
					node.right = removeable;
					removeable.left = removeable.left.right;
				}
			}
			count--;
			return;
		}

		if (node.left != null && item.equals(node.left.data)) {
			if (node.left.right == null && node.left.left == null) {
				node.left = null;
				count--;
				return;
			}

		} else if (node.right != null && item.equals(node.right.data)) {
			if (node.right.right == null && node.right.left == null) {
				node.right = null;
				count--;
				return;
			}
		}

		if (item.compareTo(node.data) < 0) {
			removeRecursive(item, node.left);
			return;
		} else {
			removeRecursive(item, node.right);
			return;
		}
	}

	@Override
	public boolean removeAll(Collection<? extends T> items) {
		Iterator<? extends T> itr = (Iterator<? extends T>) items.iterator();
		if (!containsAll(items)) {
			return false;
		}
		while (itr.hasNext()) {
			remove(itr.next());
		}
		return true;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public ArrayList<T> toArrayList() {
		toArray = new ArrayList<T>();
		if (binaryNode == null) {
			ArrayList<T> emptyList = new ArrayList<T>();
			return emptyList;
		}
		traverse(binaryNode);
		Collections.sort(toArray);
		return toArray;
	}

	/**
	 * 
	 * @param node
	 */
	private void traverse(BinarySearchNode<T> node) {
		if (node == null) {
			return;
		}
		toArray.add(node.data);
		traverse(node.left);
		traverse(node.right);
	}

	/**
	 * Creates a new dot file that can be executed to create a graph of the
	 * BinarySearchTree
	 * 
	 * @param filename
	 */
	public void writeDot(String filename) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter(filename));

			// Set up the dot graph and properties
			output.println("digraph BST {");
			output.println("node [shape=record]");

			if (binaryNode != null)
				writeDotRecursive(binaryNode, output);
			// Close the graph
			output.println("}");
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Traverses through the BinarySearchTree and creates a graphical
	 * representation of each Node. Continues traversing the Node until it
	 * reaches Null.
	 * 
	 * @param node (The Node you start with).
	 * @param output (The file you wish to make the graph in)>
	 * @throws Exception
	 */
	private void writeDotRecursive(BinarySearchNode<T> node, PrintWriter output) throws Exception {
		output.println(node.data + "[label=\"<L> |<D> " + node.data + "|<R> \"]");
		if (node.left != null) {
			// write the left subtree
			writeDotRecursive(node.left, output);

			// then make a link between n and the left subtree
			output.println(node.data + ":L -> " + node.left.data + ":D");
		}
		if (node.right != null) {
			// write the right subtree
			writeDotRecursive(node.right, output);

			// then make a link between n and the right subtree
			output.println(node.data + ":R -> " + node.right.data + ":D");
		}

	}

}
